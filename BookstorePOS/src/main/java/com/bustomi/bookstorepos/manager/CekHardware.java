/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public final class CekHardware {
  
    private Properties prop;
    private static CekHardware INSTANCE;
    
    public static CekHardware getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CekHardware();
        }
        return CekHardware.INSTANCE;
    }

    private String id;

    private CekHardware() {
        // singleton class
        prop = new Properties(); 
        
        try {
            prop.loadFromXML(new FileInputStream("konfigurasi.xml"));
            String str=prop.getProperty("id_keras");
            
            if (str == null) {
                File file = new File("/konfigurasi.xml");
                prop.setProperty("id_keras", "");  
                FileOutputStream fos;
                try {
                    fos = new FileOutputStream("/konfigurasi.xml");
                    try {
                        prop.storeToXML(fos, "Settingan", "UTF-8");
                    } catch (IOException ex) {
                        Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "File ERROR!");
                }
            }
                        
        } catch (IOException ex) {  
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "File ERROR!");
        }
        
        
    }
    
    public String getMotherBoardSerialNumber() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);
            String vbs =
                    "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n"
                    + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            Logger.getLogger(CekHardware.class.getName()).log(Level.SEVERE, null, e);
        }
        return result.trim();
    }

    public String getHardDiskSerialNumber(String drive) {
        String result = "";
        try {            
                File file = File.createTempFile("realhowto", ".vbs");
                file.deleteOnExit();
                FileWriter fw = new java.io.FileWriter(file);

                String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                        + "Set colDrives = objFSO.Drives\n"
                        + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                        + "Wscript.Echo objDrive.SerialNumber";  // see note
                fw.write(vbs);
                fw.close();
                Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = input.readLine()) != null) {
                    result += line;
                }
                input.close();
        } catch (IOException ex) {
            Logger.getLogger(CekHardware.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.trim();
    }
    
    
    
    public void SimpanKonfigurasi (String id) {
        prop = new Properties();
        prop.setProperty("id_keras", id);     
        
        File file = new File("/konfigurasi.xml");
 
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("konfigurasi.xml");
            try {
                prop.storeToXML(fos, "Settingan", "UTF-8");
            } catch (IOException ex) {
                Logger.getLogger(CekHardware.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "File ERROR!");
        
        }
    }
    public String BukaKonfigurasi(){
        prop = new Properties();
        String str;
        try {
            prop.loadFromXML(new FileInputStream("konfigurasi.xml"));
            str=prop.getProperty("id_keras");
            
            return str;
        } catch (IOException ex) {  
            Logger.getLogger(CekHardware.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "File ERROR!");
            return null;
        }
    }
    
}
