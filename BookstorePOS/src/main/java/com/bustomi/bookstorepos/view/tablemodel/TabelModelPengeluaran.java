/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.transaksi.Pemasukan;
import com.bustomi.bookstorepos.entity.transaksi.Pengeluaran;

/**
 *
 * @author PacuL
 */
public class TabelModelPengeluaran extends ParentTableModel<Pengeluaran>{

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getWaktuDibuat();
            case 3 : return getList().get(rowIndex).getNama();                
            case 4 : return getList().get(rowIndex).getJumlah();
            case 5 : return getList().get(rowIndex).getUser();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Tanggal";
            case 3 : return "Nama";
            case 4 : return "Jumlah";
            case 5 : return "Pengguna";
                default: return null;
        }
    } 
    
}
