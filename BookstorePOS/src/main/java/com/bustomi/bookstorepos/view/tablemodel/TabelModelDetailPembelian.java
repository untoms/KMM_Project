/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.transaksi.DetailPembelian;

/**
 *
 * @author PacuL
 */
public class TabelModelDetailPembelian extends ParentTableModel<DetailPembelian>{

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getItem().getId();
            case 2 : return getList().get(rowIndex).getItem().getNama();
            case 3 : return getList().get(rowIndex).getHarga();
            case 4 : return getList().get(rowIndex).getJumlah();
            case 5 : return getList().get(rowIndex).getSubTotal();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode Item";
            case 2 : return "Item";
            case 3 : return "Harga";
            case 4 : return "Jumlah";
            case 5 : return "Subtotal";
                default: return null;
        }
    } 
    
}
