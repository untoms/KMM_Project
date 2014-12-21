/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.Saldo;
import com.bustomi.bookstorepos.entity.laporan.Jurnal;
import com.bustomi.bookstorepos.entity.transaksi.Pemasukan;
import com.bustomi.bookstorepos.service.AbstractService;
import com.bustomi.bookstorepos.service.JurnalService;
import com.bustomi.bookstorepos.service.PemasukanService;
import com.bustomi.bookstorepos.service.SaldoService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class PemasukanServiceImpl extends AbstractService<Pemasukan, Long> implements PemasukanService{
    
    @Autowired
    private JurnalService jurnalService;
    
    @Autowired
    private SaldoService saldoService;

    public PemasukanServiceImpl() {
        super(Pemasukan.class);
    }

    @Override
    @Transactional
    public void save(Pemasukan entity) {
        super.save(entity); //To change body of generated methods, choose Tools | Templates.
        
        Saldo saldo=saldoService.find("saldo-terakhir");
        BigDecimal nilai=saldo.getNilai().add(entity.getJumlah());
        
        Jurnal jurnal=new Jurnal();
        jurnal.setDebit(entity.getJumlah());
        jurnal.setKredit(BigDecimal.ZERO);
        jurnal.setNama("Pemasukan : Id = "+entity.getId()+". "+entity.getNama());
        jurnal.setSaldo(nilai);
        jurnal.setSaldoSebelumnya(saldo.getNilai());
        jurnal.setWaktu(entity.getWaktuDibuat());
        
        saldo.setNilai(nilai);
        saldoService.update(saldo);
        jurnalService.save(jurnal);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Pemasukan> findAll(Date from, Date to) {
        return currentSession().createCriteria(clazz).
                add(Restrictions.between("waktuDibuat", from, to)).list();
    }
    
    
    
}
