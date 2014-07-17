/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.User;

import com.bustomi.bookstorepos.entity.Entity;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "HakAkses")
public class HakAkses extends Entity<String>{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @ManyToMany(mappedBy = "daftarHakAkses")
    private List<Grup> daftarGrup;

    public List<Grup> getDaftarGrup() {
        return Collections.unmodifiableList(daftarGrup);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
}
