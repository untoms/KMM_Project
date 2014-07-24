/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator.implement;

import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.validator.AbstractValidator;
import com.bustomi.bookstorepos.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author PacuL
 */
@Component
public class GrupValidator extends AbstractValidator<Grup>{

    @Override
    protected void doValidate(Grup data) throws ValidatorException {
        if (data == null) {
            throwValidatorException("Grup tidak boleh null");
        } else if (data.getDaftarHakAkses().isEmpty()) {
            throwValidatorException("Grup harus memiliki hak akses");
        }
    }
    
    
    
}
