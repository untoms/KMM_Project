/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author PacuL
 * @param <T>
 */
@MappedSuperclass
public abstract class SimpleEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column (name = "name", nullable = false, length = 140)
    private String nama;

    @Column(name = "info", nullable = true, length = 255)
    private String info;

    public abstract T getId();

    public abstract void setId(T id);

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        final SimpleEntity<T> other = (SimpleEntity<T>) obj;
        if (this.getId() != other.getId() && (this.getId() == null
                || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getNama();
    }
    
    
}
