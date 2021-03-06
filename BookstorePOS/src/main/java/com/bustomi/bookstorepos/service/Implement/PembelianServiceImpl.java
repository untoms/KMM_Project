/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.Saldo;
import com.bustomi.bookstorepos.entity.laporan.Jurnal;
import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.entity.transaksi.Penjualan;
import com.bustomi.bookstorepos.service.JurnalService;
import com.bustomi.bookstorepos.service.PembelianService;
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
public class PembelianServiceImpl implements PembelianService{
    
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
    public void save(Pembelian pembelian) {
        Session session=currentSession();
        session.save(pembelian);
        
        Saldo saldo=saldoService.find("saldo-terakhir");
        BigDecimal nilai=saldo.getNilai().subtract(pembelian.getBayar());
        
        Jurnal jurnal=new Jurnal();
        jurnal.setDebit(BigDecimal.ZERO);
        jurnal.setKredit(pembelian.getBayar());
        jurnal.setNama("Pembelian : No " + pembelian.getId() + " Dari " + pembelian.getPemasok().getNama());
        jurnal.setSaldo(nilai);
        jurnal.setSaldoSebelumnya(saldo.getNilai());
        jurnal.setWaktu(pembelian.getWaktu_transaksi());
        
        saldo.setNilai(nilai);
        saldoService.update(saldo);
        jurnalService.save(jurnal);
    }
    
    @Transactional
    @Override
    public void update(Pembelian pembelian) {
        Session session=currentSession();
        session.update(pembelian);
                
        Saldo saldo=saldoService.find("saldo-terakhir");
        BigDecimal nilai=saldo.getNilai().subtract(pembelian.getBayar_terakhir());
        
        Jurnal jurnal=new Jurnal();
        jurnal.setDebit(BigDecimal.ZERO);
        jurnal.setKredit(pembelian.getBayar_terakhir());
        jurnal.setNama("Pembayaran hutang : No " + pembelian.getId() + " Kepada " + pembelian.getPemasok().getNama());
        jurnal.setSaldo(nilai);
        jurnal.setSaldoSebelumnya(saldo.getNilai());
        jurnal.setWaktu(pembelian.getWaktu_transaksi());
        
        saldo.setNilai(nilai);
        saldoService.update(saldo);
        jurnalService.save(jurnal);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Pembelian> findAll(Date from, Date to) {
        
        Session session=currentSession();
        return session.createQuery("select a from Pembelian a where date(a.waktu_transaksi) between date(:from) "
                + "and date(:to)").setDate("from", from).setDate("to", to).list();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Pembelian> findAll() {
        return currentSession().createCriteria(Pembelian.class).list();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Pembelian> findHutang() {
        Session session=currentSession();
        return session.createQuery("select a from Pembelian a where a.total > a.bayar").list();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Pembelian> findHutangTgl(Date from, Date to) {
        Session session=currentSession();
        return session.createQuery("select a from Pembelian a where a.total > a.bayar and "
                + "date(a.waktu_transaksi) between date(:from) "
                + "and date(:to)").setDate("from", from).setDate("to", to).list();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Pembelian> grafik(Date from, Date to) {
        
        Criteria criteria=currentSession().createCriteria(Pembelian.class);
        criteria.add(Restrictions.between("waktu_transaksi", from, to));
        
        ProjectionList projection=Projections.projectionList();
        projection.add(Projections.rowCount(), "jumlah");
        projection.add(Projections.sum("bayar").as("totals"));
        projection.add(Projections.sqlGroupProjection("date(waktu_transaksi) as waktu", 
                "waktu", new String[] { "waktu" },
                new Type[] { StandardBasicTypes.DATE }));
        
        criteria.setProjection(projection);
        criteria.setResultTransformer(new AliasToBeanResultTransformer(Penjualan.class));
        
        return criteria.list();
    }
   
}
