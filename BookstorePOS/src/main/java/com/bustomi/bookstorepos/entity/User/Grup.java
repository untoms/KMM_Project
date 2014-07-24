/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.User;

import com.bustomi.bookstorepos.entity.Entity;
import com.bustomi.bookstorepos.entity.SimpleEntity;
import java.util.ArrayList;
import java.util.Collections;
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
public class Grup extends SimpleEntity<Integer>{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "grup_has_hak_akses", joinColumns =
    @JoinColumn(name = "group_id", nullable = false), inverseJoinColumns =
    @JoinColumn(name = "hak_akses_id", nullable = false))
    private final List<HakAkses> daftarHakAkses = new ArrayList<>(0);

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

    public List<User> getDaftarUser() {
        return Collections.unmodifiableList(daftarUser);
    }

    public void setDaftarUser(List<User> daftarUser) {
        this.daftarUser = daftarUser;
    }

    public void tambahHakAkses(HakAkses hakAkses) {
        if (!daftarHakAkses.contains(hakAkses)) {
            daftarHakAkses.add(hakAkses);
        }
    }

    public void hapusHakAkses(HakAkses hakAkses) {
        if (daftarHakAkses.contains(hakAkses)) {
            daftarHakAkses.remove(hakAkses);
        }
    }

    public boolean mengandungHakAkses(Role constant) {
        for (HakAkses akses : daftarHakAkses) {
            if (akses.getId().equals(constant.toString())) {
                return true;
            }
        }
        return false;
    }

    public void hapusSemuaHakAkses() {
        daftarHakAkses.clear();
    }
    
    public List<HakAkses> getDaftarHakAkses() {
        return Collections.unmodifiableList(daftarHakAkses);
    }
          
}
