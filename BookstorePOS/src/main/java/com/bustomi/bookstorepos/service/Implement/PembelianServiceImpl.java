/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.Saldo;
import com.bustomi.bookstorepos.entity.laporan.Jurnal;
import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.entity.transaksi.DetailPembelian;
import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.service.JurnalService;
import com.bustomi.bookstorepos.service.PembelianService;
import com.bustomi.bookstorepos.service.SaldoService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void save(Pembelian pembelian) {
        Session session=currentSession();
        session.save(pembelian);
        
        for (DetailPembelian detailPembelian : pembelian.getDaftarPembelian()) {
            Item item=detailPembelian.getItem();
            item.setStok(item.getStok() + detailPembelian.getJumlah());
            session.update(item);
        }
        
        Saldo saldo=saldoService.find("saldo-terakhir");
        BigDecimal nilai=saldo.getNilai().subtract(pembelian.getTotal());
        
        Jurnal jurnal=new Jurnal();
        jurnal.setDebit(BigDecimal.ZERO);
        jurnal.setKredit(pembelian.getTotal());
        jurnal.setNama("Pembelian : No " + pembelian.getId() + " Dari " + pembelian.getPemasok().getNama());
        jurnal.setSaldo(nilai);
        jurnal.setSaldoSebelumnya(saldo.getNilai());
        jurnal.setWaktu(pembelian.getWaktu_transaksi());
        
        saldoService.update(saldo);
        jurnalService.save(jurnal);
    }

    @Override
    public List<Pembelian> findAll(Date from, Date to) {
        
        Session session=currentSession();
        return session.createQuery("select a from Pembelian a where date(a.waktu_transaksi) between date(:from) "
                + "and date(:to)").setDate("from", from).setDate("to", to).list();
    }

    @Override
    public List<Pembelian> findAll() {
        return currentSession().createCriteria(Pembelian.class).list();
    }
   
}
