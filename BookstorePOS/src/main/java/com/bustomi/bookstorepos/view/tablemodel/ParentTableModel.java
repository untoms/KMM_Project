/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PacuL
 * @param <T>
 */
public abstract class ParentTableModel<T> extends AbstractTableModel{
    
    private List<T> list;

    public ParentTableModel () {
        list=new ArrayList<>();
    }  

    public List<T> getList() {
        return list;
    }
    
    public void load(List<T> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public void tambah(T data){
        list.add(data);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        //untuk memberi tahu pada jtable bahwa data bertambah    
    }
    
    public void tambahsatu(T data){
        list.clear();
        list.add(data);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1); //untuk memberi tahu pada jtable bahwa data bertambah    
    }
    
    public void ubah(int baris, T data){
        list.set(baris, data);
        fireTableRowsUpdated(baris, baris);//memberi tahu jtable data berubah
            
    }
    
    public void hapus (int baris){
        list.remove(baris);
        fireTableRowsDeleted(baris, baris);//memberitahu jtable data dihapus
    }
    
    public T ambilData(int baris){ 
        return list.get(baris);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }   
    
}
