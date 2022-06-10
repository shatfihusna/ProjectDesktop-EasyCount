/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi_database.Koneksi;
import MODEL.Pemesanan_Model;
import MODEL.Transaksi_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raven
 */
public class Transaksi_DAO {
    Connection con;
    
    public Transaksi_DAO(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public String Totalbayar(Pemesanan_Model pesan) throws SQLException{
        String sql = "Select sum(harga_menu*jumlah_pesan) from pemesanan where id_pemesanan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pesan.getId_pemesanan());
        ResultSet rs = ps.executeQuery();
       
        if (rs.next()){
            return rs.getString(1);
        }
        return null;
    }
    
      public void create (Transaksi_Model model) throws SQLException
    {
       String sql = "insert into transaksi values(?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, model.getId_transaksi());
       ps.setString(2, model.getId_pemesanan());
       ps.setInt(3, model.getTotalbelanja());
       ps.setString(4, model.getUangbayar());
       ps.setString(5, model.getUangkembali());
       ps.executeUpdate();
    }
    
    public void update(Pemesanan_Model model) throws SQLException{
        String sql = "update pemesanan set tanggal_pesan=?, kode_menu=?, nama_menu=?, harga_menu=?, jumlah_pesan" + "where where id_pemesanan=?";
        PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, model.getId_pemesanan());
       ps.setString(2, model.getTanggal_pesan());
       ps.setString(3, model.getKode_menu());
       ps.setString(4, model.getNama_menu());
       ps.setInt(5, model.getHarga_menu());
       ps.setInt(6, model.getJumlah_pesan());
       ps.executeUpdate();
    }
    
    
    public Pemesanan_Model getpakai(String id) throws SQLException{
        String sql = "select * from pemakaian where id_pemesanan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        Pemesanan_Model model = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            model = new Pemesanan_Model();
            model.setId_pemesanan(rs.getString(1));
            model.setKode_menu(rs.getString(2));
            model.setNama_menu(rs.getString(3));
            model.setHarga_menu(Integer.parseInt(rs.getString(4)));
            model.setJumlah_pesan(Integer.parseInt(rs.getString(5)));
        }
        return model;
    }
}
