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
public class TabelModelBarcode extends ParentTableModel<Item>{
    
    private String [] columnNames={"No.","Kode","Nama/Judul","Harga Jual","Stok"
                                    ,"Pilih","Jumlah Cetak"};
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();                
            case 2 : return getList().get(rowIndex).getNama();
            case 3 : return getList().get(rowIndex).getHarga_jual();
            case 4 : return getList().get(rowIndex).getStok();
            case 5 : if (getList().get(rowIndex).getPilih() == null) {
                    return false;
                    }else{
                        return getList().get(rowIndex).getPilih();
                    }                
            case 6 : if (getList().get(rowIndex).getJmlhCetak() == null) {
                    return 0;
                    }else {
                        return getList().get(rowIndex).getJmlhCetak();
                    }
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex >= 5) {
            return true;
        } else{
            return false;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
      
        Item item=getList().get(row);
        if (value instanceof Boolean) {
            item.setPilih((Boolean)value);
            getList().set(row, item);
        } else if(value instanceof Integer){
            item.setJmlhCetak((Integer)value);
            getList().set(row, item);
        }
        fireTableCellUpdated(row, col);
    }
    
}
