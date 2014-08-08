/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.master.Buku;

/**
 *
 * @author PacuL
 */
public class TabelModelBuku extends ParentTableModel<Buku>{

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getItem().getId();
            case 2 : return getList().get(rowIndex).getNama();
            case 3 : return getList().get(rowIndex).getISBN();
            case 4 : return getList().get(rowIndex).getTahun_terbit();
            case 5 : return getList().get(rowIndex).getPenerbit().getNama();
            case 6 : return getList().get(rowIndex).getKategoriBuku().getNama();
            case 7 : return getList().get(rowIndex).getItem().getHarga_jual();
            case 8 : return getList().get(rowIndex).getItem().getStok();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Judul";
            case 3 : return "ISBN";
            case 4 : return "Tahun terbit";
            case 5 : return "Penrbit";
            case 6 : return "Kategori";
            case 7 : return "Harga Jual";
            case 8 : return "Stok";
                default: return null;
        }
    } 
    
}
