/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.panel;

import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.PembelianService;
import com.bustomi.bookstorepos.view.dialog.DialogDetailPembelian;
import com.bustomi.bookstorepos.view.tablemodel.HurufRender;
import com.bustomi.bookstorepos.view.tablemodel.TabelModelDetailPembelian;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class PanelTransPembelian extends javax.swing.JPanel {

    private final TabelModelDetailPembelian modelPembelian;
    
    public PanelTransPembelian()  {
        
        modelPembelian=new TabelModelDetailPembelian();
        initComponents();
        
        TabelPembelian.setModel(modelPembelian);
        
        loadData();
        
        TabelPembelian.getColumnModel().getColumn(0).setCellRenderer(new HurufRender());
        TabelPembelian.getColumnModel().getColumn(1).setCellRenderer(new HurufRender());
        TabelPembelian.getColumnModel().getColumn(2).setCellRenderer(new HurufRender());
        TabelPembelian.getColumnModel().getColumn(3).setCellRenderer(new HurufRender());  
        TabelPembelian.getColumnModel().getColumn(4).setCellRenderer(new HurufRender());         
        TabelPembelian.getColumnModel().getColumn(5).setCellRenderer(new HurufRender());  
        TabelPembelian.getTableHeader().setAlignmentY(CENTER_ALIGNMENT);
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
        TabelPembelian = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        panelX3 = new com.bustomi.bookstorepos.component.PanelX();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonYellow1 = new com.bustomi.bookstorepos.component.ButtonYellow();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();
        panelX4 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel4 = new javax.swing.JLabel();
        textFieldX1 = new com.bustomi.bookstorepos.component.TextFieldX();
        buttonGreen2 = new com.bustomi.bookstorepos.component.ButtonGreen();
        panelX5 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        buttonMin1 = new com.bustomi.bookstorepos.component.ButtonMin();

        TabelPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelPembelian.setOpaque(false);
        viewPortX1.add(TabelPembelian);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI PEMBELIAN");

        panelX3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Pembelian"));

        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewport(viewPortX1);

        jPanel1.setOpaque(false);

        buttonGreen1.setText("Tambah Pembelian");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGreen1);

        buttonYellow1.setText("Update Pembelian");
        jPanel1.add(buttonYellow1);

        buttonRed1.setText("Hapus Pembelian");
        jPanel1.add(buttonRed1);

        javax.swing.GroupLayout panelX3Layout = new javax.swing.GroupLayout(panelX3);
        panelX3.setLayout(panelX3Layout);
        panelX3Layout.setHorizontalGroup(
            panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelX3Layout.setVerticalGroup(
            panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        panelX4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pembelian"));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pemasok :");

        textFieldX1.setEnabled(false);

        buttonGreen2.setText("Cari");

        javax.swing.GroupLayout panelX4Layout = new javax.swing.GroupLayout(panelX4);
        panelX4.setLayout(panelX4Layout);
        panelX4Layout.setHorizontalGroup(
            panelX4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldX1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGreen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelX4Layout.setVerticalGroup(
            panelX4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonGreen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelX5.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Harga"));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rp.");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("11.750.550,00");

        javax.swing.GroupLayout panelX5Layout = new javax.swing.GroupLayout(panelX5);
        panelX5.setLayout(panelX5Layout);
        panelX5Layout.setHorizontalGroup(
            panelX5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelX5Layout.setVerticalGroup(
            panelX5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelX1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        buttonBlue1.setText("BAYAR");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonBlue1);

        buttonMin1.setText("HUTANG");
        buttonMin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonMin1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panelX4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panelX5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelX3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelX4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelX5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(panelX3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        if (TabelPembelian.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data pembelian!");
        }else {
            int pilih=TabelPembelian.convertRowIndexToModel(TabelPembelian.getSelectedRow());
            Pembelian pembelian=modelPembelian.ambilData(pilih);
            DialogDetailPembelian dialogDetailPembelian=new DialogDetailPembelian(pembelian);
            dialogDetailPembelian.setLocationRelativeTo(this);            
        }
    }//GEN-LAST:event_buttonBlue1ActionPerformed

    private void buttonMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin1ActionPerformed
        loadData();
    }//GEN-LAST:event_buttonMin1ActionPerformed

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
        loadData();
    }//GEN-LAST:event_buttonGreen1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPembelian;
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen2;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private com.bustomi.bookstorepos.component.ButtonYellow buttonYellow1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX3;
    private com.bustomi.bookstorepos.component.PanelX panelX4;
    private com.bustomi.bookstorepos.component.PanelX panelX5;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    // End of variables declaration//GEN-END:variables
    
    public void loadData() {
        PembelianService barangService=SpringManager.getInstance().getBean(PembelianService.class);
        modelPembelian.load(barangService.findAll());
    }

}
