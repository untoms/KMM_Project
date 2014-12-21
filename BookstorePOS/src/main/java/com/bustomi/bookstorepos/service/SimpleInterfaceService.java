/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.SimpleEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PacuL
 * @param <T>
 * @param <Id>
 */
public interface SimpleInterfaceService <T extends SimpleEntity<?>, Id extends Serializable>{
    
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T find(Id kode);
    T find(String nama);
    List<T> findAll();
    List<T> findAll(String nama);
    List<T> findAll(Integer pageNumber, Integer rowsPerPage);
    Integer countRows();
}
