/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.panel;

import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.entity.User.Role;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.entity.master.Pemasok;
import com.bustomi.bookstorepos.manager.LoginManager;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.PemasokService;
import com.bustomi.bookstorepos.view.dialog.DialogPemasok;
import com.bustomi.bookstorepos.view.tablemodel.HurufRender;
import com.bustomi.bookstorepos.view.tablemodel.TabelModelPemasok;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class PanelPemasok extends javax.swing.JPanel {

    private final TabelModelPemasok modelPemasok;
    
    public PanelPemasok()  {
        
        modelPemasok=new TabelModelPemasok();
        initComponents();
        
        TabelPemasok.setModel(modelPemasok);
        
        loadData();
        TabelPemasok.getColumnModel().getColumn(0).setMaxWidth(50);
        TabelPemasok.getColumnModel().getColumn(0).setCellRenderer(new HurufRender());
        TabelPemasok.getColumnModel().getColumn(1).setCellRenderer(new HurufRender());
        TabelPemasok.getColumnModel().getColumn(2).setCellRenderer(new HurufRender());
        TabelPemasok.getColumnModel().getColumn(3).setCellRenderer(new HurufRender());  
        TabelPemasok.getColumnModel().getColumn(4).setCellRenderer(new HurufRender());         
        TabelPemasok.getColumnModel().getColumn(5).setCellRenderer(new HurufRender()); 
        TabelPemasok.getColumnModel().getColumn(6).setCellRenderer(new HurufRender());  
        TabelPemasok.getTableHeader().setAlignmentY(CENTER_ALIGNMENT);
        
        User user=LoginManager.getInstance().getUser();
        Grup grup=user.getGrup();
        buttonGreen1.setEnabled(grup.mengandungHakAkses(Role.TAMBAH_PEMASOK));
        buttonYellow1.setEnabled(grup.mengandungHakAkses(Role.UBAH_PEMASOK));
        buttonRed1.setEnabled(grup.mengandungHakAkses(Role.HAPUS_PEMASOK));
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
        TabelPemasok = new javax.swing.JTable();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonYellow1 = new com.bustomi.bookstorepos.component.ButtonYellow();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();
        buttonMin1 = new com.bustomi.bookstorepos.component.ButtonMin();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel2 = new javax.swing.JLabel();
        textFieldXCari = new com.bustomi.bookstorepos.component.TextFieldX();
        buttonMin2 = new com.bustomi.bookstorepos.component.ButtonMin();

        TabelPemasok.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPemasok.setOpaque(false);
        viewPortX1.add(TabelPemasok);

        setOpaque(false);

        panelX1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        buttonBlue1.setText("Detail Pemasok");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonBlue1);

        buttonGreen1.setText("Tambah Pemasok");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonGreen1);

        buttonYellow1.setText("Perbarui Pemasok");
        buttonYellow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYellow1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonYellow1);

        buttonRed1.setText("Hapus Pemasok");
        buttonRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRed1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonRed1);

        buttonMin1.setText("Refresh");
        buttonMin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonMin1);

        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewport(viewPortX1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR PEMASOK");

        panelX2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama :");

        buttonMin2.setText("Filter");
        buttonMin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelX2Layout = new javax.swing.GroupLayout(panelX2);
        panelX2.setLayout(panelX2Layout);
        panelX2Layout.setHorizontalGroup(
            panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(textFieldXCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelX2Layout.setVerticalGroup(
            panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX2Layout.createSequentialGroup()
                .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(panelX2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        if (TabelPemasok.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data pemasok!");
        }else {
            DialogPemasok dialogPemasok=new DialogPemasok();
            dialogPemasok.setLocationRelativeTo(this);
            int pilih=TabelPemasok.convertRowIndexToModel(TabelPemasok.getSelectedRow());
            Pemasok pemasok=modelPemasok.ambilData(pilih);
            dialogPemasok.detail(pemasok);
            
        }
    }//GEN-LAST:event_buttonBlue1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        if (TabelPemasok.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data pemasok!");
        }else {
            int pilih=TabelPemasok.convertRowIndexToModel(TabelPemasok.getSelectedRow());
            Pemasok pemasok=modelPemasok.ambilData(pilih);
            
            DialogPemasok dialogPemasok=new DialogPemasok();
            dialogPemasok.setLocationRelativeTo(this);
            boolean hasil=dialogPemasok.delete(pemasok);
            
            if (hasil) {
                PemasokService pemasokService=SpringManager.getInstance().getBean(PemasokService.class);
                pemasokService.delete(pemasok);
            }
            
            loadData();
            
        }
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void buttonYellow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYellow1ActionPerformed
        if (TabelPemasok.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data pemasok!");
        }else {
            int pilih=TabelPemasok.convertRowIndexToModel(TabelPemasok.getSelectedRow());
            Pemasok pemasok=modelPemasok.ambilData(pilih);
            
            DialogPemasok dialogPemasok=new DialogPemasok();
            dialogPemasok.setLocationRelativeTo(this);
            Pemasok hasil=dialogPemasok.ubah(pemasok);
            if (hasil != null) {
                PemasokService pemasokService=SpringManager.getInstance().getBean(PemasokService.class);
                pemasokService.update(hasil);              
            }
            
            loadData();
            
        }
    }//GEN-LAST:event_buttonYellow1ActionPerformed

    private void buttonMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin1ActionPerformed
        loadData();
    }//GEN-LAST:event_buttonMin1ActionPerformed

    private void buttonMin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin2ActionPerformed
        String nama=textFieldXCari.getText();
        
        PemasokService service=SpringManager.getInstance().getBean(PemasokService.class);
        List<Pemasok> pemasoks=service.findAll(nama);
        if (pemasoks != null) {
            modelPemasok.load(pemasoks);
            textFieldXCari.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ada yang cocok");
        }
        
    }//GEN-LAST:event_buttonMin2ActionPerformed

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
        DialogPemasok dialogPemasok=new DialogPemasok();
        dialogPemasok.setLocationRelativeTo(this);
        
        Pemasok pemasok=dialogPemasok.tambah();
        if (pemasok != null) {
            PemasokService service=SpringManager.getInstance().getBean(PemasokService.class);
            service.save(pemasok);
        }
        loadData();
    }//GEN-LAST:event_buttonGreen1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPemasok;
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin2;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private com.bustomi.bookstorepos.component.ButtonYellow buttonYellow1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXCari;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    // End of variables declaration//GEN-END:variables
    
    private void loadData() {
        PemasokService pemasokService=SpringManager.getInstance().getBean(PemasokService.class);
        modelPemasok.load(pemasokService.findAll());
    }

}
