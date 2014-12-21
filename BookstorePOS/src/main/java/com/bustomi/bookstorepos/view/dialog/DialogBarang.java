/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.master.Barang;
import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.entity.master.KategoriBarang;
import com.bustomi.bookstorepos.entity.master.Satuan;
import com.bustomi.bookstorepos.entity.transaksi.DetailPembelian;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.KategoriBarangService;
import com.bustomi.bookstorepos.service.SatuanService;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.BarangValidator;
import com.bustomi.bookstorepos.validator.implement.ItemValidator;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogBarang extends javax.swing.JDialog {

    private Barang barang;
    private Item item;
    private DetailPembelian detailPembelian;
    private boolean editMode;
    private boolean deleteMode;
    private boolean okhapus;
    private boolean detailBeli ;
    
    public DialogBarang() {
        setModal(true);
        detailBeli = false;
        
        initComponents();
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
    
    private void loadKategori() {
        KategoriBarangService service = SpringManager.getInstance().getBean(KategoriBarangService.class);
        List<KategoriBarang> list = service.findAll();
        
        for(KategoriBarang kategori : list){
            comboBoxKategori.addItem(kategori);
        }
    }
    
    private void loadSatuan() {
        SatuanService service = SpringManager.getInstance().getBean(SatuanService.class);
        List<Satuan> list = service.findAll();
        
        for(Satuan kategori : list){
            comboBoxSatuan.addItem(kategori);
        }
    }
    
    public Barang tambah() {
        
        loadKategori();
        loadSatuan();
        
        editMode = false;        
        deleteMode = false;
        
        jLabelInfo.setText("Tambah Barang Baru");
        setTitle("Tambah Barang Baru");
        
        textFormatXJmlhBeli.setEnabled(false);
        
        setVisible(true);
        textFormatXJmlhBeli.setValue(textFormatXStok.getValue());
        return barang;
    }
    
    private void tampil(Barang parameter){
        checkBoxAuto.setEnabled(false);
        loadKategori();
        loadSatuan();
        
        textFieldXId.setText(parameter.getItem().getId());
        textFieldXId.setEnabled(false);
        
        textAreaInfo.setText(parameter.getInfo());
        textAreaInfo.setEnabled(false);
        textFieldXNama.setText(parameter.getNama());
        textFieldXNama.setEnabled(false);
        textFormatXHBeli.setValue(parameter.getItem().getHarga_beli());
        textFormatXHBeli.setEnabled(false);
        textFormatXHJual.setValue(parameter.getItem().getHarga_jual());
        textFormatXHJual.setEnabled(false);
        textFormatXStok.setValue(parameter.getItem().getStok());
        textFormatXStok.setEnabled(false);
        textFormatXJmlhBeli.setEnabled(false);
        
        comboBoxKategori.setSelectedItem(parameter.getKategoriBarang());
        comboBoxSatuan.setSelectedItem(parameter.getSatuan());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
    }
    
    public DetailPembelian tambahDetail() {
        
        loadKategori();
        loadSatuan();
        
        detailBeli = true;
        editMode = false;        
        deleteMode = false;
        textFormatXStok.setEnabled(false);
        
        jLabelInfo.setText("Tambah Barang Baru");
        setTitle("Tambah Barang Baru");
        
        setVisible(true);
       
        return detailPembelian;
    }
    
    public Barang ubah(Barang parameter){
        
        loadKategori();
        loadSatuan();
        editMode = true;
        deleteMode = false;
        
        jLabelInfo.setText("Edit Barang");
        setTitle("Edit Barang");
        
        textFieldXId.setText(parameter.getItem().getId());
        textFieldXId.setEnabled(false);
        
        textAreaInfo.setText(parameter.getInfo());
        textFieldXNama.setText(parameter.getNama());
        textFormatXHBeli.setValue(parameter.getItem().getHarga_beli());
        textFormatXHJual.setValue(parameter.getItem().getHarga_jual());
        textFormatXStok.setValue(parameter.getItem().getStok());
        
        textFormatXJmlhBeli.setEnabled(false);
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        comboBoxKategori.setSelectedItem(parameter.getKategoriBarang());
        comboBoxSatuan.setSelectedItem(parameter.getSatuan());
        
        barang = parameter;
        item = parameter.getItem();
        
        setVisible(true);
        
        return barang;
    }
    
    public void detail(Barang parameter) {
        
        editMode = false;
        deleteMode = false;
                
        jLabelInfo.setText("Detail Barang");
        setTitle("Detail Barang");
        
        tampil(parameter);
        
        buttonGreen1.setVisible(false);
        buttonRed1.setText("Oke");
        
        setVisible(true);
        
    }
    
    public boolean delete(Barang parameter) {
        
        deleteMode=true;
                
        jLabelInfo.setText("Hapus Barang");
        setTitle("Hapus Barang");
        
        tampil(parameter);
        
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
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        checkBoxAuto = new javax.swing.JCheckBox();
        jScrollPaneInfo = new javax.swing.JScrollPane();
        textFormatXHBeli = new com.bustomi.bookstorepos.component.TextFormatX();
        textFormatXStok = new com.bustomi.bookstorepos.component.TextFormatX();
        textFormatXHJual = new com.bustomi.bookstorepos.component.TextFormatX();
        comboBoxKategori = new javax.swing.JComboBox();
        comboBoxSatuan = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelDibuat = new javax.swing.JLabel();
        labelDiubah = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelPemasok = new javax.swing.JLabel();
        textFieldXNama = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabel16 = new javax.swing.JLabel();
        textFormatXJmlhBeli = new com.bustomi.bookstorepos.component.TextFormatX();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        textAreaInfo.setColumns(20);
        textAreaInfo.setForeground(new java.awt.Color(255, 255, 255));
        textAreaInfo.setRows(5);
        textAreaInfo.setOpaque(false);
        viewPortX2.add(textAreaInfo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelX1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Kategori :");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Satuan :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Harga Beli :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Harga Jual :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Stok :");

        checkBoxAuto.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxAuto.setText("Otomatis");
        checkBoxAuto.setOpaque(false);

        jScrollPaneInfo.setOpaque(false);
        jScrollPaneInfo.setViewport(viewPortX2);

        textFormatXHBeli.setValue(new BigDecimal(0.00));

        textFormatXStok.setValue(1);

        textFormatXHJual.setValue(new BigDecimal(1.00));

        comboBoxKategori.setOpaque(false);

        comboBoxSatuan.setOpaque(false);

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
        labelDibuat.setText("Dibuat");

        labelDiubah.setForeground(new java.awt.Color(255, 255, 255));
        labelDiubah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDiubah.setText("Diubah");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Pemasok :");

        labelPemasok.setForeground(new java.awt.Color(255, 255, 255));
        labelPemasok.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPemasok.setText("Pemasok");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Jumlah Beli :");

        textFormatXJmlhBeli.setValue(1);

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDibuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelDiubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPemasok, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFormatXJmlhBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBoxAuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textFieldXNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxKategori, 0, 168, Short.MAX_VALUE))
                                .addGap(34, 34, 34)))
                        .addGap(9, 9, 9)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFormatXStok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(textFormatXHJual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFormatXHBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldXId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxAuto)
                    .addComponent(jLabel9)
                    .addComponent(textFormatXHBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldXNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFormatXHJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFormatXStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16)
                    .addComponent(textFormatXJmlhBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(labelDibuat, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(labelDiubah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(labelPemasok))))
                .addContainerGap(80, Short.MAX_VALUE))
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
            String nama=textFieldXNama.getText();
            KategoriBarang kategoriBarang=(KategoriBarang) comboBoxKategori.getSelectedItem();
            Satuan satuan=(Satuan) comboBoxSatuan.getSelectedItem();
            
            String kodeitem = textFieldXId.getText();
            BigDecimal harga_beli=(BigDecimal) textFormatXHBeli.getValue();
            BigDecimal harga_jual=(BigDecimal) textFormatXHJual.getValue();
            Integer stok=(Integer) textFormatXStok.getValue();
            
            Integer jmlh=(Integer) textFormatXJmlhBeli.getValue();
            
            if (!editMode) {
                barang = new Barang();
                barang.setWaktuDibuat(new Date());
                barang.setTerakhirDirubah(new Date());
                
                item = new Item();
                item.setWaktuDibuat(new Date());
                item.setTerakhirDirubah(new Date());
                
                if (checkBoxAuto.isSelected()) {
                    long auto=new Date().getTime();
                    kodeitem=""+auto;                    
                }else{
                    kodeitem=textFieldXId.getText();
                }
                
                detailPembelian = new DetailPembelian();
                if (detailBeli) {      
                    stok=jmlh;
                }
            }else{               
                barang.setTerakhirDirubah(new Date()); 
                item.setTerakhirDirubah(new Date());
            }
            
            barang.setInfo(info);
            barang.setKategoriBarang(kategoriBarang);
            barang.setNama(nama);
            barang.setSatuan(satuan);
            
            item.setBarang(barang);
            item.setBuku(null);
            item.setHarga_beli(harga_beli);
            item.setHarga_jual(harga_jual);
            item.setId(kodeitem);
            item.setInfo(info);
            item.setNama(nama);
            item.setStok(stok);
            
            barang.setItem(item);
            
            if (detailPembelian != null) {
                detailPembelian.setHarga(item.getHarga_beli());
                detailPembelian.setItem(item);
                detailPembelian.setJumlah(jmlh); 
            }
                        
            BarangValidator barangValidator=SpringManager.getInstance().getBean(BarangValidator.class);
            ItemValidator itemValidator=SpringManager.getInstance().getBean(ItemValidator.class);
            
            try {
                barangValidator.validate(barang);
                itemValidator.validate(item);
                dispose();
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
                        
        }
        
              
        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        detailPembelian=null;
        barang=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        detailPembelian=null;
        barang=null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JCheckBox checkBoxAuto;
    private javax.swing.JComboBox comboBoxKategori;
    private javax.swing.JComboBox comboBoxSatuan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private javax.swing.JLabel labelDibuat;
    private javax.swing.JLabel labelDiubah;
    private javax.swing.JLabel labelPemasok;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private javax.swing.JTextArea textAreaInfo;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXId;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXNama;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXHBeli;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXHJual;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXJmlhBeli;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXStok;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    // End of variables declaration//GEN-END:variables
    
    public void display(Window formApp, Object parameter) {
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}
