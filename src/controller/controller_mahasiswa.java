/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.from_mahasiswa;
/**
 *
 * @author LAB 1 PC 21
 */
public interface controller_mahasiswa {
    public void Simpan(from_mahasiswa mhs) throws SQLException;        
    public void Ubah(from_mahasiswa mhs) throws SQLException;
    public void Hapus(from_mahasiswa mhs) throws SQLException;
    public void Tampil(from_mahasiswa mhs) throws SQLException;
    public void Baru(from_mahasiswa mhs);                               
    public void KlikTabel(from_mahasiswa mhs) throws SQLException;
}

