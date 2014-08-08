/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.entity.transaksi.Penjualan;

/**
 *
 * @author PacuL
 */
public class TabelModelPenjualan extends ParentTableModel<Penjualan>{

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getWaktu_transaksi();
            case 3 : return getList().get(rowIndex).getPelanggan().getNama();
            case 4 : return getList().get(rowIndex).getUser().getNama();
            case 5 : return getList().get(rowIndex).getTotal();
            case 6 : return getList().get(rowIndex).getKeuntungan();
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
            case 6 : return "Keuntungan";
                default: return null;
        }
    } 
    
}
