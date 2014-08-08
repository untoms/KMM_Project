/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.master.Buku;
import com.bustomi.bookstorepos.entity.master.Item;
import com.bustomi.bookstorepos.entity.master.KategoriBuku;
import com.bustomi.bookstorepos.entity.master.Penerbit;
import com.bustomi.bookstorepos.entity.master.Pengarang;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.BukuService;
import com.bustomi.bookstorepos.service.ItemService;
import com.bustomi.bookstorepos.service.KategoriBukuService;
import com.bustomi.bookstorepos.service.PenerbitService;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.BukuValidator;
import com.bustomi.bookstorepos.validator.implement.ItemValidator;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogBuku extends javax.swing.JDialog {

    private Buku buku;
    private boolean editMode;
    private boolean deleteMode;
    private boolean okhapus;
    private final DefaultListModel<Pengarang> defaultListModel;
    
    public DialogBuku() {
        setModal(true);
        setModal(true);
        initComponents();
        defaultListModel= new DefaultListModel<>();
        listPengarang.setModel(defaultListModel);
        
        textAreaNama.setDisabledTextColor(Color.LIGHT_GRAY);
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
    
    public void loadKategori() {
        KategoriBukuService service = SpringManager.getInstance().getBean(KategoriBukuService.class);
        List<KategoriBuku> list = service.findAll();
        
        for(KategoriBuku kategori : list){
            comboBoxKategori.addItem(kategori);
        }
    }
    
    public void loadPenerbit() {
        PenerbitService service = SpringManager.getInstance().getBean(PenerbitService.class);
        List<Penerbit> list = service.findAll();
        
        for(Penerbit kategori : list){
            comboBoxPenrbit.addItem(kategori);
        }
    }
    
    public Buku tambah() {
        
        loadKategori();
        loadPenerbit();
        
        editMode = false;        
        deleteMode = false;
        
        jLabelInfo.setText("Tambah Buku Baru");
        setTitle("Tambah Buku Baru");
        
        setVisible(true);
        return buku;
    }
    
    public Buku ubah(Buku parameter){
        
        loadKategori();
        loadPenerbit();
        
        editMode = true;
        deleteMode = false;
        
        jLabelInfo.setText("Edit Buku");
        setTitle("Edit Buku");
        
        textFieldXId.setText(parameter.getItem().getId());
        textFieldXId.setEnabled(false);
        
        textAreaInfo.setText(parameter.getInfo());
        textAreaNama.setText(parameter.getNama());
        textFieldXISBN.setText(parameter.getISBN());
        textFormatXHBeli.setValue(parameter.getItem().getHarga_beli());
        textFormatXHJual.setValue(parameter.getItem().getHarga_jual());
        textFormatXStok.setValue(parameter.getItem().getStok());
        textFormatXTahun.setValue(parameter.getTahun_terbit());
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        for (Pengarang object : parameter.getDaftarPengarang()) {
            defaultListModel.addElement(object);
        }
        
        buku = parameter;
        
        setVisible(true);
        
        return buku;
    }
    
    public void detail(Buku parameter) {
                
        jLabelInfo.setText("Detail Buku");
        setTitle("Detail Buku");
        
        textFieldXId.setText(parameter.getItem().getId());
        textFieldXId.setEnabled(false);
        
        textAreaInfo.setText(parameter.getInfo());
        textAreaInfo.setEnabled(false);
        textAreaNama.setText(parameter.getNama());
        textAreaNama.setEnabled(false);
        textFieldXISBN.setText(parameter.getISBN());
        textFieldXISBN.setEnabled(false);
        textFormatXHBeli.setValue(parameter.getItem().getHarga_beli());
        textFormatXHBeli.setEnabled(false);
        textFormatXHJual.setValue(parameter.getItem().getHarga_jual());
        textFormatXHJual.setEnabled(false);
        textFormatXStok.setValue(parameter.getItem().getStok());
        textFormatXStok.setEnabled(false);
        textFormatXTahun.setValue(parameter.getTahun_terbit());
        textFormatXTahun.setEnabled(false);
        
        comboBoxKategori.setSelectedItem(parameter.getKategoriBuku());
        comboBoxKategori.setEnabled(false);
        comboBoxPenrbit.setSelectedItem(parameter.getPenerbit());
        comboBoxPenrbit.setEnabled(false);
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        for (Pengarang object : parameter.getDaftarPengarang()) {
            defaultListModel.addElement(object);
        }
        
        buttonBlue1.setEnabled(false);
        buttonGreen1.setVisible(false);
        buttonRed1.setText("Oke");
        
        setVisible(true);
        
    }
    
    public boolean delete(Buku parameter) {
        
        deleteMode=true;
                
        jLabelInfo.setText("Hapus Buku");
        setTitle("Hapus Buku");
        
        textFieldXId.setText(parameter.getItem().getId());
        textFieldXId.setEnabled(false);
        
        textAreaInfo.setText(parameter.getInfo());
        textAreaInfo.setEnabled(false);
        textAreaNama.setText(parameter.getNama());
        textAreaNama.setEnabled(false);
        textFieldXISBN.setText(parameter.getISBN());
        textFieldXISBN.setEnabled(false);
        textFormatXHBeli.setValue(parameter.getItem().getHarga_beli());
        textFormatXHBeli.setEnabled(false);
        textFormatXHJual.setValue(parameter.getItem().getHarga_jual());
        textFormatXHJual.setEnabled(false);
        textFormatXStok.setValue(parameter.getItem().getStok());
        textFormatXStok.setEnabled(false);
        textFormatXTahun.setValue(parameter.getTahun_terbit());
        textFormatXTahun.setEnabled(false);
        
        comboBoxKategori.setSelectedItem(parameter.getKategoriBuku());
        comboBoxKategori.setEnabled(false);
        comboBoxPenrbit.setSelectedItem(parameter.getPenerbit());
        comboBoxPenrbit.setEnabled(false);
        
        labelDibuat.setText(parameter.getWaktuDibuat().toString());
        labelDiubah.setText(parameter.getTerakhirDirubah().toString());
        
        for (Pengarang object : parameter.getDaftarPengarang()) {
            defaultListModel.addElement(object);
        }
        
        buttonBlue1.setEnabled(false);
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
        textAreaNama = new javax.swing.JTextArea();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkBoxAuto = new javax.swing.JCheckBox();
        textFieldXISBN = new com.bustomi.bookstorepos.component.TextFieldX();
        jScrollPanePengarang = new javax.swing.JScrollPane();
        jScrollPaneInfo = new javax.swing.JScrollPane();
        jScrollPaneNama = new javax.swing.JScrollPane();
        textFormatXTahun = new com.bustomi.bookstorepos.component.TextFormatX();
        textFormatXHBeli = new com.bustomi.bookstorepos.component.TextFormatX();
        textFormatXStok = new com.bustomi.bookstorepos.component.TextFormatX();
        textFormatXHJual = new com.bustomi.bookstorepos.component.TextFormatX();
        comboBoxKategori = new javax.swing.JComboBox();
        comboBoxPenrbit = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelDibuat = new javax.swing.JLabel();
        labelDiubah = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelPemasok = new javax.swing.JLabel();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        textAreaNama.setColumns(20);
        textAreaNama.setRows(5);
        textAreaNama.setOpaque(false);
        viewPortX1.add(textAreaNama);

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

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Buku"));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Judul :");

        textFieldXId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXIdActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ISBN :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Kategori :");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Pengarang :");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Penerbit :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Harga Beli :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Harga Jual :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Stok :");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tahun Terbit :");

        checkBoxAuto.setText("Otomatis");
        checkBoxAuto.setOpaque(false);
        checkBoxAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAutoActionPerformed(evt);
            }
        });

        textFieldXISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXISBNActionPerformed(evt);
            }
        });

        jScrollPanePengarang.setOpaque(false);
        jScrollPanePengarang.setViewport(viewPortX3);

        jScrollPaneInfo.setOpaque(false);
        jScrollPaneInfo.setViewport(viewPortX2);

        jScrollPaneNama.setOpaque(false);
        jScrollPaneNama.setViewport(viewPortX1);

        textFormatXTahun.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        textFormatXTahun.setValue(1945);

        textFormatXHBeli.setValue(new BigDecimal(0.00));

        textFormatXStok.setValue(1);

        textFormatXHJual.setValue(new BigDecimal(1.00));

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

        buttonBlue1.setText("Tambah/Atur Pengarang");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBoxPenrbit, javax.swing.GroupLayout.Alignment.LEADING, 0, 196, Short.MAX_VALUE)
                                    .addComponent(comboBoxKategori, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldXISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFormatXTahun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPanePengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPemasok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelDiubah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelDibuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                                .addGap(0, 6, Short.MAX_VALUE))))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelX1Layout.createSequentialGroup()
                                .addComponent(textFieldXId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBoxAuto))
                            .addComponent(jScrollPaneNama, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFormatXHJual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(textFormatXStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFormatXHBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPaneNama, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textFormatXHJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textFormatXStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldXISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textFormatXTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBoxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(labelDibuat))
                        .addGap(3, 3, 3)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboBoxPenrbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(labelDiubah)))
                    .addComponent(jScrollPaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(labelPemasok))
                    .addComponent(jScrollPanePengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
                    .addComponent(panelX1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        }else {
            
            String info=textAreaInfo.getText();
            String nama=textAreaNama.getText();
            String isbn=textFieldXISBN.getText();
            Integer terbit=(Integer) textFormatXTahun.getValue();
            KategoriBuku kategoriBuku=(KategoriBuku) comboBoxKategori.getSelectedItem();
            Penerbit penerbit=(Penerbit) comboBoxPenrbit.getSelectedItem();

            Item item=new Item();
            String kodeitem;
            String namaItem="Buku";
            BigDecimal harga_beli=(BigDecimal) textFormatXHBeli.getValue();
            BigDecimal harga_jual=(BigDecimal) textFormatXHJual.getValue();
            Integer stok=(Integer) textFormatXStok.getValue();

            if (!editMode) {
                buku = new Buku();
                buku.setWaktuDibuat(new Date());
                buku.setTerakhirDirubah(new Date());

                item.setHarga_beli(harga_beli);
                item.setHarga_jual(harga_jual);
                item.setInfo(info);
                item.setNama(namaItem);
                item.setStok(stok);            
                item.setWaktuDibuat(new Date());                
                item.setTerakhirDirubah(new Date());
            }else {
                buku.setTerakhirDirubah(new Date());
                kodeitem=textFieldXId.getText();

                item.setHarga_beli(harga_beli);
                item.setHarga_jual(harga_jual);
                item.setId(kodeitem);
                item.setInfo(info);
                item.setNama(namaItem);
                item.setStok(stok);
                item.setTerakhirDirubah(new Date());

                ItemService itemService=SpringManager.getInstance().getBean(ItemService.class);
                ItemValidator itemValidator=SpringManager.getInstance().getBean(ItemValidator.class);

                try {
                    itemValidator.validate(item);
                    itemService.save(item);
                } catch (ValidatorException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }

            }
            buku.setISBN(isbn);
            buku.setInfo(info);
            buku.setKategoriBuku(kategoriBuku);
            buku.setNama(nama);
            buku.setPenerbit(penerbit);
            buku.setTahun_terbit(terbit);
            buku.setItem(null);

            BukuValidator validator = SpringManager.getInstance().getBean(BukuValidator.class);
            BukuService service=SpringManager.getInstance().getBean(BukuService.class);

            try {
                validator.validate(buku);
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            String id;

            if (!editMode) {
                service.save(buku);

                if (checkBoxAuto.isSelected()) {
                    id="BK-"+kategoriBuku.getId()+""+penerbit.getId()+"-"+buku.getId();
                }else{
                    id=textFieldXId.getText();
                }
                item.setId(id);

            }

            buku.setItem(item);  
            
        }
        
              
        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        buku=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void textFieldXIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXIdActionPerformed

    private void textFieldXISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXISBNActionPerformed

    private void checkBoxAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxAutoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        buku = null;
    }//GEN-LAST:event_formWindowClosing

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        
        DialogPengarangRelasi dialogPengarang=new DialogPengarangRelasi();
        if (buku.getDaftarPengarang() != null) {
            
                List<Pengarang> list=dialogPengarang.ubah(buku.getDaftarPengarang(),buku.getNama());
                for (Pengarang pengarang : list) {
                    defaultListModel.addElement(pengarang);
                    buku.tambahPengarang(pengarang);
                }
        }else{
            System.out.println("Nulll");
        }
        
        
    }//GEN-LAST:event_buttonBlue1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JCheckBox checkBoxAuto;
    private javax.swing.JComboBox comboBoxKategori;
    private javax.swing.JComboBox comboBoxPenrbit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneInfo;
    private javax.swing.JScrollPane jScrollPaneNama;
    private javax.swing.JScrollPane jScrollPanePengarang;
    private javax.swing.JLabel labelDibuat;
    private javax.swing.JLabel labelDiubah;
    private javax.swing.JLabel labelPemasok;
    private javax.swing.JList listPengarang;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private javax.swing.JTextArea textAreaInfo;
    private javax.swing.JTextArea textAreaNama;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXISBN;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXId;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXHBeli;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXHJual;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXStok;
    private com.bustomi.bookstorepos.component.TextFormatX textFormatXTahun;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX3;
    // End of variables declaration//GEN-END:variables
    
    public void display(Window formApp, Object parameter) {
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}
