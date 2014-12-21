/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.panel;

import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.PembelianService;
import com.bustomi.bookstorepos.view.dialog.DialogBayarHutang;
import com.bustomi.bookstorepos.view.dialog.DialogDetailPembelian;
import com.bustomi.bookstorepos.view.dialog.DialogLaporan;
import com.bustomi.bookstorepos.view.tablemodel.HurufRender;
import com.bustomi.bookstorepos.view.tablemodel.TabelModelHutangPembelian;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author PacuL
 */
public class PanelHutang extends javax.swing.JPanel {

    private final TabelModelHutangPembelian modelPembelian;    
    private Date mulai;
    private Date sampai;
    private boolean filter=false;
    
    public PanelHutang()  {
        
        modelPembelian=new TabelModelHutangPembelian();
        initComponents();
        
        TabelPembelian.setModel(modelPembelian);
        
        TabelPembelian.getColumnModel().getColumn(0).setMaxWidth(50);
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
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonMin1 = new com.bustomi.bookstorepos.component.ButtonMin();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel2 = new javax.swing.JLabel();
        buttonMin2 = new com.bustomi.bookstorepos.component.ButtonMin();
        jDateChooserMulai = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserSampai = new com.toedter.calendar.JDateChooser();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

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

        setOpaque(false);

        panelX1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        buttonBlue1.setText("Detail Hutang");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonBlue1);

        buttonGreen1.setText("Bayar Hutang");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonGreen1);

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
        jLabel1.setText("DAFTAR HUTANG PEMBELIAN");

        panelX2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mulai :");

        buttonMin2.setText("Filter");
        buttonMin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sampai :");

        javax.swing.GroupLayout panelX2Layout = new javax.swing.GroupLayout(panelX2);
        panelX2.setLayout(panelX2Layout);
        panelX2Layout.setHorizontalGroup(
            panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooserMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelX2Layout.setVerticalGroup(
            panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX2Layout.createSequentialGroup()
                .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelX2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooserSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(6, 6, 6))
        );

        buttonRed1.setText("CETAK LAPORAN");
        buttonRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRed1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRed1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
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
            dialogDetailPembelian.setVisible(true);
        }
    }//GEN-LAST:event_buttonBlue1ActionPerformed

    private void buttonMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin1ActionPerformed
        modelPembelian.fireTableDataChanged();
    }//GEN-LAST:event_buttonMin1ActionPerformed

    private void buttonMin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin2ActionPerformed
        mulai=jDateChooserMulai.getDate();
        sampai=jDateChooserSampai.getDate();
        
        if (mulai == null) {
            JOptionPane.showMessageDialog(this, "Tanggal 'mulai' belum dipilih!");
        } else if (sampai == null){
            JOptionPane.showMessageDialog(this, "Tanggal 'sampai' belum dipilih");            
        } else {
            filter = true;
            PembelianService service=SpringManager.getInstance().getBean(PembelianService.class);
            List<Pembelian> pembelians=service.findHutangTgl(mulai,sampai);
            if (pembelians != null) {
                modelPembelian.load(pembelians);
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada transaksi");
            }
        }
        
    }//GEN-LAST:event_buttonMin2ActionPerformed

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
        if (TabelPembelian.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data hutang untuk dibayar!");
        }else {
            int pilih=TabelPembelian.convertRowIndexToModel(TabelPembelian.getSelectedRow());
            Pembelian pembelian=modelPembelian.ambilData(pilih);
            DialogBayarHutang bayarHutang=new DialogBayarHutang();
            bayarHutang.setLocationRelativeTo(this);
            Pembelian hasil=bayarHutang.bayar(pembelian);
            
            if (hasil != null) {
                pembelian.setBayar(hasil.getBayar());
                pembelian.setBayar_terakhir(hasil.getBayar_terakhir());
                
                PembelianService service=SpringManager.getInstance().getBean(PembelianService.class);
                service.update(pembelian);
                
                JOptionPane.showMessageDialog(this, "Pembayaran hutang berhasil");
                modelPembelian.fireTableDataChanged();
//                loadData();
            }
            
        }
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        // TODO add your handling code here:
        if (!filter) {
            JOptionPane.showMessageDialog(this, "Silahkan filter data Jurnal");
        }else if (modelPembelian.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Daftar hutang kosong");
        } else {
            int pilih=JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin mencetak dari tanggal "+mulai+
                    " sampai tanggal "+sampai+" ?", "Pertanyaan?", JOptionPane.YES_NO_OPTION);
            if (pilih == JOptionPane.YES_OPTION) {
                
                try {
                    InputStream inputStream=PanelHutang.class.getResourceAsStream("/com/bustomi/d3ti/uns/report/hutang2.jasper");

                    JRDataSource dataSource=new JRBeanCollectionDataSource(modelPembelian.getList(), false);
                    Map<String, Object> map=new HashMap<>();
                    map.put("FROM", mulai);
                    map.put("TO", sampai);
                    map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));

                    JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,dataSource);
                    DialogLaporan dialogLaporan=new DialogLaporan(jasperPrint);
                    dialogLaporan.setLocationRelativeTo(null);
                    dialogLaporan.setVisible(true);
                } catch (JRException ex) {
                    Logger.getLogger(PanelJurnal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_buttonRed1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPembelian;
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin2;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private com.toedter.calendar.JDateChooser jDateChooserMulai;
    private com.toedter.calendar.JDateChooser jDateChooserSampai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    // End of variables declaration//GEN-END:variables
    
//    private void loadData() {
//        PembelianService barangService=SpringManager.getInstance().getBean(PembelianService.class);
//        modelPembelian.load(barangService.findHutang());
//    }

}
