/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.panel;

import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.entity.User.Role;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.entity.master.Buku;
import com.bustomi.bookstorepos.manager.LoginManager;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.BukuService;
import com.bustomi.bookstorepos.service.ItemService;
import com.bustomi.bookstorepos.view.dialog.DialogBuku;
import com.bustomi.bookstorepos.view.tablemodel.HurufRender;
import com.bustomi.bookstorepos.view.tablemodel.TabelModelBuku;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;

/**
 *
 * @author PacuL
 */
public class PanelBuku extends javax.swing.JPanel implements ItemListener{

    private final TabelModelBuku modelBuku;
    
    public PanelBuku()  {
        
        modelBuku=new TabelModelBuku();
        initComponents();
        
        TabelBuku.setModel(modelBuku);
        
        loadData();
        
        TabelBuku.getColumnModel().getColumn(0).setCellRenderer(new HurufRender());
        TabelBuku.getColumnModel().getColumn(0).setMaxWidth(50);
        TabelBuku.getColumnModel().getColumn(1).setCellRenderer(new HurufRender());
        TabelBuku.getColumnModel().getColumn(2).setCellRenderer(new HurufRender());
        TabelBuku.getColumnModel().getColumn(3).setCellRenderer(new HurufRender());  
        TabelBuku.getColumnModel().getColumn(4).setCellRenderer(new HurufRender());         
        TabelBuku.getColumnModel().getColumn(5).setCellRenderer(new HurufRender()); 
        TabelBuku.getColumnModel().getColumn(6).setCellRenderer(new HurufRender());  
        TabelBuku.getColumnModel().getColumn(7).setCellRenderer(new HurufRender());         
        TabelBuku.getColumnModel().getColumn(8).setCellRenderer(new HurufRender()); 
        TabelBuku.getTableHeader().setAlignmentY(CENTER_ALIGNMENT);  
        
        User user=LoginManager.getInstance().getUser();
        Grup grup=user.getGrup();
        buttonGreen1.setEnabled(grup.mengandungHakAkses(Role.TAMBAH_BUKU));
        buttonYellow1.setEnabled(grup.mengandungHakAkses(Role.UBAH_BUKU));
        buttonRed1.setEnabled(grup.mengandungHakAkses(Role.HAPUS_BUKU)); 
        
        jRadioJudul.addItemListener(this);
        jRadioPenerbit.addItemListener(this);
        jRadioPengarang.addItemListener(this);
                
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
        TabelBuku = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonYellow1 = new com.bustomi.bookstorepos.component.ButtonYellow();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();
        buttonMin1 = new com.bustomi.bookstorepos.component.ButtonMin();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        jLabelCari = new javax.swing.JLabel();
        textFieldXCari = new com.bustomi.bookstorepos.component.TextFieldX();
        buttonMin2 = new com.bustomi.bookstorepos.component.ButtonMin();
        jLabel3 = new javax.swing.JLabel();
        jRadioJudul = new javax.swing.JRadioButton();
        jRadioPengarang = new javax.swing.JRadioButton();
        jRadioPenerbit = new javax.swing.JRadioButton();
        jRadioKategori = new javax.swing.JRadioButton();

        TabelBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelBuku.setOpaque(false);
        viewPortX1.add(TabelBuku);

        setOpaque(false);

        panelX1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        buttonBlue1.setText("Detail Buku");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonBlue1);

