/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator.implement;

import com.bustomi.bookstorepos.entity.master.Barang;
import com.bustomi.bookstorepos.validator.AbstractValidator;
import com.bustomi.bookstorepos.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author PacuL
 */
@Component
public class BarangValidator extends AbstractValidator<Barang>{

    @Override
    protected void doValidate(Barang data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Barang tidak boleh null");
        } else if (data.getKategoriBarang()== null) {
            throwValidatorException("Kategori barang tidak boleh null");
        } else if (data.getSatuan() == null) {
            throwValidatorException("Satuan barang tidak boleh null");
        } else if (data.getItem() == null) {
            throwValidatorException("Kode item tidak boleh null");
        } 
    }
    
}
