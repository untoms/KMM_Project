/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator.implement;

import com.bustomi.bookstorepos.entity.master.Buku;
import com.bustomi.bookstorepos.validator.AbstractValidator;
import com.bustomi.bookstorepos.validator.ValidatorException;
import java.util.Calendar;
import org.springframework.stereotype.Component;

/**
 *
 * @author PacuL
 */
@Component
public class BukuValidator extends AbstractValidator<Buku>{

    @Override
    protected void doValidate(Buku data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Pengarang tidak boleh null");
        } else if (data.getISBN() == null ){
            throwValidatorException("ISBN tidak boleh null");
        } else if (data.getISBN().length() > 45 ){
            throwValidatorException("ISBN terlalu panjang");
        } else if (data.getISBN().trim().isEmpty()){
            throwValidatorException("ISBN tidak boleh kosong");
        } else if (data.getTahun_terbit() == null){
            throwValidatorException("Tahun terbit tidak boleh kosong");
        } else if (data.getTahun_terbit() > Calendar.getInstance().get(Calendar.YEAR)){
            throwValidatorException("Tahun terbit valid");
        } else if (data.getItem() == null){
            throwValidatorException("Item tidak boleh null");
        } else if (data.getKategoriBuku() == null){
            throwValidatorException("Kategori buku harus belum dipilih");
        } else if (data.getPenerbit() == null){
            throwValidatorException("Penerbit belum dipillih");
        } else if (data.getDaftarPengarang() == null){
            throwValidatorException("Pengarang belum dipilih");
        }
    }
    
}
