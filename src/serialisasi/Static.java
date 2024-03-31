/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisasi;

import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author hanif
 */
public class Static implements Serializable {
    
    public static String nama;
    public static String email;
    public static String kota;
    
    public Static (String nama, String email, String kota) {
        Static.nama = nama;
        Static.email = email;
        Static.kota = kota;
    }
    
    @Override
    public String toString() {
        return "NAMA=" + nama + "\r\nEMAIL=" + email + "\r\nKOTA=" + kota;

    }
    
    public static void main(String[] args) {
        System.out.println("MULAI SERIALISASI...");
        Transient k = new Transient("muhammad hanif isnain", "hanif@gmail.com", "tegal");
        System.out.println("PROSES SERIALISASI...");
        String path = System.getProperty("user.dir")
                + File.separator + "static.ser";
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(new File(path));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(k);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("SERIALISASI SELESAI");
        System.out.println("Hasil serialisasi tersimpan di: " + path);

    }
}
