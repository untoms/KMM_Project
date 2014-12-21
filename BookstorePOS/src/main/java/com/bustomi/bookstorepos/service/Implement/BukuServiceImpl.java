/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.Buku;
import com.bustomi.bookstorepos.service.AbstractService;
import com.bustomi.bookstorepos.service.BukuService;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class BukuServiceImpl extends AbstractService<Buku, Integer>implements BukuService{

    public BukuServiceImpl() {
        super(Buku.class);
    }
    
    @Transactional (readOnly = true)
    @Override
    public List<Buku> findPengarang(String nama, Integer pageNumber, Integer rowsPerPage){
        Query query=currentSession().createQuery(
                "select b from Buku b INNER JOIN b.daftarPengarang p with p.nama LIKE :nama");
        query.setParameter("nama", "%"+nama+"%");
        query.setFirstResult(rowsPerPage*(pageNumber-1));
        query.setMaxResults(rowsPerPage);
        return query.list();
    }
    
    @Transactional (readOnly = true)
    @Override
    public List<Buku> findPenerbit(String nama, Integer pageNumber, Integer rowsPerPage){
        Query query=currentSession().createQuery("select b from Buku b WHERE b.penerbit.nama LIKE :nama");
        query.setParameter("nama", "%"+nama+"%");
        query.setFirstResult(rowsPerPage*(pageNumber-1));
        query.setMaxResults(rowsPerPage);
        return query.list();
    }
    
    @Transactional (readOnly = true)
    @Override
    public List<Buku> findKategori(String nama, Integer pageNumber, Integer rowsPerPage){
        Query query=currentSession().createQuery(""
                + "select b from Buku b WHERE b.kategoriBuku.nama LIKE :nama");
        query.setParameter("nama", "%"+nama+"%");
        query.setFirstResult(rowsPerPage*(pageNumber-1));
        query.setMaxResults(rowsPerPage);
        return query.list();
    }
    
    @Transactional (readOnly = true)
    @Override
    public Integer countKategori(String nama) {
        Query query = currentSession().createQuery(""
                + "select count(*) from Buku b WHERE b.kategoriBuku.nama LIKE :nama");
        query.setParameter("nama", "%"+nama+"%");
        Long totalRow=(Long)query.uniqueResult();
        
        return totalRow.intValue();
    }
    
    @Transactional (readOnly = true)
    @Override
    public Integer countPenerbit(String nama) {
        Query query = currentSession().createQuery(
                "select count(*) from Buku b WHERE b.penerbit.nama LIKE :nama");
        query.setParameter("nama", "%"+nama+"%");
        Long totalRow=(Long)query.uniqueResult();
        
        return totalRow.intValue();
    }
    
    @Transactional (readOnly = true)
    @Override
    public Integer countPengarang(String nama) {
        Query query = currentSession().createQuery(
                "select count(*) from Buku b INNER JOIN b.daftarPengarang p with p.nama LIKE :nama");
        query.setParameter("nama", "%"+nama+"%");
        Long totalRow=(Long)query.uniqueResult();
        
        return totalRow.intValue();
    }
    
}
