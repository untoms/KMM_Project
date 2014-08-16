/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.master.Item;

/**
 *
 * @author PacuL
 */
public class TabelModelItem extends ParentTableModel<Item>{

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();                
            case 2 : 
                if (getList().get(rowIndex).getBarang() != null) {
                    return getList().get(rowIndex).getBarang().getNama();
                }else if(getList().get(rowIndex).getBuku() != null){
                    return getList().get(rowIndex).getBuku().getNama();
                }
            case 3 : return getList().get(rowIndex).getHarga_jual();
            case 4 : return getList().get(rowIndex).getStok();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Nama/Judul";
            case 3 : return "Harga Jual";
            case 4 : return "Stok";
                default: return null;
        }
    } 
    
}
