/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.Entity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PacuL
 * @param <T>
 * @param <Id>
 */
public interface InterfaceService <T extends Entity<?>, Id extends Serializable>{
    
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T find(Id kode);
    List<T> findAll();    
    List<T> findAll(String nama);
    List<T> findAll(Integer pageNumber, Integer rowsPerPage);
    List<T> findAll(String nama, Integer pageNumber, Integer rowsPerPage);
    Integer countRows();
    Integer countNama(String nama);
    
}
