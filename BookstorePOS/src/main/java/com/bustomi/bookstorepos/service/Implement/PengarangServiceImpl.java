/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.Pengarang;
import com.bustomi.bookstorepos.service.PengarangService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;

/**
 *
 * @author PacuL
 */
@Service
public class PengarangServiceImpl extends SimpleAbstractService<Pengarang, Integer>implements PengarangService{

    public PengarangServiceImpl() {
        super(Pengarang.class);
    }
        
}
