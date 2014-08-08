/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.tablemodel;

import com.bustomi.bookstorepos.entity.User.User;

/**
 *
 * @author PacuL
 */
public class TabelModelUser extends ParentTableModel<User>{

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return rowIndex + 1;
            case 1 : return getList().get(rowIndex).getId();
            case 2 : return getList().get(rowIndex).getNama();                
            case 3 : return getList().get(rowIndex).getTelepon();                
            case 4 : return getList().get(rowIndex).getTgl_lahir();                
            case 5 : return getList().get(rowIndex).getKota();
            case 6 : return getList().get(rowIndex).getAlamat();
            case 7 : return getList().get(rowIndex).getEmail();
            case 8 : return getList().get(rowIndex).getKodepos();
            case 9 : return getList().get(rowIndex).getPassword();
            case 10 : return getList().get(rowIndex).getGrup().getNama();
            case 11 : return getList().get(rowIndex).getTerakhir_login();
            case 12 : return getList().get(rowIndex).getTerakhir_logout();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0 : return "No.";
            case 1 : return "Kode";
            case 2 : return "Nama";
            case 3 : return "Telepon";
            case 4 : return "Tgl Lahir";
            case 5 : return "Kota";
            case 6 : return "Alamat";
            case 7 : return "Email";
            case 8 : return "Kodepos";
            case 9 : return "Password";
            case 10 : return "Role";
            case 11 : return "Login terakhir";
            case 12 : return "Logout terakhir";
                default: return null;
        }
    } 
    
}
