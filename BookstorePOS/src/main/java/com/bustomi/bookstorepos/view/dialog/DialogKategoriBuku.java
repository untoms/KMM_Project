/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.master.KategoriBuku;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.KategoriBukuValidator;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogKategoriBuku extends javax.swing.JDialog {

    private KategoriBuku data;
    private boolean editMode;
    private boolean deleteMode;
    private boolean okhapus;
    
    public DialogKategoriBuku() {
        setModal(true);
        initComponents();        
        textAreaInfo.setDisabledTextColor(Color.LIGHT_GRAY);
        
    }
        
    public KategoriBuku tambah() {
        
        
        editMode = false;
        deleteMode = false;
        
        jLabelInfo.setText("Tambah KategoriBuku Baru");
        setTitle("Tambah KategoriBuku Baru");
        textFieldXId.setEnabled(false);
        setVisible(true);
        return data;
    }
    
    public KategoriBuku ubah(KategoriBuku parameter){
        
        editMode = true;
        
        
        jLabelInfo.setText("Edit KategoriBuku");
        setTitle("Edit KategoriBuku");
        
        textFieldXId.setText(parameter.getId().toString());
        textFieldXId.setEnabled(false);
        textFieldXIdNama.setText(parameter.getNama());
        textAreaInfo.setText(parameter.getInfo());
                
        data = parameter;
        
        setVisible(true);
        
        return data;
    }
    
    public void detail(KategoriBuku parameter) {
                
        jLabelInfo.setText("Detail KategoriBuku");
        setTitle("Detail KategoriBuku");
        
        textFieldXId.setText(parameter.getId().toString());
        textFieldXIdNama.setText(parameter.getNama());
        textAreaInfo.setText(parameter.getInfo());
        
        textFieldXId.setEnabled(false);
        textFieldXIdNama.setEnabled(false);
        textAreaInfo.setEnabled(false);
       
        buttonGreen1.setVisible(false);
        buttonRed1.setText("Oke");
        
        setVisible(true);
        
    }
    
    public boolean delete(KategoriBuku parameter) {
        
        deleteMode=true;
                
        jLabelInfo.setText("Yakin Hapus?");
        setTitle("Hapus KategoriBuku");
        
        textFieldXId.setText(parameter.getId().toString());
        textFieldXIdNama.setText(parameter.getNama());
        textAreaInfo.setText(parameter.getInfo());
        
        textFieldXId.setEnabled(false);
        textFieldXIdNama.setEnabled(false);
        textAreaInfo.setEnabled(false);
        
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

        viewPortX2 = new com.bustomi.bookstorepos.component.ViewPortX();
        textAreaInfo = new javax.swing.JTextArea();
        panelXBack1 = new com.bustomi.bookstorepos.component.PanelXBack();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldXId = new com.bustomi.bookstorepos.component.TextFieldX();
        jScrollPaneInfo = new javax.swing.JScrollPane();
        jLabel14 = new javax.swing.JLabel();
        textFieldXIdNama = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        textAreaInfo.setColumns(20);
        textAreaInfo.setRows(5);
        textAreaInfo.setOpaque(false);
        viewPortX2.add(textAreaInfo);

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

        jScrollPaneInfo.setOpaque(false);
        jScrollPaneInfo.setViewport(viewPortX2);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Info :");

        textFieldXIdNama.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldXIdNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldXIdNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            String nama=textFieldXIdNama.getText();
            
            
            if (!editMode) {
                data = new KategoriBuku();
                
            }
            data.setInfo(info);
            data.setNama(nama);
            
            KategoriBukuValidator validator=SpringManager.getInstance().getBean(KategoriBukuValidator.class);
            try {
                validator.validate(data);
                dispose();
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }            
        }
        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        data=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        data = null;
    }//GEN-LAST:event_formWindowClosing

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private javax.swing.JTextArea textAreaInfo;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXId;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXIdNama;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    // End of variables declaration//GEN-END:variables
    
    
}
