/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.panel;

import com.bustomi.bookstorepos.entity.master.Barang;
import com.bustomi.bookstorepos.entity.master.Buku;
import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.entity.master.Pemasok;
import com.bustomi.bookstorepos.entity.transaksi.DetailPembelian;
import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.manager.LoginManager;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.BarangService;
import com.bustomi.bookstorepos.service.BukuService;
import com.bustomi.bookstorepos.service.ItemService;
import com.bustomi.bookstorepos.service.PembelianService;
import com.bustomi.bookstorepos.view.dialog.DialogBarang;
import com.bustomi.bookstorepos.view.dialog.DialogBuku;
import com.bustomi.bookstorepos.view.dialog.DialogCariPemasok;
import com.bustomi.bookstorepos.view.tablemodel.HurufRender;
import com.bustomi.bookstorepos.view.tablemodel.TabelModelDetailPembelian;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class PanelTransPembelian extends javax.swing.JPanel {

    private final TabelModelDetailPembelian modelPembelian;
    private Pemasok pemasok;
    private BigDecimal total;
    
    public PanelTransPembelian()  {
        
        modelPembelian=new TabelModelDetailPembelian();
        
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
        jLabel1 = new javax.swing.JLabel();
        panelX3 = new com.bustomi.bookstorepos.component.PanelX();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        buttonGreen3 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();
        panelX4 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel4 = new javax.swing.JLabel();
        textFieldX1 = new com.bustomi.bookstorepos.component.TextFieldX();
        buttonGreen2 = new com.bustomi.bookstorepos.component.ButtonGreen();
        panelX5 = new com.bustomi.bookstorepos.component.PanelX();
        labelTotal = new javax.swing.JLabel();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        textFormatX1 = new com.bustomi.bookstorepos.component.TextFormatX();
        jLabel2 = new javax.swing.JLabel();
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

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI PEMBELIAN");

        panelX3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail Pembelian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX3.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewport(viewPortX1);

        jPanel1.setOpaque(false);

        buttonGreen3.setText("Tambah Pembelian Barang");
        buttonGreen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen3ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGreen3);

        buttonGreen1.setText("Tambah Pembelian Buku");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGreen1);

        buttonRed1.setText("Hapus Pembelian");
        buttonRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRed1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRed1);

        javax.swing.GroupLayout panelX3Layout = new javax.swing.GroupLayout(panelX3);
        panelX3.setLayout(panelX3Layout);
        panelX3Layout.setHorizontalGroup(
            panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelX3Layout.setVerticalGroup(
            panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        panelX4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pembelian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pemasok :");

        textFieldX1.setEnabled(false);

        buttonGreen2.setText("Cari");
        buttonGreen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen2ActionPerformed(evt);
            }
        });

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
                .addGroup(panelX4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(buttonGreen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        panelX5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Harga (IDR)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX5.setForeground(new java.awt.Color(255, 255, 255));

        labelTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 0, 51));
        labelTotal.setText("0.00");

        javax.swing.GroupLayout panelX5Layout = new javax.swing.GroupLayout(panelX5);
        panelX5.setLayout(panelX5Layout);
        panelX5Layout.setHorizontalGroup(
            panelX5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelX5Layout.setVerticalGroup(
            panelX5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Uang Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

        buttonBlue1.setText("BAYAR");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });

        textFormatX1.setForeground(new java.awt.Color(51, 255, 51));
        textFormatX1.setValue(new BigDecimal(0.00));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jumlah Bayar :");

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFormatX1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFormatX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        buttonMin1.setText("RESET");
        buttonMin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelX3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelX4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelX5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonMin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(panelX4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelX5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonMin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelX3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        BigDecimal bayar=(BigDecimal) textFormatX1.getValue();
        if (pemasok == null) {
            JOptionPane.showMessageDialog(this, "Pemasok belum di pilih");
        } else if (modelPembelian.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Belum ada item yang dibeli");
        } else if (bayar.compareTo(total()) == 1){
            JOptionPane.showMessageDialog(this, "Jumlah bayar tidak boleh lebih dari total harga");
        } else{
            PembelianService service=SpringManager.getInstance().getBean(PembelianService.class);
            BukuService bukuService=SpringManager.getInstance().getBean(BukuService.class);
            BarangService barangService=SpringManager.getInstance().getBean(BarangService.class);
            ItemService itemService=SpringManager.getInstance().getBean(ItemService.class);
            
            Pembelian pembelian=new Pembelian();
            
            pembelian.setBayar(bayar);
            pembelian.setPemasok(pemasok);
            pembelian.setUser(LoginManager.getInstance().getUser());
            pembelian.setWaktu_transaksi(new Date());
            pembelian.setTerakhir_diubah(new Date());
            pembelian.setTotal(total);
                        
            if (bayar.compareTo(total()) == -1) {
                if(JOptionPane.showConfirmDialog(this, "Pembayaran belum lunas,"
                        + "\n transaksi akan masuk ke daftar hutang", "Konfirmasi transaksi",
                        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){  
                    for (int i = 0; i < modelPembelian.getRowCount(); i++) {
                        DetailPembelian detailPembelian=modelPembelian.ambilData(i);
                        Item item=detailPembelian.getItem();
                        Barang barang=item.getBarang();
                        Buku buku=item.getBuku();
                        itemService.save(item);
                        if (barang != null) {
                            barangService.save(barang);
                        }else if(buku != null){
                            bukuService.save(buku);
                        }
                        pembelian.tambahDetailPembelian(detailPembelian);
                    }
                    service.save(pembelian);
                    JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan");
                    reset();
                }
            }else{                
                for (int i = 0; i < modelPembelian.getRowCount(); i++) {
                    DetailPembelian detailPembelian=modelPembelian.ambilData(i);
                    Item item=detailPembelian.getItem();
                    Barang barang=item.getBarang();
                    Buku buku=item.getBuku();
                    itemService.save(item);
                    if (barang != null) {
                        barangService.save(barang);
                    }else if(buku != null){
                        bukuService.save(buku);
                    }
                    pembelian.tambahDetailPembelian(detailPembelian);
                }
                service.save(pembelian);
                JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan");
                reset();
            }            
        }
        
    }//GEN-LAST:event_buttonBlue1ActionPerformed

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
        DialogBuku dialogBuku=new DialogBuku();
        dialogBuku.setLocationRelativeTo(this);
        DetailPembelian dp=dialogBuku.tambahDetail();
        if (dp != null) {
            for (int i = 0; i < modelPembelian.getRowCount(); i++) {
                DetailPembelian item=modelPembelian.ambilData(i);
                if (dp.getItem().getId().equals(item.getItem().getId())) {
                    dp.setJumlah(item.getJumlah() + dp.getJumlah());
                    modelPembelian.hapus(i);
                    break;
                }
            }
            modelPembelian.tambah(dp);
            total();
        }        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonGreen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen2ActionPerformed
        DialogCariPemasok dcp=new DialogCariPemasok();
        dcp.setLocationRelativeTo(this);
        pemasok=dcp.pilih();
        if (pemasok != null) {
            textFieldX1.setText(pemasok.getNama());
        }        
    }//GEN-LAST:event_buttonGreen2ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        if (TabelPembelian.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data pembelian untuk dihapus");
        }else {
            int pilih=TabelPembelian.convertRowIndexToModel(TabelPembelian.getSelectedRow());
            modelPembelian.hapus(pilih);
            modelPembelian.fireTableDataChanged();
            total();
        }
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void buttonMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin1ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Seluruh data akan dihapus?",
                "Konfirmasi reset",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
           reset();
        }
        
    }//GEN-LAST:event_buttonMin1ActionPerformed

    private void buttonGreen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen3ActionPerformed
        DialogBarang dialogBarang=new DialogBarang();
        dialogBarang.setLocationRelativeTo(this);
        DetailPembelian dp=dialogBarang.tambahDetail();
        if (dp != null) {
            for (int i = 0; i < modelPembelian.getRowCount(); i++) {
                DetailPembelian item=modelPembelian.ambilData(i);
                if (dp.getItem().getId().equals(item.getItem().getId())) {
                    dp.setJumlah(item.getJumlah() + dp.getJumlah());
                    modelPembelian.hapus(i);
                    break;
                }
            }
            modelPembelian.tambah(dp);
            total();
        }  
    }//GEN-LAST:event_buttonGreen3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPembelian;
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen2;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen3;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotal;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX3;
    private com.bustomi.bookstorepos.component.PanelX panelX4;
    private com.bustomi.bookstorepos.component.PanelX panelX5;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldX1;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    // End of variables declaration//GEN-END:variables
 
    private BigDecimal total() {
        total = BigDecimal.ZERO;
        for (int i = 0; i < modelPembelian.getRowCount(); i++) {
            DetailPembelian detailPembelian = modelPembelian.ambilData(i);
            total = total.add(detailPembelian.getSubTotal() );
        }
        labelTotal.setText(total.toString());
        return total;
    }   
    
    private void reset(){
        pemasok=null;
        textFieldX1.setText("");
        textFormatX1.setValue(BigDecimal.ZERO);
        labelTotal.setText("0.00");
        modelPembelian.hapusSemua();
    }
}