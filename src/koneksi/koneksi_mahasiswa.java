/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author LAB 1 PC 21
 */
public class koneksi_mahasiswa {
    private static Connection koneksi;
    public static Connection getKoneksi()
    {
        if(koneksi== null)
        {
            try {
                String url="jdbc:mysql://localhost/masukkan_nama_database_anda";
                String username= "root";     // default username
                String password= "";         // jika ada password bisa anda masukkan
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi =DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return koneksi;
    }
    
}
