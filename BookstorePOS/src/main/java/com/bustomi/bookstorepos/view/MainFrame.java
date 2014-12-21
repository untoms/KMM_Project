/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * Form.java
 *
 * Created on Nov 21, 2011, 10:52:35 PM
 */
package com.bustomi.bookstorepos.view;

import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.entity.User.Role;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.manager.LoginManager;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.UserService;
import com.bustomi.bookstorepos.view.dialog.DialogApaLakukan;
import com.bustomi.bookstorepos.view.dialog.DialogCetakBarcode;
import com.bustomi.bookstorepos.view.dialog.DialogGrafik;
import com.bustomi.bookstorepos.view.dialog.DialogLogin;
import com.bustomi.bookstorepos.view.panel.*;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.Date;
import javax.swing.JFrame;


/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class MainFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    private final PanelWelcome panelWelcome;
    private final PanelBuku panelBuku;
    private final PanelPemasok panelPemasok;
    private final PanelPelanggan panelPelanggan;
    private final PanelKategoriBarang panelKategoriBarang;
    private final PanelKategoriBuku panelKategoriBuku;
    private final PanelSatuan panelSatuan;
    private final PanelPengarang panelPengarang;
    private final PanelPenerbit panelPenerbit;
    private final PanelUser panelUser;
    private final PanelGrup panelGrup;
    private final PanelPembelian panelPembelian;
    private final PanelPenjualan panelPenjualan;
    private final PanelTransPembelian panelTransPembelian;
    private final PanelBarang panelBarang;
    private final PanelTransPenjualan panelTransPenjualan;
    private final PanelKatalogBuku panelKatalogBuku;
    private final PanelHutang panelHutang;
    private final PanelPengeluaran panelPengeluaran;
    private final PanelPemasukan panelPemasukan;
    private final PanelKeuntungan panelKeuntungan;
    private final PanelJurnal panelJurnal;
    private final PanelAbout panelAbout;
    
    public MainFrame()  {
        initComponents();
        
        panelWelcome =new PanelWelcome();
        PanelCard.add(panelWelcome, "welcome");
        
        panelBuku = new PanelBuku();
        PanelCard.add(panelBuku, "buku");
        
        panelPemasok = new PanelPemasok();
        PanelCard.add(panelPemasok, "pemasok");
        
        panelPelanggan = new PanelPelanggan();
        PanelCard.add(panelPelanggan, "pelanggan");
        
        panelKategoriBarang = new PanelKategoriBarang();
        PanelCard.add(panelKategoriBarang, "kategoriBarang");
        
        panelKategoriBuku = new PanelKategoriBuku();
        PanelCard.add(panelKategoriBuku, "kategoriBuku");
        
        panelSatuan = new PanelSatuan();
        PanelCard.add(panelSatuan, "satuan");
        
        panelPengarang = new PanelPengarang();
        PanelCard.add(panelPengarang, "pengarang");
        
        panelPenerbit = new PanelPenerbit();
        PanelCard.add(panelPenerbit, "penerbit");
        
        panelUser = new PanelUser();
        PanelCard.add(panelUser, "user");
        
        panelGrup = new PanelGrup();
        PanelCard.add(panelGrup, "grup");
        
        panelPenjualan = new PanelPenjualan();
        PanelCard.add(panelPenjualan, "penjualan");
        
        panelPembelian = new PanelPembelian();
        PanelCard.add(panelPembelian, "pembelian");
        
        panelTransPembelian = new PanelTransPembelian();
        PanelCard.add(panelTransPembelian, "transPembelian");
        
        panelBarang = new PanelBarang();
        PanelCard.add(panelBarang, "barang");
        
        panelTransPenjualan = new PanelTransPenjualan();
        PanelCard.add(panelTransPenjualan, "transPenjualan");
        
        panelKatalogBuku = new PanelKatalogBuku();
        PanelCard.add(panelKatalogBuku, "katalog");
        
        panelHutang = new PanelHutang();
        PanelCard.add(panelHutang, "hutang");
        
        panelPengeluaran = new PanelPengeluaran();
        PanelCard.add(panelPengeluaran, "pengeluaran");
        
        panelPemasukan = new PanelPemasukan();
        PanelCard.add(panelPemasukan, "pemasukan");
        
        panelKeuntungan = new PanelKeuntungan();
        PanelCard.add(panelKeuntungan, "keuntungan");
        
        panelJurnal = new PanelJurnal();
        PanelCard.add(panelJurnal, "jurnal");
        
        panelAbout = new PanelAbout();
        PanelCard.add(panelAbout, "tentang");
        
        LabelUser.setText(LoginManager.getInstance().getUser().getNama());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        panelXBack1 = new com.bustomi.bookstorepos.component.PanelXBack();
        PanelCard = new javax.swing.JPanel();
        panelXFoot1 = new com.bustomi.bookstorepos.component.PanelXFoot();
        jLabel1 = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        digitalClock1 = new com.bustomi.bookstorepos.component.DigitalClock();
        jMenuBarApp = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuItemHome = new javax.swing.JMenuItem();
        jMenuAplikasi = new javax.swing.JMenu();
        jMenuItemKeluarAplikasi = new javax.swing.JMenuItem();
        jMenuItemTutupAplikasi = new javax.swing.JMenuItem();
        jMenuDataMaster = new javax.swing.JMenu();
        jMenuItemKategori = new javax.swing.JMenuItem();
        jMenuItemSatuan = new javax.swing.JMenuItem();
        jMenuItemBarang = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemKategoriBuku = new javax.swing.JMenuItem();
        jMenuItemPenerbit = new javax.swing.JMenuItem();
        jMenuItemPengarang = new javax.swing.JMenuItem();
        jMenuItemBuku = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPemasok = new javax.swing.JMenuItem();
        jMenuItemPelanggan = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuTransaksi = new javax.swing.JMenu();
        jMenuItemPenjualan = new javax.swing.JMenuItem();
        jMenuItemPembelian = new javax.swing.JMenuItem();
        jMenuOperasional = new javax.swing.JMenu();
        jMenuItemPemasukkan = new javax.swing.JMenuItem();
        jMenuItemPengeluaran = new javax.swing.JMenuItem();
        jMenuHakAkses = new javax.swing.JMenu();
        jMenuItemGrup = new javax.swing.JMenuItem();
        jMenuItemPengguna = new javax.swing.JMenuItem();
        jMenuLaporan = new javax.swing.JMenu();
        jMenuItemLapPenjualan = new javax.swing.JMenuItem();
        jMenuItemLapPembelian = new javax.swing.JMenuItem();
        jMenuItemLapKeuntungan = new javax.swing.JMenuItem();
        jMenuItemJurnal = new javax.swing.JMenuItem();
        jMenuItemBarcode = new javax.swing.JMenuItem();
        jMenuItemGrafik = new javax.swing.JMenuItem();
        jMenuItemHutang = new javax.swing.JMenuItem();
        jMenuTentang = new javax.swing.JMenu();
        jMenuItemTentang = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.setName("jMenuItem1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simpenan (Sistem Informasi Manajemen Penjualan)");

        panelXBack1.setName("panelXBack1"); // NOI18N

        PanelCard.setName("PanelCard"); // NOI18N
        PanelCard.setOpaque(false);
        PanelCard.setLayout(new java.awt.CardLayout());

        panelXFoot1.setName("panelXFoot1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("User :");
        jLabel1.setName("jLabel1"); // NOI18N

        LabelUser.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelUser.setText("User :");
        LabelUser.setName("LabelUser"); // NOI18N

        digitalClock1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        digitalClock1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        digitalClock1.setName("digitalClock1"); // NOI18N

        javax.swing.GroupLayout panelXFoot1Layout = new javax.swing.GroupLayout(panelXFoot1);
        panelXFoot1.setLayout(panelXFoot1Layout);
        panelXFoot1Layout.setHorizontalGroup(
            panelXFoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXFoot1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(digitalClock1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelXFoot1Layout.setVerticalGroup(
            panelXFoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXFoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(digitalClock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelXBack1Layout = new javax.swing.GroupLayout(panelXBack1);
        panelXBack1.setLayout(panelXBack1Layout);
        panelXBack1Layout.setHorizontalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
            .addComponent(panelXFoot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelXBack1Layout.setVerticalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addComponent(PanelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelXFoot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelXBack1, java.awt.BorderLayout.CENTER);

        jMenuBarApp.setBackground(new java.awt.Color(204, 0, 51));
        jMenuBarApp.setName("jMenuBarApp"); // NOI18N
        jMenuBarApp.setOpaque(false);

        jMenuHome.setText("Home");
        jMenuHome.setName("jMenuHome"); // NOI18N
        jMenuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHomeActionPerformed(evt);
            }
        });

        jMenuItemHome.setText("Home");
        jMenuItemHome.setName("jMenuItemHome"); // NOI18N
        jMenuItemHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuHome.add(jMenuItemHome);

        jMenuBarApp.add(jMenuHome);

        jMenuAplikasi.setText("Aplikasi");
        jMenuAplikasi.setName("jMenuAplikasi"); // NOI18N

        jMenuItemKeluarAplikasi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemKeluarAplikasi.setText("Keluar Pengguna");
        jMenuItemKeluarAplikasi.setName("jMenuItemKeluarAplikasi"); // NOI18N
        jMenuItemKeluarAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuAplikasi.add(jMenuItemKeluarAplikasi);

        jMenuItemTutupAplikasi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemTutupAplikasi.setText("Tutup Aplikasi");
        jMenuItemTutupAplikasi.setName("jMenuItemTutupAplikasi"); // NOI18N
        jMenuItemTutupAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuAplikasi.add(jMenuItemTutupAplikasi);

        jMenuBarApp.add(jMenuAplikasi);

        jMenuDataMaster.setText("Data Master");
        jMenuDataMaster.setName("jMenuDataMaster"); // NOI18N

        jMenuItemKategori.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemKategori.setText("Kategori Barang");
        jMenuItemKategori.setName("jMenuItemKategori"); // NOI18N
        jMenuItemKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemKategori);

        jMenuItemSatuan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSatuan.setText("Satuan");
        jMenuItemSatuan.setName("jMenuItemSatuan"); // NOI18N
        jMenuItemSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemSatuan);

        jMenuItemBarang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBarang.setText("Barang");
        jMenuItemBarang.setName("jMenuItemBarang"); // NOI18N
        jMenuItemBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemBarang);

        jSeparator3.setName("jSeparator3"); // NOI18N
        jMenuDataMaster.add(jSeparator3);

        jMenuItemKategoriBuku.setText("Kategori Buku");
        jMenuItemKategoriBuku.setName("jMenuItemKategoriBuku"); // NOI18N
        jMenuItemKategoriBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemKategoriBuku);

        jMenuItemPenerbit.setText("Penerbit");
        jMenuItemPenerbit.setName("jMenuItemPenerbit"); // NOI18N
        jMenuItemPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemPenerbit);

        jMenuItemPengarang.setText("Pengarang");
        jMenuItemPengarang.setName("jMenuItemPengarang"); // NOI18N
        jMenuItemPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemPengarang);

        jMenuItemBuku.setText("Buku");
        jMenuItemBuku.setName("jMenuItemBuku"); // NOI18N
        jMenuItemBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemBuku);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenuDataMaster.add(jSeparator1);

        jMenuItemPemasok.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPemasok.setText("Pemasok");
        jMenuItemPemasok.setName("jMenuItemPemasok"); // NOI18N
        jMenuItemPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemPemasok);

        jMenuItemPelanggan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPelanggan.setText("Pelanggan");
        jMenuItemPelanggan.setName("jMenuItemPelanggan"); // NOI18N
        jMenuItemPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuDataMaster.add(jMenuItemPelanggan);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jMenuDataMaster.add(jSeparator2);

        jMenuBarApp.add(jMenuDataMaster);

        jMenuTransaksi.setText("Transaksi");
        jMenuTransaksi.setName("jMenuTransaksi"); // NOI18N

        jMenuItemPenjualan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemPenjualan.setText("Penjualan");
        jMenuItemPenjualan.setName("jMenuItemPenjualan"); // NOI18N
        jMenuItemPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuTransaksi.add(jMenuItemPenjualan);

        jMenuItemPembelian.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemPembelian.setText("Pembelian");
        jMenuItemPembelian.setName("jMenuItemPembelian"); // NOI18N
        jMenuItemPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuTransaksi.add(jMenuItemPembelian);

        jMenuOperasional.setText("Operasional");
        jMenuOperasional.setName("jMenuOperasional"); // NOI18N

        jMenuItemPemasukkan.setText("Pemasukkan");
        jMenuItemPemasukkan.setName("jMenuItemPemasukkan"); // NOI18N
        jMenuItemPemasukkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuOperasional.add(jMenuItemPemasukkan);

        jMenuItemPengeluaran.setText("Pengeluaran");
        jMenuItemPengeluaran.setName("jMenuItemPengeluaran"); // NOI18N
        jMenuItemPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuOperasional.add(jMenuItemPengeluaran);

        jMenuTransaksi.add(jMenuOperasional);

        jMenuBarApp.add(jMenuTransaksi);

        jMenuHakAkses.setText("Hak Akses");
        jMenuHakAkses.setName("jMenuHakAkses"); // NOI18N

        jMenuItemGrup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGrup.setText("Grup");
        jMenuItemGrup.setName("jMenuItemGrup"); // NOI18N
        jMenuItemGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuHakAkses.add(jMenuItemGrup);

        jMenuItemPengguna.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPengguna.setText("Pengguna");
        jMenuItemPengguna.setName("jMenuItemPengguna"); // NOI18N
        jMenuItemPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuHakAkses.add(jMenuItemPengguna);

        jMenuBarApp.add(jMenuHakAkses);

        jMenuLaporan.setText("Laporan");
        jMenuLaporan.setName("jMenuLaporan"); // NOI18N

        jMenuItemLapPenjualan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLapPenjualan.setText("Penjualan");
        jMenuItemLapPenjualan.setName("jMenuItemLapPenjualan"); // NOI18N
        jMenuItemLapPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemLapPenjualan);

        jMenuItemLapPembelian.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLapPembelian.setText("Pembelian");
        jMenuItemLapPembelian.setName("jMenuItemLapPembelian"); // NOI18N
        jMenuItemLapPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemLapPembelian);

        jMenuItemLapKeuntungan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLapKeuntungan.setText("Keuntungan");
        jMenuItemLapKeuntungan.setName("jMenuItemLapKeuntungan"); // NOI18N
        jMenuItemLapKeuntungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemLapKeuntungan);

        jMenuItemJurnal.setText("Jurnal");
        jMenuItemJurnal.setName("jMenuItemJurnal"); // NOI18N
        jMenuItemJurnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemJurnal);

        jMenuItemBarcode.setText("Barcode");
        jMenuItemBarcode.setName("jMenuItemBarcode"); // NOI18N
        jMenuItemBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemBarcode);

        jMenuItemGrafik.setText("Grafik");
        jMenuItemGrafik.setName("jMenuItemGrafik"); // NOI18N
        jMenuItemGrafik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemGrafik);

        jMenuItemHutang.setText("Hutang");
        jMenuItemHutang.setName("jMenuItemHutang"); // NOI18N
        jMenuItemHutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuLaporan.add(jMenuItemHutang);

        jMenuBarApp.add(jMenuLaporan);

        jMenuTentang.setText("Tentang");
        jMenuTentang.setName("jMenuTentang"); // NOI18N

        jMenuItemTentang.setText("Tentang Kami");
        jMenuItemTentang.setName("jMenuItemTentang"); // NOI18N
        jMenuItemTentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMenuItem(evt);
            }
        });
        jMenuTentang.add(jMenuItemTentang);

        jMenuBarApp.add(jMenuTentang);

        setJMenuBar(jMenuBarApp);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-824)/2, (screenSize.height-616)/2, 824, 616);
    }// </editor-fold>//GEN-END:initComponents

    private void actionMenuItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionMenuItem
        Object source = evt.getSource();
        if(source == jMenuItemHome){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "welcome");  
        }else if (source == jMenuItemBarang) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "barang");
        } else if (source == jMenuItemKategoriBuku){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "kategoriBuku");
        } else if (source == jMenuItemPenerbit){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "penerbit");
        } else if (source == jMenuItemPengarang){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "pengarang");
        } else if (source == jMenuItemBuku){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "buku");
        } else if (source == jMenuHome) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "welcome");            
        } else if (source == jMenuItemGrup) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "grup"); 
