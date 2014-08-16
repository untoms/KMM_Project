/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.master.Pemasok;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.PemasokValidator;
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
public class DialogPemasok extends javax.swing.JDialog {

    private Pemasok pemasok;
    private boolean editMode;
    private boolean deleteMode;
    private boolean okhapus;
    
    public DialogPemasok() {
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
        
    public Pemasok tambah() {
        
        
        editMode = false;
        deleteMode = false;
        
        jLabelInfo.setText("Tambah Pemasok Baru");
        setTitle("Tambah Pemasok Baru");
        
        setVisible(true);
        return pemasok;
    }
    
    public Pemasok ubah(Pemasok parameter){
        
        editMode = true;
        
        checkBoxAuto.setEnabled(false);
        
        jLabelInfo.setText("Edit Pemasok");
        setTitle("Edit Pemasok");
        
        textFieldXId.setText(parameter.getId());
        textFieldXId.setEnabled(false);
        textFieldXIdNama.setText(parameter.getNama());
        textFieldXIdTelepon.setText(parameter.getTelepon());
        textFieldXIdKota.setText(parameter.getKota());
        textAreaInfo.setText(parameter.getInfo());
        textAreaAlamat.setText(parameter.getAlamat());
        textFieldXIEmail.setText(parameter.getEmail());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        pemasok = parameter;
        
        setVisible(true);
        
        return pemasok;
    }
    
    public void detail(Pemasok parameter) {
                
        jLabelInfo.setText("Detail Pemasok");
        setTitle("Detail Pemasok");
        
        checkBoxAuto.setEnabled(false);
        
        textFieldXId.setText(parameter.getId());
        textFieldXIdNama.setText(parameter.getNama());
        textFieldXIdTelepon.setText(parameter.getTelepon());
        textFieldXIdKota.setText(parameter.getKota());
        textAreaInfo.setText(parameter.getInfo());
        textAreaAlamat.setText(parameter.getAlamat());
        textFieldXIEmail.setText(parameter.getEmail());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        textFieldXId.setEnabled(false);
        textFieldXIdNama.setEnabled(false);
        textFieldXIdTelepon.setEnabled(false);
        textFieldXIdKota.setEnabled(false);
        textAreaInfo.setEnabled(false);
        textAreaAlamat.setEnabled(false);
        textFieldXIEmail.setEnabled(false);
       
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        
        buttonGreen1.setVisible(false);
        buttonRed1.setText("Oke");
        
        setVisible(true);
        
    }
    
    public boolean delete(Pemasok parameter) {
        
        deleteMode=true;
                
        jLabelInfo.setText("Yakin Hapus?");
        setTitle("Hapus Pemasok");
        
        checkBoxAuto.setEnabled(false);
        
        textFieldXId.setText(parameter.getId());
        textFieldXIdNama.setText(parameter.getNama());
        textFieldXIdTelepon.setText(parameter.getTelepon());
        textFieldXIdKota.setText(parameter.getKota());
        textAreaInfo.setText(parameter.getInfo());
        textAreaAlamat.setText(parameter.getAlamat());
        textFieldXIEmail.setText(parameter.getEmail());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        textFieldXId.setEnabled(false);
        textFieldXIdNama.setEnabled(false);
        textFieldXIdTelepon.setEnabled(false);
        textFieldXIdKota.setEnabled(false);
        textAreaInfo.setEnabled(false);
        textAreaAlamat.setEnabled(false);
        textFieldXIEmail.setEnabled(false);
       
        
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
        textFieldXIdKota = new com.bustomi.bookstorepos.component.TextFieldX();
        textFieldXIdNama = new com.bustomi.bookstorepos.component.TextFieldX();
        textFieldXIdTelepon = new com.bustomi.bookstorepos.component.TextFieldX();
        checkBoxAuto = new javax.swing.JCheckBox();
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

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pemasok", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

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

        textFieldXIdKota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXIdKotaActionPerformed(evt);
            }
        });

        textFieldXIdNama.setForeground(new java.awt.Color(255, 255, 255));
        textFieldXIdNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXIdNamaActionPerformed(evt);
            }
        });

        textFieldXIdTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXIdTeleponActionPerformed(evt);
            }
        });

        checkBoxAuto.setText("Otomatis");
        checkBoxAuto.setOpaque(false);

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(jScrollPaneNama, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 177, Short.MAX_VALUE))
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldXIdNama, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(textFieldXIdKota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldXIdTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldXIEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBoxAuto)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDibuat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDiubah, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldXIdNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel17)
                    .addComponent(textFieldXIdTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textFieldXIdKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldXIEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPaneNama, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            String nama=textFieldXIdNama.getText();
            String telepon=textFieldXIdTelepon.getText();
            String kota=textFieldXIdKota.getText();
            String id=textFieldXId.getText();
                        
            if (!editMode) {
                pemasok = new Pemasok();
                pemasok.setWaktuDibuat(new Date());
                pemasok.setTerakhirDirubah(new Date());
                
                if (!checkBoxAuto.isSelected()) {
                    id=textFieldXId.getText();
                }else{
                    long auto=new Date().getTime();
                    id=""+auto;
                }

            }else {
                pemasok.setTerakhirDirubah(new Date());
            }
            
            pemasok.setId(id);
            pemasok.setAlamat(alamat);
            pemasok.setEmail(email);
            pemasok.setInfo(info);
            pemasok.setKota(kota);
            pemasok.setNama(nama);
            pemasok.setTelepon(telepon);
            
            PemasokValidator validator=SpringManager.getInstance().getBean(PemasokValidator.class);
            try {
                validator.validate(pemasok);
                dispose();
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }            
        }
        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        pemasok=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        pemasok = null;
    }//GEN-LAST:event_formWindowClosing

    private void textFieldXIEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIEmailActionPerformed

    private void textFieldXIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIdActionPerformed

    private void textFieldXIdKotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIdKotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIdKotaActionPerformed

    private void textFieldXIdNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIdNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIdNamaActionPerformed

    private void textFieldXIdTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIdTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIdTeleponActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JCheckBox checkBoxAuto;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXIdKota;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXIdNama;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXIdTelepon;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX3;
    // End of variables declaration//GEN-END:variables
    
    public void display(Window formApp, Object parameter) {
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}
