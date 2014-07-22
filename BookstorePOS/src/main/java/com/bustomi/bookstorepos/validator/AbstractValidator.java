/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator;

import com.bustomi.bookstorepos.entity.Entity;
import com.bustomi.bookstorepos.entity.SimpleEntity;

/**
 *
 * @author PacuL
 */
public abstract class AbstractValidator<T> implements Validator<T>{
    
    protected void throwValidatorException(String message) throws ValidatorException {
        throw new ValidatorException(message);
    }

    public void validate(T data) throws ValidatorException {

        doValidate(data);

        if (data instanceof Entity<?>) {
            Entity<?> entity = (Entity<?>) data;
            validateEntity(entity);
        }else if(data instanceof SimpleEntity){
            validate(data);
        }
    }

    protected void validateEntity(Entity<?> entity) throws ValidatorException {
        if (entity.getId() == null) {
            throwValidatorException("Kode tidak boleh null");
        }else if (entity.getNama() == null) {
            throwValidatorException("Nama tidak boleh null");
        } else if (entity.getNama().trim().isEmpty()) {
            throwValidatorException("Nama tidak boleh kosong");
        } else if (entity.getWaktuDibuat() == null) {
            throwValidatorException("Waktu dirubah tidak boleh null");
        } 
    }
    
    protected void validateEntity(SimpleEntity<?> entity) throws ValidatorException {
        if (entity.getId() == null) {
            throwValidatorException("Kode tidak boleh null");
        }else if (entity.getNama()== null) {
            throwValidatorException("Nama tidak boleh null");
        } else if (entity.getNama().trim().isEmpty()) {
            throwValidatorException("Nama tidak boleh kosong");
        } 
    }

    protected abstract void doValidate(T data) throws ValidatorException;
    
}
