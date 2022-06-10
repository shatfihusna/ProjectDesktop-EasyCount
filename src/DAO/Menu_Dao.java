/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi_database.Koneksi;
import MODEL.Menu_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raven
 */
public class Menu_Dao {
    Connection con;
    
    public Menu_Dao(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void create (Menu_Model model) throws SQLException
    {
       String sql = "insert into menu values(?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, model.getKode_menu());
       ps.setString(2, model.getNama_menu());
       ps.setString(3, model.getJenis_menu());
       
       ps.setString(4, model.getHarga_menu());
       ps.executeUpdate();
    }
    
    public void update(Menu_Model model) throws SQLException{
        String sql = "update menu set nama_menu=?, jenis_menu=?, harga_menu " + "where kode_menu=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getKode_menu());
        ps.setString(2, model.getNama_menu());
        ps.setString(3, model.getJenis_menu());
        ps.setString(4, model.getHarga_menu());
        ps.executeUpdate();
    }
    
    public void delete(String kode) throws SQLException{
        String sql = "delete from menu where kode_menu()";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
        
    }
    
    public Menu_Model getMenu(String kode) throws SQLException{
        String sql = "select kode_menu, nama_menu, harga_menu from menu where kode_menu=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        Menu_Model model = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            model = new Menu_Model();
            model.setKode_menu(rs.getString(1));
            model.setNama_menu(rs.getString(2));
            model.setHarga_menu(rs.getString(3));
        }
        return model;
    }
    
    public static void main(String[] args) throws SQLException{
        Menu_Dao dao = new Menu_Dao();
        Menu_Model model = dao.getMenu("1");
        System.out.println(model.getHarga_menu());
    }
}
