/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.transaksi.Pemasukan;

/**
 *
 * @author PacuL
 */
public class TabelModelPemasukan extends ParentTableModel<Pemasukan>{

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getNama();                
            case 3 : return getList().get(rowIndex).getJumlah();
            case 4 : return getList().get(rowIndex).getInfo();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Nama";
            case 3 : return "Jumlah";
            case 4 : return "Informasi";
                default: return null;
        }
    } 
    
}
