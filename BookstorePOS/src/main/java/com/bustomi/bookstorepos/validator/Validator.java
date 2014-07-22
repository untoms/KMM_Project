/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator;

/**
 *
 * @author PacuL
 */
public interface Validator<T> {
    
    void validate(T data) throws ValidatorException;
    
}
