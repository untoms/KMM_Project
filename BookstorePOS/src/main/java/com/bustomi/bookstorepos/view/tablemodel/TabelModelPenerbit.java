/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.master.Penerbit;

/**
 *
 * @author PacuL
 */
public class TabelModelPenerbit extends ParentTableModel<Penerbit>{

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getNama();
            case 3 : return getList().get(rowIndex).getEmail();
            case 4 : return getList().get(rowIndex).getTelepon();
            case 5 : return getList().get(rowIndex).getAlamat();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Nama";
            case 3 : return "Email";
            case 4 : return "Telepon";
            case 5 : return "Alamat";
                default: return null;
        }
    } 
    
}
