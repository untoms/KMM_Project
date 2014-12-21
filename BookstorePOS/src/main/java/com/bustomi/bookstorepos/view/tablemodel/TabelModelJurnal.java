/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.laporan.Jurnal;
import com.bustomi.bookstorepos.entity.laporan.Keuntungan;

/**
 *
 * @author PacuL
 */
public class TabelModelJurnal extends ParentTableModel<Jurnal>{
    
    private String [] columnNames={"No.","Kode","Waktu","Deskripsi","Kredit","Debit"
                                    ,"Saldo Sebelum","Saldo Sesudah"};

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getWaktu();             
            case 3 : return getList().get(rowIndex).getNama();
            case 4 : return getList().get(rowIndex).getKredit();
            case 5 : return getList().get(rowIndex).getDebit();                                 
            case 6 : return getList().get(rowIndex).getSaldoSebelumnya();
            case 7 : return getList().get(rowIndex).getSaldo();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
