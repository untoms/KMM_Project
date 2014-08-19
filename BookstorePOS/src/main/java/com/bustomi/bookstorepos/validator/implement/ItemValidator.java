/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator.implement;

import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.validator.AbstractValidator;
import com.bustomi.bookstorepos.validator.ValidatorException;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 *
 * @author PacuL
 */
@Component
public class ItemValidator extends AbstractValidator<Item>{

    @Override
    protected void doValidate(Item data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Item tidak boleh null");
        } else if (data.getId() == null) {
            throwValidatorException("Id barang tidak boleh null");
        } else if (data.getId().trim().isEmpty()) {
            throwValidatorException("Id barang tidak boleh kosong");
        } else if (data.getHarga_beli() == null) {
            throwValidatorException("Harga beli tidak boleh null");
        } else if ((data.getHarga_beli().compareTo(BigDecimal.ONE))==-1) {
            throwValidatorException("Harga beli tidak valid");
        } else if (data.getHarga_jual()== null) {
            throwValidatorException("Harga jual tidak boleh null");
        } else if ((data.getHarga_jual().compareTo(data.getHarga_beli())) != 1) {
            throwValidatorException("Harga jual harus lebih besar dari harga beli!");
        } else if (data.getStok() == null) {
            throwValidatorException("Stok barang tidak boleh null");
        }
    }
    
    
}
