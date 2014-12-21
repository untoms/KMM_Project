/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.master.Buku;
import java.util.List;

/**
 *
 * @author PacuL
 */
public interface BukuService extends InterfaceService<Buku, Integer>{
    
    List<Buku> findPengarang(String nama, Integer pageNumber, Integer rowsPerPage);
    List<Buku> findPenerbit(String nama, Integer pageNumber, Integer rowsPerPage);
    List<Buku> findKategori(String nama, Integer pageNumber, Integer rowsPerPage);
    Integer countPengarang(String nama);
    Integer countPenerbit(String nama);
    Integer countKategori(String nama);
    
}