//        } else if (source == jMenuItemJabatan) {
//            
//        } else if (source == jMenuItemKaryawan) {
//            
        } else if (source == jMenuItemKategori) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "kategoriBarang");
        } else if (source == jMenuItemKeluarAplikasi) { 
            LoginManager.getInstance().logout();
            this.dispose();
            
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    DialogLogin login=new DialogLogin();
                    login.setVisible(true);
                    MainFrame frame;
                    if (!login.isDisplayable()) {
                        frame = new MainFrame();
                        frame.renderHakAkses();
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        frame.setVisible(true);
                    }
                }
            });
            
        } else if (source == jMenuItemLapKeuntungan) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "keuntungan");            
        } else if (source == jMenuItemPelanggan) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "pelanggan");
        } else if (source == jMenuItemPemasok) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "pemasok");
        } else if (source == jMenuItemLapPenjualan) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "penjualan");            
        } else if (source == jMenuItemPembelian) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "transPembelian");
        } else if (source == jMenuItemLapPembelian) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "pembelian");
        } else if (source == jMenuItemPengguna) {
            if (LoginManager.getInstance().getUser().getId().equals("admin")) {
                CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
                cardLayout.show(PanelCard, "user");
            }else{
                DialogApaLakukan dal=new DialogApaLakukan();
                dal.setLocationRelativeTo(this);
                dal.setVisible(true);
            }
             
//        } else if (source == jMenuItemPenjual) {
            
        } else if (source == jMenuItemPenjualan) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "transPenjualan");             
        } else if (source == jMenuItemSatuan) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "satuan");
        } else if (source == jMenuItemTutupAplikasi) {
            System.exit(0);
        } else if (source == jMenuItemPemasukkan) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "pemasukan");            
        } else if (source == jMenuItemPengeluaran) {
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "pengeluaran");
        } else if (source == jMenuHome){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "welcome");
        } else if(source == jMenuTentang){
            
        } else if(source == jMenuItemHutang){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "hutang");
        } else if(source == jMenuItemBarcode){
            DialogCetakBarcode barcode=new DialogCetakBarcode();
            barcode.setLocationRelativeTo(this);
            barcode.setVisible(true);            
        } else if(source == jMenuItemGrafik){
            DialogGrafik grafik=new DialogGrafik();
            grafik.setLocationRelativeTo(this);
            grafik.setVisible(true);            
        } else if (source == jMenuItemJurnal){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "jurnal");
        } else if (source == jMenuItemTentang){
            CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
            cardLayout.show(PanelCard, "tentang");
        }             
    }//GEN-LAST:event_actionMenuItem

    private void jMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        CardLayout cardLayout=(CardLayout) PanelCard.getLayout();
        cardLayout.show(PanelCard, "welcome");  
    }//GEN-LAST:event_jMenuHomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelUser;
    private javax.swing.JPanel PanelCard;
    private com.bustomi.bookstorepos.component.DigitalClock digitalClock1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuAplikasi;
    private javax.swing.JMenuBar jMenuBarApp;
    private javax.swing.JMenu jMenuDataMaster;
    private javax.swing.JMenu jMenuHakAkses;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBarang;
    private javax.swing.JMenuItem jMenuItemBarcode;
    private javax.swing.JMenuItem jMenuItemBuku;
    private javax.swing.JMenuItem jMenuItemGrafik;
    private javax.swing.JMenuItem jMenuItemGrup;
    private javax.swing.JMenuItem jMenuItemHome;
    private javax.swing.JMenuItem jMenuItemHutang;
    private javax.swing.JMenuItem jMenuItemJurnal;
    private javax.swing.JMenuItem jMenuItemKategori;
    private javax.swing.JMenuItem jMenuItemKategoriBuku;
    private javax.swing.JMenuItem jMenuItemKeluarAplikasi;
    private javax.swing.JMenuItem jMenuItemLapKeuntungan;
    private javax.swing.JMenuItem jMenuItemLapPembelian;
    private javax.swing.JMenuItem jMenuItemLapPenjualan;
    private javax.swing.JMenuItem jMenuItemPelanggan;
    private javax.swing.JMenuItem jMenuItemPemasok;
    private javax.swing.JMenuItem jMenuItemPemasukkan;
    private javax.swing.JMenuItem jMenuItemPembelian;
    private javax.swing.JMenuItem jMenuItemPenerbit;
    private javax.swing.JMenuItem jMenuItemPengarang;
    private javax.swing.JMenuItem jMenuItemPengeluaran;
    private javax.swing.JMenuItem jMenuItemPengguna;
    private javax.swing.JMenuItem jMenuItemPenjualan;
    private javax.swing.JMenuItem jMenuItemSatuan;
    private javax.swing.JMenuItem jMenuItemTentang;
    private javax.swing.JMenuItem jMenuItemTutupAplikasi;
    private javax.swing.JMenu jMenuLaporan;
    private javax.swing.JMenu jMenuOperasional;
    private javax.swing.JMenu jMenuTentang;
    private javax.swing.JMenu jMenuTransaksi;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private com.bustomi.bookstorepos.component.PanelXFoot panelXFoot1;
    // End of variables declaration//GEN-END:variables

   
    public void renderHakAkses() {
        User user = LoginManager.getInstance().getUser();
        user.setTerakhir_login(new Date());
        UserService service=SpringManager.getInstance().getBean(UserService.class);
        service.update(user);
        Grup grup = user.getGrup();

        jMenuItemBarang.setEnabled(grup.mengandungHakAkses(Role.LIHAT_BARANG));
        jMenuItemGrup.setEnabled(grup.mengandungHakAkses(Role.LIHAT_GRUP));
//        jMenuItemJabatan.setEnabled(grup.mengandungHakAkses(Role.LIHAT_JABATAN));
//        jMenuItemKaryawan.setEnabled(grup.mengandungHakAkses(Role.LIHAT_KARYAWAN));
        jMenuItemKategori.setEnabled(grup.mengandungHakAkses(Role.LIHAT_KATEGORI_BARANG));
        jMenuItemLapKeuntungan.setEnabled(grup.mengandungHakAkses(Role.LIHAT_LAPORAN_KEUNTUNGAN));
        jMenuItemPelanggan.setEnabled(grup.mengandungHakAkses(Role.LIHAT_PELANGGAN));
        jMenuItemPemasok.setEnabled(grup.mengandungHakAkses(Role.LIHAT_PEMASOK));
        jMenuItemLapPenjualan.setEnabled(grup.mengandungHakAkses(Role.LIHAT_LAPORAN_PENJUALAN));
        jMenuItemPembelian.setEnabled(grup.mengandungHakAkses(Role.TRANSAKSI_PEMBELIAN));
        jMenuItemLapPembelian.setEnabled(grup.mengandungHakAkses(Role.LIHAT_LAPORAN_PEMBELIAN));
        jMenuItemPengguna.setEnabled(grup.mengandungHakAkses(Role.LIHAT_PENGGUNA));
//        jMenuItemPenjual.setEnabled(grup.mengandungHakAkses(Role.LIHAT_PENJUAL));
        jMenuItemPenjualan.setEnabled(grup.mengandungHakAkses(Role.TRANSAKSI_PENJUALAN));
        jMenuItemSatuan.setEnabled(grup.mengandungHakAkses(Role.LIHAT_SATUAN));
        jMenuItemKategoriBuku.setEnabled(grup.mengandungHakAkses(Role.LIHAT_KATEGORI_BUKU));
        jMenuItemPenerbit.setEnabled(grup.mengandungHakAkses(Role.LIHAT_PENERBIT));
        jMenuItemPengarang.setEnabled(grup.mengandungHakAkses(Role.LIHAT_PENGARANG));
        jMenuItemBuku.setEnabled(grup.mengandungHakAkses(Role.LIHAT_BUKU));
        jMenuItemJurnal.setEnabled(grup.mengandungHakAkses(Role.LIHAT_LAPORAN_JURNAL));
        jMenuItemBarcode.setEnabled(grup.mengandungHakAkses(Role.LIHAT_LAPORAN_BARCODE));
        jMenuItemGrafik.setEnabled(grup.mengandungHakAkses(Role.LIHAT_LAPORAN_GRAFIK));
        jMenuItemHutang.setEnabled(grup.mengandungHakAkses(Role.LIHAT_HUTANG));

    }
}
