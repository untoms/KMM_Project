/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.master.Pelanggan;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.PelangganValidator;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogPelanggan extends javax.swing.JDialog {

    private Pelanggan pelanggan;
    private boolean editMode;
    private boolean deleteMode;
    private boolean okhapus;
    
    public DialogPelanggan() {
        setModal(true);
        initComponents();        
        textAreaAlamat.setDisabledTextColor(Color.LIGHT_GRAY);
        textAreaInfo.setDisabledTextColor(Color.LIGHT_GRAY);
        
        checkBoxAuto.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    textFieldXId.setEnabled(false);
                }else{
                    textFieldXId.setEnabled(true);
                }
            }
        });
        
    }
        
    public Pelanggan tambah() {
        
        
        editMode = false;
        deleteMode = false;
        
        jLabelInfo.setText("Tambah Pelanggan Baru");
        setTitle("Tambah Pelanggan Baru");
        
        setVisible(true);
        return pelanggan;
    }
    
    public Pelanggan ubah(Pelanggan parameter){
        
        editMode = true;
        
        checkBoxAuto.setEnabled(false);
        
        jLabelInfo.setText("Edit Pelanggan");
        setTitle("Edit Pelanggan");
        
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
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        pelanggan = parameter;
        
        setVisible(true);
        
        return pelanggan;
    }
    
    public void detail(Pelanggan parameter) {
                
        jLabelInfo.setText("Detail Pelanggan");
        setTitle("Detail Pelanggan");
        
        checkBoxAuto.setEnabled(false);
        
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
       
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        
        buttonGreen1.setVisible(false);
        buttonRed1.setText("Oke");
        
        setVisible(true);
        
    }
    
    public boolean delete(Pelanggan parameter) {
        
        deleteMode=true;
                
        jLabelInfo.setText("Yakin Hapus?");
        setTitle("Hapus Pelanggan");
        
        checkBoxAuto.setEnabled(false);
        
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
       
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
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
        checkBoxAuto = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        textFieldXKodepos = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        textAreaAlamat.setColumns(20);
        textAreaAlamat.setRows(5);
        textAreaAlamat.setOpaque(false);
        viewPortX1.add(textAreaAlamat);

        textAreaInfo.setColumns(20);
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

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pemasok"));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama :");

        textFieldXId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXIdActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Email :");

        textFieldXIEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXIEmailActionPerformed(evt);
            }
        });

        jScrollPaneInfo.setOpaque(false);
        jScrollPaneInfo.setViewport(viewPortX2);

        jScrollPaneNama.setOpaque(false);
        jScrollPaneNama.setViewport(viewPortX1);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Waktu dibuat :");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        textFieldXKota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXKotaActionPerformed(evt);
            }
        });

        textFieldXNama.setForeground(new java.awt.Color(255, 255, 255));
        textFieldXNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXNamaActionPerformed(evt);
            }
        });

        textFieldXTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXTeleponActionPerformed(evt);
            }
        });

        checkBoxAuto.setText("Otomatis");
        checkBoxAuto.setOpaque(false);

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

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDibuat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDiubah, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldXNama, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(textFieldXKota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldXKodepos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldXTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldXIEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelX1Layout.createSequentialGroup()
                                        .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(checkBoxAuto))
                                    .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneNama, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkBoxAuto))
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel17)
                            .addComponent(textFieldXTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel4)
                            .addComponent(textFieldXIEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(textFieldXKodepos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPaneNama, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelDibuat)
                    .addComponent(jLabel13)
                    .addComponent(labelDiubah))
                .addContainerGap())
        );

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("Info Dialog");
        jLabelInfo.setName(""); // NOI18N

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
                    .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelXBack1Layout.setVerticalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            
            String info=textAreaInfo.getText();
            String alamat=textAreaAlamat.getText();
            String email=textFieldXIEmail.getText();
            String nama=textFieldXNama.getText();
            String telepon=textFieldXTelepon.getText();
            String kota=textFieldXKota.getText();
            String kodepos=textFieldXKodepos.getText();
            Date lahir=jDateChooser1.getDate();
            String id=textFieldXId.getText();
            
            
            if (!editMode) {
                pelanggan = new Pelanggan();
                pelanggan.setWaktuDibuat(new Date());
                pelanggan.setTerakhirDirubah(new Date());
                
                if (!checkBoxAuto.isSelected()) {
                    id=textFieldXId.getText();
                }else{
                    long auto=new Date().getTime();
                    id=""+auto;
                }

            }else {
                pelanggan.setTerakhirDirubah(new Date());
            }
            
            pelanggan.setId(id);
            pelanggan.setAlamat(alamat);
            pelanggan.setEmail(email);
            pelanggan.setInfo(info);
            pelanggan.setKota(kota);
            pelanggan.setNama(nama);
            pelanggan.setTelepon(telepon);
            pelanggan.setKodepos(kodepos);
            pelanggan.setTgl_lahir(lahir);
            
            PelangganValidator validator=SpringManager.getInstance().getBean(PelangganValidator.class);
            try {
                validator.validate(pelanggan);
                dispose();
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }            
        }
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        pelanggan=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        pelanggan = null;
    }//GEN-LAST:event_formWindowClosing

    private void textFieldXIEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIEmailActionPerformed

    private void textFieldXIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIdActionPerformed

    private void textFieldXKotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXKotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXKotaActionPerformed

    private void textFieldXNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXNamaActionPerformed

    private void textFieldXTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXTeleponActionPerformed

    private void textFieldXKodeposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXKodeposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXKodeposActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JCheckBox checkBoxAuto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private javax.swing.JScrollPane jScrollPaneNama;
    private javax.swing.JLabel labelDibuat;
    private javax.swing.JLabel labelDiubah;
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
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX3;
    // End of variables declaration//GEN-END:variables
    
    public void display(Window formApp, Object parameter) {
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}
