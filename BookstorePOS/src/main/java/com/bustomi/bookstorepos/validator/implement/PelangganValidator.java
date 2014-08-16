/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator.implement;

import com.bustomi.bookstorepos.entity.master.Pelanggan;
import com.bustomi.bookstorepos.validator.AbstractValidator;
import com.bustomi.bookstorepos.validator.ValidatorException;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author PacuL
 */
@Component
public class PelangganValidator extends AbstractValidator<Pelanggan>{

    @Override
    protected void doValidate(Pelanggan data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Pelanggan tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Kode pelanggan tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Kode pelanggan tidak boleh kosong");
        } else if (data.getId().length() > 35) {
            throwValidatorException("Kode pelanggan terlalu panjang");
        } else if (data.getAlamat() == null){
            throwValidatorException("Alamat tidak boleh null");
        } else if (data.getAlamat().trim().isEmpty()){
            throwValidatorException("Alamat tidak boleh kosong");
        } else if (data.getAlamat().length() > 255){
            throwValidatorException("Karakter Alamat terlalu panjang");
        } else if (data.getKota() == null){
            throwValidatorException("Kota tidak boleh null");
        } else if (data.getKota().trim().isEmpty()){
            throwValidatorException("Kota tidak boleh kosong");
        } else if (data.getKota().length() > 35){
            throwValidatorException("Karakter kota terlalu panjang");
        } else if (data.getTelepon() == null){
            throwValidatorException("Telepon tidak boleh null");
        } else if(data.getTelepon().trim().isEmpty()){
            throwValidatorException("Telepon tidak boleh kosong");
        } else if (data.getTelepon().length() > 25){
            throwValidatorException("Karakter telepon terlalu panjang");
        } else if (!data.getEmail().contains("@") || !data.getEmail().contains(".")){
            throwValidatorException("Email tidak valid");
        } else if (data.getEmail().length() > 50){
            throwValidatorException("Karakter email terlalu panjang");
        }else if (data.getKodepos().length() > 6){
            throwValidatorException("Kodepos terlalu panjang");
        }else if (data.getTgl_lahir().compareTo(new Date()) >= 0){
            throwValidatorException("Tanggal lahir tidak boleh di masa depan");
        }
    }
    
}
