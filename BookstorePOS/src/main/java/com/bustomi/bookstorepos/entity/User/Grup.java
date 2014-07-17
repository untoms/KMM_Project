/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.User;

import com.bustomi.bookstorepos.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "Grup")
public class Grup extends Entity<Integer>{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tabel_join_grup_dan_hak_akses", joinColumns =
    @JoinColumn(name = "id_grup", nullable = false), inverseJoinColumns =
    @JoinColumn(name = "id_hak_akses", nullable = false))
    private List<HakAkses> daftarHakAkses = new ArrayList<>(0);

    @OneToMany(mappedBy = "grup")
    private List<User> daftarUser;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public List<HakAkses> getDaftarHakAkses() {
        return daftarHakAkses;
    }

    public void setDaftarHakAkses(List<HakAkses> daftarHakAkses) {
        this.daftarHakAkses = daftarHakAkses;
    }

    public List<User> getDaftarUser() {
        return daftarUser;
    }

    public void setDaftarUser(List<User> daftarUser) {
        this.daftarUser = daftarUser;
    }
    
    
    
}
