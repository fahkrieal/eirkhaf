/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller_mahasiswa;
import koneksi.koneksi_mahasiswa;
import view.from_mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.from_mahasiswa;

public class Model_Mahasiswa implements controller.controller_mahasiswa {

    @Override
    public void Simpan(from_mahasiswa mhs) throws SQLException {
        if(mhs.rblaki.isSelected()){
            String jk = "Laki-laki";
        }
        else{
            String jk = "Perempuan";
        }
        
        try {
           
            
            Connection con = koneksi_mahasiswa.getKoneksi();
            String sql = "insert tblmahasiswa values(?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, mhs.txtnim.getText());
            prepare.setString(2, mhs.txtnama.getText());
            prepare.setString(3, sql);
            prepare.setString(4, (String) mhs.cbjurusan.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
        }
    }

    @Override
    public void Ubah(from_mahasiswa mhs) throws SQLException {
         if(mhs.rblaki.isSelected()){
             String jk = "Laki-laki";
        }
        else{
             String jk = "Perempuan";
        }
        
        try {
            Connection con = koneksi_mahasiswa.getKoneksi();
            String sql = "update tblmahasiswa set Nama= ?, Jenis_Kelamin= ?, Jurusan= ? where NIM= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, mhs.txtnim.getText());
            prepare.setString(1, mhs.txtnama.getText());
            prepare.setString(2, sql);
            prepare.setString(3, (String) mhs.cbjurusan.getSelectedItem());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            Baru(mhs);
        }
    }

    @Override
    public void Hapus(from_mahasiswa mhs) throws SQLException {
     try {
           
            
            Connection con = koneksi_mahasiswa.getKoneksi();
            String sql = "delete from tblmahasiswa where NIM= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, mhs.txtnim.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(mhs);
            Baru(mhs);
        }
    }

    @Override
    public void Tampil(from_mahasiswa mhs) throws SQLException {
      try {
          Connection con = koneksi_mahasiswa.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from nama_tabel_kamu order by NIM asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(from_mahasiswa mhs) {
       mhs.txtnim.setText("");
        mhs.txtnama.setText("");
        mhs.rblaki.setSelected(true);
        mhs.cbjurusan.setSelectedIndex(0);
    }

    @Override
    public void KlikTabel(from_mahasiswa mhs) throws SQLException {
        try {
             int pilih = mhs.table.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             mhs.txtnim.setText(mhs.table.getValueAt(pilih, 0).toString());
             mhs.txtnama.setText(mhs.table.getValueAt(pilih, 1).toString());
             mhs.cbjurusan.setSelectedItem(mhs.table.getValueAt(pilih, 3).toString());
            String jk = String.valueOf(mhs.table.getValueAt(pilih, 2));
             
                   
        } catch (Exception e) {
        }
        if(mhs.rblaki.getText().equals(mhs)){
                  mhs.rblaki.setSelected(true);
             } 
        else{mhs.rbperempuan.setSelected(true);}
    }

}
