/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.User;

/**
 *
 * @author PacuL
 */
public enum Role {

    LIHAT_KATEGORI_BUKU("Lihat Kategori Buku"),
    TAMBAH_KATEGORI_BUKU("Tambah Kategori Buku"),
    UBAH_KATEGORI_BUKU("Ubah Kategori Buku"),
    HAPUS_KATEGORI_BUKU("Hapus Kategori Buku"),
    LIHAT_KATEGORI_BARANG("Lihat Kategori Barang"),
    TAMBAH_KATEGORI_BARANG("Tambah Kategori Barang"),
    UBAH_KATEGORI_BARANG("Ubah Kategori Barang"),
    HAPUS_KATEGORI_BARANG("Hapus Kategori Barang"),
    LIHAT_SATUAN("Lihat Satuan"),
    TAMBAH_SATUAN("Tambah Satuan"),
    UBAH_SATUAN("Ubah Satuan"),
    HAPUS_SATUAN("Hapus Satuan"),
    LIHAT_BUKU("Lihat Buku"),
    TAMBAH_BUKU("Tambah Buku"),
    UBAH_BUKU("Ubah Buku"),
    HAPUS_BUKU("Hapus Buku"),
    LIHAT_PENGARANG("Lihat Pengarang"),
    TAMBAH_PENGARANG("Tambah Pengarang"),
    UBAH_PENGARANG("Ubah Pengarang"),
    HAPUS_PENGARANG("Hapus Pengarang"),
    LIHAT_PENERBIT("Lihat Penerbit"),
    TAMBAH_PENERBIT("Tambah Penerbit"),
    UBAH_PENERBIT("Ubah Penerbit"),
    HAPUS_PENERBIT("Hapus Penerbit"),
    LIHAT_BARANG("Lihat Barang"),
    TAMBAH_BARANG("Tambah Barang"),
    UBAH_BARANG("Ubah Barang"),
    HAPUS_BARANG("Hapus Barang"),
    LIHAT_ITEM("Lihat Item"),
    TAMBAH_ITEM("Tambah Item"),
    UBAH_ITEM("Ubah Item"),
    HAPUS_ITEM("Hapus Item"),
    LIHAT_PEMASOK("Lihat Pemasok"),
    TAMBAH_PEMASOK("Tambah Pemasok"),
    UBAH_PEMASOK("Ubah Pemasok"),
    HAPUS_PEMASOK("Hapus Pemasok"),
    LIHAT_PELANGGAN("Lihat Pelanggan"),
    TAMBAH_PELANGGAN("Tambah Pelanggan"),
    UBAH_PELANGGAN("Ubah Pelanggan"),
    HAPUS_PELANGGAN("Hapus Pelanggan"),
    LIHAT_PENJUAL("Lihat Penjual"),
    TAMBAH_PENJUAL("Tambah Penjual"),
    UBAH_PENJUAL("Ubah Penjual"),
    HAPUS_PENJUAL("Hapus Penjual"),
    LIHAT_JABATAN("Lihat Jabatan"),
    TAMBAH_JABATAN("Tambah Jabatan"),
    UBAH_JABATAN("Ubah Jabatan"),
    HAPUS_JABATAN("Hapus Jabatan"),
    LIHAT_KARYAWAN("Lihat Karyawan"),
    TAMBAH_KARYAWAN("Tambah Karyawan"),
    UBAH_KARYAWAN("Ubah Karyawan"),
    HAPUS_KARYAWAN("Hapus Karyawan"),
    LIHAT_GRUP("Lihat Grup"),
    TAMBAH_GRUP("Tambah Grup"),
    UBAH_GRUP("Ubah Grup"),
    HAPUS_GRUP("Hapus Grup"),
    LIHAT_PENGGUNA("Lihat Pengguna"),
    TAMBAH_PENGGUNA("Tambah Pengguna"),
    UBAH_PENGGUNA("Ubah Pengguna"),
    HAPUS_PENGGUNA("Hapus Pengguna"),
    TRANSAKSI_PENJUALAN("Transaksi Penjualan"),
    TRANSAKSI_PEMBELIAN("Transaksi Pembelian"),
    LIHAT_LAPORAN_PENJUALAN("Lihat Laporan Penjualan"),
    LIHAT_LAPORAN_PEMBELIAN("Lihat Laporan Pembelian"),
    LIHAT_LAPORAN_KEUNTUNGAN("Lihat Laporan Keuntungan"),
    LIHAT_LAPORAN_JURNAL("Lihat Laporan Jurnal"),
    LIHAT_LAPORAN_BARCODE("Lihat Laporan Barcode"),
    LIHAT_LAPORAN_GRAFIK("Lihat Laporan Grafik"),
    LIHAT_HUTANG("Lihat Hutang"),
    BAYAR_HUTANG("Bayar Hutang");
    
    private final String nama;

    private Role(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
