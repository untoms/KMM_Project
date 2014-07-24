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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        
        saldoService.update(saldo);
        jurnalService.save(jurnal);
    }

    @Override
    public List<Penjualan> findAll(Date from, Date to) {
        
        Session session=currentSession();
        return session.createQuery("select a from Penjualan a where date(a.waktu_transaksi) between date(:from) "
                + "and date(:to)").setDate("from", from).setDate("to", to).list();
    }
    
}
