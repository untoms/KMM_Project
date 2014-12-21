/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.laporan.Keuntungan;

/**
 *
 * @author PacuL
 */
public class TabelModelKeuntungan extends ParentTableModel<Keuntungan>{

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getJenis();               
            case 3 : return getList().get(rowIndex).getTanggal();
            case 4 : return getList().get(rowIndex).getUser();
            case 5 : if (getList().get(rowIndex).getPelanggan() != null) {
                        return getList().get(rowIndex).getPelanggan();
                    }else{
                        return null;
                    }                
            case 6 : if (getList().get(rowIndex).getPemasok() != null) {
                        return getList().get(rowIndex).getPemasok();
                    }else{
                        return null;
                    }
            case 7 : return getList().get(rowIndex).getTotal();
            case 8 : return getList().get(rowIndex).getKeuntungan();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Jenis";
            case 3 : return "Tanggal";
            case 4 : return "Pengguna";
            case 5 : return "Pelanggan";
            case 6 : return "Pemasok";
            case 7 : return "Total";
            case 8 : return "Keuntungan";
                default: return null;
        }
    } 
    
}