        buttonGreen1.setText("Tambah Buku");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonGreen1);

        buttonYellow1.setText("Perbarui Buku");
        buttonYellow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYellow1ActionPerformed(evt);
            }
        });
        panelX1.add(buttonYellow1);

        buttonRed1.setText("Hapus Buku");
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
        jLabel1.setText("DAFTAR BUKU");

        panelX2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabelCari.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCari.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCari.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCari.setText("Pencarian :");

        buttonMin2.setText("Filter");
        buttonMin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Kategori pencarian :");

        buttonGroup1.add(jRadioJudul);
        jRadioJudul.setForeground(new java.awt.Color(255, 255, 255));
        jRadioJudul.setText("Judul");
        jRadioJudul.setOpaque(false);

        buttonGroup1.add(jRadioPengarang);
        jRadioPengarang.setForeground(new java.awt.Color(255, 255, 255));
        jRadioPengarang.setText("Pengarang");
        jRadioPengarang.setOpaque(false);

        buttonGroup1.add(jRadioPenerbit);
        jRadioPenerbit.setForeground(new java.awt.Color(255, 255, 255));
        jRadioPenerbit.setText("Penerbit");
        jRadioPenerbit.setOpaque(false);

        buttonGroup1.add(jRadioKategori);
        jRadioKategori.setForeground(new java.awt.Color(255, 255, 255));
        jRadioKategori.setText("Kategori");
        jRadioKategori.setOpaque(false);

        javax.swing.GroupLayout panelX2Layout = new javax.swing.GroupLayout(panelX2);
        panelX2.setLayout(panelX2Layout);
        panelX2Layout.setHorizontalGroup(
            panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX2Layout.createSequentialGroup()
                        .addComponent(textFieldXCari, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelX2Layout.createSequentialGroup()
                        .addComponent(jRadioJudul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioPengarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioKategori)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioPenerbit)))
                .addContainerGap())
        );
        panelX2Layout.setVerticalGroup(
            panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioJudul)
                    .addComponent(jRadioPengarang)
                    .addComponent(jRadioPenerbit)
                    .addComponent(jRadioKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(panelX2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldXCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCari))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        if (TabelBuku.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data buku!");
        }else {
            DialogBuku dialogBuku=new DialogBuku();
            dialogBuku.setLocationRelativeTo(this);
            int pilih=TabelBuku.convertRowIndexToModel(TabelBuku.getSelectedRow());
            Buku buku=modelBuku.ambilData(pilih);
            dialogBuku.detail(buku);
            
        }
    }//GEN-LAST:event_buttonBlue1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        if (TabelBuku.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data buku!");
        }else {
            int pilih=TabelBuku.convertRowIndexToModel(TabelBuku.getSelectedRow());
            Buku buku=modelBuku.ambilData(pilih);
            
            DialogBuku dialogBuku=new DialogBuku();            
            dialogBuku.setLocationRelativeTo(this);
            boolean hasil=dialogBuku.delete(buku);
            
            if (hasil) {
                BukuService bukuService=SpringManager.getInstance().getBean(BukuService.class);
                bukuService.delete(buku);
            }
            
            loadData();
            
        }
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void buttonYellow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYellow1ActionPerformed
        if (TabelBuku.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data buku!");
        }else {
            int pilih=TabelBuku.convertRowIndexToModel(TabelBuku.getSelectedRow());
            Buku buku=modelBuku.ambilData(pilih);
            
            DialogBuku dialogBuku=new DialogBuku();            
            dialogBuku.setLocationRelativeTo(this);
            Buku hasil=dialogBuku.ubah(buku);
            
            if (hasil != null) {
                BukuService bukuService=SpringManager.getInstance().getBean(BukuService.class);
                ItemService itemService=SpringManager.getInstance().getBean(ItemService.class);
                itemService.update(hasil.getItem());
                bukuService.update(hasil);                
            }
            
            loadData();
            
        }
    }//GEN-LAST:event_buttonYellow1ActionPerformed

    private void buttonMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin1ActionPerformed
        buttonGroup1.clearSelection();
        jLabelCari.setText("Pencarian :");
        loadData();
    }//GEN-LAST:event_buttonMin1ActionPerformed

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
        DialogBuku dialogBuku=new DialogBuku();
        dialogBuku.setLocationRelativeTo(this);
        Buku buku=dialogBuku.tambah();
        if (buku != null) {
            BukuService service=SpringManager.getInstance().getBean(BukuService.class);
            ItemService itemService=SpringManager.getInstance().getBean(ItemService.class);
            itemService.save(buku.getItem());
            service.save(buku);
            loadData();
        }
        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonMin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin2ActionPerformed
        String nama=textFieldXCari.getText();

        BukuService service=SpringManager.getInstance().getBean(BukuService.class);

        if (!jRadioJudul.isSelected() && !jRadioPenerbit.isSelected() 
                && !jRadioPengarang.isSelected() && !jRadioKategori.isSelected()) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih kategori pencarian");
        } else if(jRadioJudul.isSelected()){
            List<Buku> list=service.findAll(nama);
            modelBuku.load(list);
            buttonGroup1.clearSelection();
        } else if(jRadioPenerbit.isSelected()){
            List<Buku> list=service.findPenerbit(nama);
            modelBuku.load(list);
            buttonGroup1.clearSelection();
        } else if(jRadioPengarang.isSelected()){
            List<Buku> list=service.findPengarang(nama);
            modelBuku.load(list);
            buttonGroup1.clearSelection();
        } else if (jRadioKategori.isSelected()){
            List<Buku> list=service.findKategori(nama);
            modelBuku.load(list);
            buttonGroup1.clearSelection();
        }

    }//GEN-LAST:event_buttonMin2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelBuku;
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin2;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private com.bustomi.bookstorepos.component.ButtonYellow buttonYellow1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCari;
    private javax.swing.JRadioButton jRadioJudul;
    private javax.swing.JRadioButton jRadioKategori;
    private javax.swing.JRadioButton jRadioPenerbit;
    private javax.swing.JRadioButton jRadioPengarang;
    private javax.swing.JScrollPane jScrollPane1;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXCari;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    // End of variables declaration//GEN-END:variables
    
    private void loadData() {
        
        new SwingWorker<List<Buku>, Object>() {

            @Override
            protected List<Buku> doInBackground() throws Exception {
                BukuService barangService=SpringManager.getInstance().getBean(BukuService.class);
                return barangService.findAll();
            }

            @Override
            protected void done() {
                try {
                    modelBuku.load(get());
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelBuku.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();     
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton jrb= (JRadioButton) e.getSource();
        if (jrb.equals(jRadioJudul)) {
            jLabelCari.setText("Judul buku :");
        } else if(jrb.equals(jRadioPenerbit)){
            jLabelCari.setText("Nama Penerbit :");
        } else if(jrb.equals(jRadioPengarang)){
            jLabelCari.setText("Nama Pengarang :");
        } else if(jrb.equals(jRadioKategori)){
            jLabelCari.setText("Kategori buku :");
        }
    }

}