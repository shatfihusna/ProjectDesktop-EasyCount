/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi_database.Koneksi;
import MODEL.Bahan_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Bahan_DAO {

    Connection con;
    
    public Bahan_DAO(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public String bahanAll() throws SQLException{
        String sql = "Select count(*) from bahan";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
          return rs.getString(1); 
        }
      return null;
    }
    
    public String bahanLow() throws SQLException{
        String sql = "Select count(*) from bahan where jumlah_bahan <= 5";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
          return rs.getString(1); 
        }
      return null;
    }
    
    public String bahanOut() throws SQLException{
        String sql = "Select count(*) from bahan where jumlah_bahan = 0";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
          return rs.getString(1); 
        }
      return null;
    }
    public static void insert(Connection con, Bahan_MODEL bahan) throws SQLException{
        String sql = "insert into bahan values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, bahan.getId_bahan());
        ps.setString(2, bahan.getNama_bahan());
        ps.setString(3, bahan.getJumlah_bahan());
        ps.setString(4, bahan.getSatuan_bahan());
        ps.setString(5, bahan.getHarga_bahan());
        ps.setString(6, bahan.getTanggal_masuk());
        ps.executeUpdate();
    }
    
    public static void update(Connection con, Bahan_MODEL bahan) throws SQLException{
        String sql = "update bahan set nama_bahan=?, jumlah_bahan=?, satuan_bahan=?,  harga_bahan=?, tanggal_masuk=? "
                + "where id_bahan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, bahan.getNama_bahan());
        ps.setString(2, bahan.getJumlah_bahan());
        ps.setString(3, bahan.getSatuan_bahan());
        ps.setString(4, bahan.getHarga_bahan());
        ps.setString(5, bahan.getTanggal_masuk());
        ps.setString(6, bahan.getId_bahan());
        ps.executeUpdate();
    }
    
     public static void delete(Connection con, Bahan_MODEL bahan) throws SQLException{
        String sql = "delete from bahan where id_bahan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, bahan.getId_bahan());
        ps.executeUpdate();
    }
    
    public Bahan_MODEL getBahan(Connection con, String id_bahan) throws SQLException{
        String sql = "Select * from bahan where id_bahan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id_bahan);
        Bahan_MODEL bahan = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            bahan = new Bahan_MODEL();
            bahan.setId_bahan(rs.getString(1));
            bahan.setNama_bahan(rs.getString(2));
            bahan.setJumlah_bahan(rs.getString(3));
            bahan.setSatuan_bahan(rs.getString(4));
            bahan.setHarga_bahan(rs.getString(5));
            bahan.setTanggal_masuk(rs.getString(6));
        }
        return bahan;
    }
    
}
