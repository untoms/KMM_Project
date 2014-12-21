/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator;

import com.bustomi.bookstorepos.entity.Entity;
import com.bustomi.bookstorepos.entity.SimpleEntity;
import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.entity.master.KategoriBarang;
import com.bustomi.bookstorepos.entity.master.KategoriBuku;
import com.bustomi.bookstorepos.entity.master.Penerbit;
import com.bustomi.bookstorepos.entity.master.Pengarang;
import com.bustomi.bookstorepos.entity.master.Satuan;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.GrupService;
import com.bustomi.bookstorepos.service.KategoriBarangService;
import com.bustomi.bookstorepos.service.KategoriBukuService;
import com.bustomi.bookstorepos.service.PenerbitService;
import com.bustomi.bookstorepos.service.PengarangService;
import com.bustomi.bookstorepos.service.SatuanService;

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
        
        if (entity instanceof Grup) {
            GrupService service=SpringManager.getInstance().getBean(GrupService.class);
            if (service.find(entity.getNama()) != null) {
                Grup hasil=service.find(entity.getNama());
                if (!entity.equals(hasil)) {
                    throwValidatorException("Nama '"+entity.getNama()+"' sudah digunakan! Silahkan gunakan nama lain.");
                }
            }
        } else if (entity instanceof KategoriBarang) {
            KategoriBarangService service=SpringManager.getInstance().getBean(KategoriBarangService.class);
            if (service.find(entity.getNama()) != null) {
                KategoriBarang hasil=service.find(entity.getNama());
                if (!entity.equals(hasil)) {
                    throwValidatorException("Nama '"+entity.getNama()+"' sudah digunakan! Silahkan gunakan nama lain.");
                }
            }
        } else if (entity instanceof KategoriBuku) {
            KategoriBukuService service=SpringManager.getInstance().getBean(KategoriBukuService.class);
            if (service.find(entity.getNama()) != null) {
                KategoriBuku hasil=service.find(entity.getNama());
                if (!entity.equals(hasil)) {
                    throwValidatorException("Nama '"+entity.getNama()+"' sudah digunakan! Silahkan gunakan nama lain.");
                }
            }
        } else if (entity instanceof Penerbit) {
            PenerbitService service=SpringManager.getInstance().getBean(PenerbitService.class);
            if (service.find(entity.getNama()) != null) {
                Penerbit hasil=service.find(entity.getNama());
                if (!entity.equals(hasil)) {
                    throwValidatorException("Nama '"+entity.getNama()+"' sudah digunakan! Silahkan gunakan nama lain.");
                }
            }
        } else if (entity instanceof Pengarang) {
            PengarangService service=SpringManager.getInstance().getBean(PengarangService.class);
            if (service.find(entity.getNama()) != null) {
                Pengarang hasil=service.find(entity.getNama());
                if (!entity.equals(hasil)) {
                    throwValidatorException("Nama '"+entity.getNama()+"' sudah digunakan! Silahkan gunakan nama lain.");
                }
            }
        } else if (entity instanceof Satuan) {
            SatuanService service=SpringManager.getInstance().getBean(SatuanService.class);
            if (service.find(entity.getNama()) != null) {
                Satuan hasil=service.find(entity.getNama());
                if (!entity.equals(hasil)) {
                    throwValidatorException("Nama '"+entity.getNama()+"' sudah digunakan! Silahkan gunakan nama lain.");
                }
            }
        }
    }

    protected abstract void doValidate(T data) throws ValidatorException;
    
}
