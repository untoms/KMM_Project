/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.manager.LoginManager;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.GrupService;
import com.bustomi.bookstorepos.service.UserService;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.UserValidator;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogUser extends javax.swing.JDialog {

    private User user;
    private boolean editMode;
    private boolean deleteMode;
    private boolean okhapus;
    
    public DialogUser() {
        setModal(true);
        initComponents();        
        textAreaAlamat.setDisabledTextColor(Color.LIGHT_GRAY);
        textAreaInfo.setDisabledTextColor(Color.LIGHT_GRAY);
                
    }
    
    private void loadGrup(){
        GrupService service=SpringManager.getInstance().getBean(GrupService.class);
        List<Grup> grups=service.findAll();
        
        for (Grup grup : grups) {
            jComboBox1.addItem(grup);
        }
    }
    
    private boolean ceksandi(){
        String first=new String(textPassX1.getPassword());
        String second=new String(textPassX2.getPassword());
        
        return first.equals(second);
    }
        
    public User tambah() {
        
        editMode = false;
        deleteMode = false;
        buttonBlue1.setEnabled(false);
        
        loadGrup();
        
        jLabelInfo.setText("Tambah User Baru");
        setTitle("Tambah User Baru");
        
        setVisible(true);
        return user;
    }
    
    public User ubah(User parameter){
        
        editMode = true;
        
        loadGrup();
        
        jLabelInfo.setText("Edit User");
        setTitle("Edit User");
        
        textFieldXId.setText(parameter.getId());
        textFieldXId.setEnabled(false);
        textFieldXNama.setText(parameter.getNama());
        textFieldXTelepon.setText(parameter.getTelepon());
        textFieldXKota.setText(parameter.getKota());
        textAreaInfo.setText(parameter.getInfo());
        textAreaAlamat.setText(parameter.getAlamat());
        textFieldXIEmail.setText(parameter.getEmail());
        textFieldXKodepos.setText(parameter.getKodepos());
        jDateChooser1.setDate(parameter.getTgl_lahir());
        jComboBox1.setSelectedItem(parameter.getGrup());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        labelLogin.setText(parameter.getTerakhir_login().toString());
        if (parameter.getTerakhir_logout() != null) {
           labelLogout.setText(parameter.getTerakhir_logout().toString()); 
        } 
        
        textPassX1.setEnabled(false);
        textPassX2.setEnabled(false);
        
        user = parameter;
        
        setVisible(true);
        
        return user;
    }
    
    public void detail(User parameter) {
        
        buttonBlue1.setEnabled(false);
                
        jLabelInfo.setText("Detail User");
        setTitle("Detail User");
        loadGrup();
        textFieldXId.setText(parameter.getId());
        textFieldXNama.setText(parameter.getNama());
        textFieldXTelepon.setText(parameter.getTelepon());
        textFieldXKota.setText(parameter.getKota());
        textAreaInfo.setText(parameter.getInfo());
        textAreaAlamat.setText(parameter.getAlamat());
        textFieldXIEmail.setText(parameter.getEmail());        
        textFieldXKodepos.setText(parameter.getKodepos());
        jDateChooser1.setDate(parameter.getTgl_lahir());
        jComboBox1.setSelectedItem(parameter.getGrup());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        textFieldXId.setEnabled(false);
        textFieldXNama.setEnabled(false);
        textFieldXTelepon.setEnabled(false);
        textFieldXKota.setEnabled(false);
        textAreaInfo.setEnabled(false);
        textAreaAlamat.setEnabled(false);
        textFieldXIEmail.setEnabled(false);
        textFieldXKodepos.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jComboBox1.setEnabled(false);
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        labelLogin.setText(parameter.getTerakhir_login().toString());
        if (parameter.getTerakhir_logout() != null) {
           labelLogout.setText(parameter.getTerakhir_logout().toString()); 
        }       
        
        textPassX1.setEnabled(false);
        textPassX2.setEnabled(false);
        
        buttonGreen1.setVisible(false);
        buttonRed1.setText("Oke");
        
        setVisible(true);
        
    }
    
    public boolean delete(User parameter) {
        
        buttonBlue1.setEnabled(false);
        deleteMode=true;
            loadGrup();    
        jLabelInfo.setText("Yakin Hapus?");
        setTitle("Hapus User");
                
        textFieldXId.setText(parameter.getId());
        textFieldXNama.setText(parameter.getNama());
        textFieldXTelepon.setText(parameter.getTelepon());
        textFieldXKota.setText(parameter.getKota());
        textAreaInfo.setText(parameter.getInfo());
        textAreaAlamat.setText(parameter.getAlamat());
        textFieldXIEmail.setText(parameter.getEmail());
        
        textFieldXKodepos.setText(parameter.getKodepos());
        jDateChooser1.setDate(parameter.getTgl_lahir());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        textFieldXId.setEnabled(false);
        textFieldXNama.setEnabled(false);
        textFieldXTelepon.setEnabled(false);
        textFieldXKota.setEnabled(false);
        textAreaInfo.setEnabled(false);
        textAreaAlamat.setEnabled(false);
        textFieldXIEmail.setEnabled(false);
        textFieldXKodepos.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jComboBox1.setSelectedItem(parameter.getGrup());
        jComboBox1.setEnabled(false);
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        labelLogin.setText(parameter.getTerakhir_login().toString());
        if (parameter.getTerakhir_logout() != null) {
           labelLogout.setText(parameter.getTerakhir_logout().toString()); 
        } 
        
        textPassX1.setEnabled(false);
        textPassX2.setEnabled(false);
        
        buttonGreen1.setText("Hapus");
        
        setVisible(true);
        
        return okhapus;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPortX1 = new com.bustomi.bookstorepos.component.ViewPortX();
        textAreaAlamat = new javax.swing.JTextArea();
        viewPortX2 = new com.bustomi.bookstorepos.component.ViewPortX();
        textAreaInfo = new javax.swing.JTextArea();
        viewPortX3 = new com.bustomi.bookstorepos.component.ViewPortX();
        listPengarang = new javax.swing.JList();
        panelXBack1 = new com.bustomi.bookstorepos.component.PanelXBack();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldXId = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabel4 = new javax.swing.JLabel();
        textFieldXIEmail = new com.bustomi.bookstorepos.component.TextFieldX();
        jScrollPaneInfo = new javax.swing.JScrollPane();
        jScrollPaneNama = new javax.swing.JScrollPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelDibuat = new javax.swing.JLabel();
        labelDiubah = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldXKota = new com.bustomi.bookstorepos.component.TextFieldX();
        textFieldXNama = new com.bustomi.bookstorepos.component.TextFieldX();
        textFieldXTelepon = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabel18 = new javax.swing.JLabel();
        textFieldXKodepos = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        textPassX1 = new com.bustomi.bookstorepos.component.TextPassX();
        textPassX2 = new com.bustomi.bookstorepos.component.TextPassX();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        labelLogout = new javax.swing.JLabel();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        textAreaAlamat.setColumns(20);
        textAreaAlamat.setForeground(new java.awt.Color(255, 255, 255));
        textAreaAlamat.setRows(5);
        textAreaAlamat.setOpaque(false);
        viewPortX1.add(textAreaAlamat);

        textAreaInfo.setColumns(20);
        textAreaInfo.setForeground(new java.awt.Color(255, 255, 255));
        textAreaInfo.setRows(5);
        textAreaInfo.setOpaque(false);
        viewPortX2.add(textAreaInfo);

        listPengarang.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listPengarang.setOpaque(false);
        viewPortX3.add(listPengarang);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Sandi :");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Email :");

        jScrollPaneInfo.setOpaque(false);
        jScrollPaneInfo.setViewport(viewPortX2);

        jScrollPaneNama.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneNama.setOpaque(false);
        jScrollPaneNama.setViewport(viewPortX1);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Waktu dibuat :");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Terkhir edit :");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Info :");

        labelDibuat.setForeground(new java.awt.Color(255, 255, 255));
        labelDibuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDibuat.setText("--");

        labelDiubah.setForeground(new java.awt.Color(255, 255, 255));
        labelDiubah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDiubah.setText("--");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Kota :");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Telepon :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Alamat :");

        textFieldXNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXNamaActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Kodepos :");

        textFieldXKodepos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXKodeposActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tgl Lahir :");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Kode :");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textPassX1.setText("textPassX1");

        textPassX2.setText("textPassX1");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Konfirmasi :");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Grup :");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Terakhir Login :");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Terakhir Logout :");

        labelLogin.setForeground(new java.awt.Color(255, 255, 255));
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLogin.setText("--");

        labelLogout.setForeground(new java.awt.Color(255, 255, 255));
        labelLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLogout.setText("--");

        buttonBlue1.setText("GANTI SANDI");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPassX2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(textFieldXId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textPassX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelX1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneNama)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldXKodepos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldXNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(18, 18, 18)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDiubah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDibuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldXKota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldXTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldXIEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textPassX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPassX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(textFieldXIEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel19)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(textFieldXTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(textFieldXKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXKodepos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPaneNama, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(labelDibuat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(labelDiubah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(labelLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(labelLogout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("Info Dialog");
        jLabelInfo.setName(""); // NOI18N

        panelX2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        buttonGreen1.setText("Simpan");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        panelX2.add(buttonGreen1);

        buttonRed1.setText("Batal");
        buttonRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRed1ActionPerformed(evt);
            }
        });
        panelX2.add(buttonRed1);

        javax.swing.GroupLayout panelXBack1Layout = new javax.swing.GroupLayout(panelXBack1);
        panelXBack1.setLayout(panelXBack1Layout);
        panelXBack1Layout.setHorizontalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelXBack1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelX2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelXBack1Layout.setVerticalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelXBack1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
        
        if (deleteMode) {
            okhapus=true;
            dispose();
        }else {
            
            if (!ceksandi()) {
                JOptionPane.showMessageDialog(this, "Kombinasi ke dua sandi tidak cocok!");
                return;
            }
            
            String info=textAreaInfo.getText();
            String alamat=textAreaAlamat.getText();
            String email=textFieldXIEmail.getText();
            String nama=textFieldXNama.getText();
            String telepon=textFieldXTelepon.getText();
            String kota=textFieldXKota.getText();
            String kodepos=textFieldXKodepos.getText();
            Date lahir=jDateChooser1.getDate();
            String id=textFieldXId.getText();
            String sandi=new String(textPassX1.getPassword());
            Grup grup=(Grup) jComboBox1.getSelectedItem();
            
            
            if (!editMode) {
                user = new User();
                user.setWaktuDibuat(new Date());
                user.setTerakhirDirubah(new Date());
                user.setPassword(sandi(sandi));
            }else {
                user.setTerakhirDirubah(new Date());
            }
            
            user.setId(id);
            user.setAlamat(alamat);
            user.setEmail(email);
            user.setInfo(info);
            user.setKota(kota);
            user.setNama(nama);
            user.setTelepon(telepon);
            user.setKodepos(kodepos);
            user.setTgl_lahir(lahir);
            user.setGrup(grup);            
            
            UserValidator validator=SpringManager.getInstance().getBean(UserValidator.class);
            try {
                validator.validate(user);
                dispose();  
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
                      
        }
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        user=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        user = null;
    }//GEN-LAST:event_formWindowClosing

    private void textFieldXKodeposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXKodeposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXKodeposActionPerformed

    private void textFieldXNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXNamaActionPerformed

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        
        if (!user.equals(LoginManager.getInstance().getUser())) {
            JOptionPane.showMessageDialog(this, "Anda tidak berhak mengganti password ini");
            return;
        }
        
        DialogGantiSandi dgs=new DialogGantiSandi();
        dgs.setLocationRelativeTo(this);
        dgs.setVisible(true);
        
        String sandi=dgs.ganti();
        if (sandi != null) {
            user.setPassword(sandi);
            user.setTerakhirDirubah(new Date());
            UserService service=SpringManager.getInstance().getBean(UserService.class);
            service.update(user);
            JOptionPane.showMessageDialog(this, "Penggantian sandi sukses.");
        }
    }//GEN-LAST:event_buttonBlue1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private javax.swing.JScrollPane jScrollPaneNama;
    private javax.swing.JLabel labelDibuat;
    private javax.swing.JLabel labelDiubah;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelLogout;
    private javax.swing.JList listPengarang;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private javax.swing.JTextArea textAreaAlamat;
    private javax.swing.JTextArea textAreaInfo;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXIEmail;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXId;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXKodepos;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXKota;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXNama;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXTelepon;
    private com.bustomi.bookstorepos.component.TextPassX textPassX1;
    private com.bustomi.bookstorepos.component.TextPassX textPassX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX3;
    // End of variables declaration//GEN-END:variables
    
    private String sandi(String pass){
        // Create MessageDigest instance for MD5
        MessageDigest md = null;
        
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Add password bytes to digest
        md.update(pass.getBytes());
        //Get the hash's bytes 
        byte[] bytes = md.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        String generatedPassword = sb.toString();

        return generatedPassword;
    }
}
