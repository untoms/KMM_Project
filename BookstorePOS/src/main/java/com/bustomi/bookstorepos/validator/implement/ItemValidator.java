/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.validator.implement;

import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.validator.AbstractValidator;
import com.bustomi.bookstorepos.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author PacuL
 */
@Component
public class ItemValidator extends AbstractValidator<Item>{

    @Override
    protected void doValidate(Item data) throws ValidatorException {
        
    }
    
    
}
