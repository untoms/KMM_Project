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

    @Override
    public void validate(T data) throws ValidatorException {

        doValidate(data);

        if (data instanceof Entity<?>) {
            Entity<?> entity = (Entity<?>) data;
            validateEntity(entity);
        }else if(data instanceof SimpleEntity){
            SimpleEntity<?> entity=(SimpleEntity<?>) data;
            validateEntity(entity);
        }
    }

    protected void validateEntity(Entity<?> entity) throws ValidatorException {
        if (entity.getNama() == null) {
            throwValidatorException("Nama atau judul tidak boleh null");
        } else if (entity.getNama().trim().isEmpty()) {
            throwValidatorException("Nama atau judul tidak boleh kosong");
        } else if (entity.getWaktuDibuat() == null) {
            throwValidatorException("Waktu dibuat tidak boleh null");
        } else if(entity.getNama().length() > 140){
            throwValidatorException("Karakter nama atau judul terlalu panjang");
        } else if (entity.getInfo().length() > 255){
            throwValidatorException("Karakter info terlalu panjang");
        }
    }
    
    protected void validateEntity(SimpleEntity<?> entity) throws ValidatorException {
        if (entity.getNama()== null) {
            throwValidatorException("Nama tidak boleh null");
        } else if (entity.getNama().trim().isEmpty()) {
            throwValidatorException("Nama tidak boleh kosong");
        } else if(entity.getNama().length() > 140){
            throwValidatorException("Karakter nama terlalu panjang");
        } else if (entity.getInfo().length() > 255){
            throwValidatorException("Karakter info terlalu panjang");
        }
    }

    protected abstract void doValidate(T data) throws ValidatorException;
    
}
