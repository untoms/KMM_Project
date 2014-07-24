/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.manager;

import com.bustomi.bookstorepos.entity.Saldo;
import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.entity.User.HakAkses;
import com.bustomi.bookstorepos.entity.User.Role;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.entity.master.KategoriBarang;
import com.bustomi.bookstorepos.entity.master.KategoriBuku;
import com.bustomi.bookstorepos.entity.master.Pelanggan;
import com.bustomi.bookstorepos.entity.master.Pemasok;
import com.bustomi.bookstorepos.service.GrupService;
import com.bustomi.bookstorepos.service.HakAksesService;
import com.bustomi.bookstorepos.service.KategoriBarangService;
import com.bustomi.bookstorepos.service.KategoriBukuService;
import com.bustomi.bookstorepos.service.PelangganService;
import com.bustomi.bookstorepos.service.PemasokService;
import com.bustomi.bookstorepos.service.SaldoService;
import com.bustomi.bookstorepos.service.UserService;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PacuL
 */
public class SpringManager {
    
    private final ApplicationContext applicationContext;

    public SpringManager() {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(
                "spring.xml");
        context.registerShutdownHook();
        
        this.applicationContext=context;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    public <T> T getBean(Class<T> requireType) throws BeansException{
        return applicationContext.getBean(requireType);
    }
    
    public <T> T getBean(String name,Class<T> requireType) throws BeansException{
        return applicationContext.getBean(name,requireType);
    }
    
    private static SpringManager INSTANCE;

    public static SpringManager getInstance() throws NoSuchAlgorithmException, InvalidKeySpecException {
        
        if (SpringManager.INSTANCE == null ) {
            SpringManager.INSTANCE = new SpringManager();
            
            HakAksesService hakAksesService = SpringManager.getInstance().getBean(HakAksesService.class);
            for (Role constant : Role.values()) {
                HakAkses hakAkses = hakAksesService.find(constant.toString());
                if (hakAkses == null) {
                    hakAkses = new HakAkses();
                    hakAkses.setId(constant.toString());
                    hakAkses.setNama(constant.toString());
                    hakAkses.setWaktuDibuat(new Date());
                    hakAkses.setTerakhirDirubah(null);
                    hakAksesService.save(hakAkses);
                }
            }

            GrupService grupService = SpringManager.getInstance().getBean(GrupService.class);
            Grup grup = grupService.find("admin");
            if (grup == null) {
                grup = new Grup();
                grup.setNama("admin");
                List<HakAkses> akseses = hakAksesService.findAll();
                for (HakAkses akses : akseses) {
                    grup.tambahHakAkses(akses);
                }
                grupService.save(grup);
            }
           
            UserService penggunaService = SpringManager.getInstance().getBean(UserService.class);
            User pengguna = penggunaService.find("admin");
            if (pengguna == null) {
                pengguna = new User();
                pengguna.setGrup(grup);
                pengguna.setId("admin");
                pengguna.setNama("Administrator");
                pengguna.setPassword(SimplePasswordHash.getInstance("admin").getGeneratedSecuredPasswordHash());
                pengguna.setTerakhirDirubah(null);
                pengguna.setWaktuDibuat(new Date());
                pengguna.setAlamat("Solo");
                pengguna.setKodepos("57468");
                pengguna.setKota("Solo");
                pengguna.setTelepon("0123456789");
                penggunaService.save(pengguna);
            }
            
            PelangganService pelangganService = SpringManager.getInstance().getBean(PelangganService.class);
            Pelanggan pelanggan = pelangganService.find("umum");
            if (pelanggan == null) {
                pelanggan = new Pelanggan();
                pelanggan.setId("umum");
                pelanggan.setNama("Tidak terdaftar");
                pelanggan.setTerakhirDirubah(null);
                pelanggan.setWaktuDibuat(new Date());
                pelanggan.setAlamat("Tidak diketahui");
                pelanggan.setKodepos("000000");
                pelanggan.setKota("Tidak diketahui");
                pelanggan.setTelepon("Tidak diketahui");
                pelangganService.save(pelanggan);
            }
            
            KategoriBukuService kategoriBukuService=SpringManager.getInstance().getBean(KategoriBukuService.class);
            KategoriBuku kategoriBuku=kategoriBukuService.find("Tidak dikategorikan");
            if (kategoriBuku == null) {
                kategoriBuku = new KategoriBuku();
                kategoriBuku.setNama("Tidak dikategorikan");
                kategoriBuku.setInfo("Kategori buku belum didefinisikan");
                kategoriBukuService.save(kategoriBuku);
            }
            
            KategoriBarangService kategoriBarangService=SpringManager.getInstance().getBean(KategoriBarangService.class);
            KategoriBarang kategoriBarang=kategoriBarangService.find("Tidak dikategorikan");
            if (kategoriBarang == null) {
                kategoriBarang = new KategoriBarang();
                kategoriBarang.setNama("Tidak dikategorikan");
                kategoriBarang.setInfo("Kategori barang belum didefinisikan");
                kategoriBarangService.save(kategoriBarang);
            }
            
            PemasokService pemasokService=SpringManager.getInstance().getBean(PemasokService.class);
            Pemasok pemasok=pemasokService.find("umum");
            if (pemasok == null) {
                pemasok = new Pemasok();
                pemasok.setAlamat("Tidak diketahui");
                pemasok.setEmail("Tidak diketahui");
                pemasok.setId("umum");
                pemasok.setInfo("Tidak diketahui");
                pemasok.setKota("Tidak diketahui");
                pemasok.setNama("Tidak diketahui");
                pemasok.setTelepon("Tidak diketahui");
                pemasok.setWaktuDibuat(new Date());
                
                pemasokService.save(pemasok);
            }

            SaldoService pengaturanService = SpringManager.getInstance().getBean(SaldoService.class);
            Saldo pengaturan = pengaturanService.find("saldo-terakhir");
            if (pengaturan == null) {
                pengaturan = new Saldo();
                pengaturan.setKode("saldo-terakhir");
                pengaturan.setNilai(BigDecimal.ZERO);
                pengaturanService.save(pengaturan);
            }
            
        }
        
        return SpringManager.INSTANCE;
    }
           
}
