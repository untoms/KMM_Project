/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.Saldo;
import com.bustomi.bookstorepos.entity.laporan.Jurnal;
import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.entity.transaksi.DetailPenjualan;
import com.bustomi.bookstorepos.entity.transaksi.Penjualan;
import com.bustomi.bookstorepos.service.JurnalService;
import com.bustomi.bookstorepos.service.PenjualanService;
import com.bustomi.bookstorepos.service.SaldoService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class PenjualanServiceImpl implements PenjualanService{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private SaldoService saldoService;
    
    @Autowired
    private JurnalService jurnalService;
    
    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SaldoService getSaldoService() {
        return saldoService;
    }

    public void setSaldoService(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    public JurnalService getJurnalService() {
        return jurnalService;
    }

    public void setJurnalService(JurnalService jurnalService) {
        this.jurnalService = jurnalService;
    }
    
    @Transactional
    @Override
    public void save(Penjualan penjualan) {
        Session session=currentSession();
        session.save(penjualan);
        
        for (DetailPenjualan detailPenjualan : penjualan.getDaftarPenjualan()) {
            Item item=detailPenjualan.getItem();
            item.setStok(item.getStok() - detailPenjualan.getJumlah());
            session.update(item);
        }
        
        Saldo saldo=saldoService.find("saldo-terakhir");
        BigDecimal nilai=saldo.getNilai().add(penjualan.getTotal());
        
        Jurnal jurnal=new Jurnal();
        jurnal.setDebit(penjualan.getTotal());
        jurnal.setKredit(BigDecimal.ZERO);
        jurnal.setNama("Penjualan : No " + penjualan.getId() + " Kepada " + penjualan.getPelanggan().getNama());
        jurnal.setSaldo(nilai);
        jurnal.setSaldoSebelumnya(saldo.getNilai());
        jurnal.setWaktu(penjualan.getWaktu_transaksi());
        saldo.setNilai(nilai);
        saldoService.update(saldo);
        jurnalService.save(jurnal);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Penjualan> findAll(Date from, Date to) {
        
        Session session=currentSession();
        return session.createQuery("select a from Penjualan a where date(a.waktu_transaksi) between date(:from) "
                + "and date(:to)").setDate("from", from).setDate("to", to).list();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Penjualan> findAll() {
        return currentSession().createCriteria(Penjualan.class).list();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Penjualan> grafik(Date from, Date to) {
        
//        return currentSession().createSQLQuery("select date(a.waktu_transaksi) as waktu, count(*) as jumlah,"
//                + " sum(a.total) as total"
//                + " from Penjualan a where date(a.waktu_transaksi) between date(:from) "
//                + "and date(:to) group by a.waktu_transaksi").setDate("from", from).setDate("to", to)
//                .list();     
        Criteria criteria=currentSession().createCriteria(Penjualan.class);
        criteria.add(Restrictions.between("waktu_transaksi", from, to));
        
        ProjectionList projection=Projections.projectionList();
        projection.add(Projections.rowCount(), "jumlah");
        projection.add(Projections.sum("total").as("totals"));
//        projection.add(Projections.groupProperty("waktu_transaksi"));
        projection.add(Projections.sqlGroupProjection("date(waktu_transaksi) as waktu", 
                "waktu", new String[] { "waktu" },
                new Type[] { StandardBasicTypes.DATE }));
        
        criteria.setProjection(projection);
        criteria.setResultTransformer(new AliasToBeanResultTransformer(Penjualan.class));
        
        return criteria.list();
    }
    
    @Transactional(readOnly=true)    
    @Override
    public Long hitungtrans(){
        return (Long) currentSession().createCriteria(Penjualan.class)
                .setProjection(Projections.rowCount()).uniqueResult();
    }
    
}
