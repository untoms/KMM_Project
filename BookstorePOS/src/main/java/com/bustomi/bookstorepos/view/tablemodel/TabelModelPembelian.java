/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.transaksi.Pembelian;

/**
 *
 * @author PacuL
 */
public class TabelModelPembelian extends ParentTableModel<Pembelian>{

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getWaktu_transaksi();
            case 3 : return getList().get(rowIndex).getPemasok().getNama();
            case 4 : return getList().get(rowIndex).getUser().getNama();
            case 5 : return getList().get(rowIndex).getTotal();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Waktu";
            case 3 : return "Pengguna";
            case 4 : return "User";
            case 5 : return "Total";
                default: return null;
        }
    } 
    
}
