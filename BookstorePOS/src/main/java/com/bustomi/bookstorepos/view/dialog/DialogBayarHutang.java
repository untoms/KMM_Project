/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogBayarHutang extends javax.swing.JDialog {

    private Pembelian data;
    private BigDecimal hutang;
    
    public DialogBayarHutang() {
        setModal(true);
        initComponents();        
        
    }           
    
    public Pembelian bayar(Pembelian parameter){
      
        jLabelInfo.setText("Pembayaran Hutang");
        setTitle("Pembayaran Hutangg");
        hutang=parameter.getTotal().subtract(parameter.getBayar());
        textFormatXHutang.setValue(hutang);
        textFormatXHutang.setEnabled(false);
               
        data = parameter;
        
        setVisible(true);
        
        return data;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelXBack1 = new com.bustomi.bookstorepos.component.PanelXBack();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFormatXHutang = new com.bustomi.bookstorepos.component.TextFormatX();
        textFormatXBayar = new com.bustomi.bookstorepos.component.TextFormatX();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Kategori Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Hutang :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Bayar :");

        textFormatXBayar.setValue(new BigDecimal(1.00));

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFormatXHutang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFormatXBayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFormatXHutang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFormatXBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("Info Dialog");
        jLabelInfo.setName(""); // NOI18N

        buttonGreen1.setText("Bayar");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
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
        BigDecimal bayar=(BigDecimal) textFormatXBayar.getValue();
        if (bayar.compareTo(BigDecimal.ZERO) <= 0 ) {
            JOptionPane.showMessageDialog(this, "Jumlah pembayaran tidak valid");
        } else if(bayar.compareTo(hutang) == 1){
            JOptionPane.showMessageDialog(this, "Jumlah pembayaran terlalu banyak");
        } else{
            data.setBayar_terakhir(bayar);
            data.setBayar(data.getBayar().add(bayar));
            dispose();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInfo;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXBayar;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXHutang;
    // End of variables declaration//GEN-END:variables
    
    
}
