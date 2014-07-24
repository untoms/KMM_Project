/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.Person;
import com.bustomi.bookstorepos.entity.transaksi.Penjualan;
import java.util.Collections;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "Pelanggan")
public class Pelanggan extends Person{
               
    @OneToMany(mappedBy = "pelanggan")
    private List<Penjualan> daftarPenjualan;
   
    public List<Penjualan> getDaftarPenjualan() {
        return Collections.unmodifiableList(daftarPenjualan);
    }

    public void setDaftarPenjualan(List<Penjualan> daftarPenjualan) {
        this.daftarPenjualan = daftarPenjualan;
    }
        
}
