/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi_database.Koneksi;
import MODEL.Kasir_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DINI
 */
public class Kasir_DAO {
    Connection con;
    
    public Kasir_DAO(){
        Koneksi k =new Koneksi();
        con = k.getConnection();
    }
    public void insert(Connection con, Kasir_MODEL model) throws SQLException{
        String sql = "insert into kasir values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getId_kasir());
        ps.setString(2, model.getNama_kasir());
        ps.setString(3, model.getCompany_kasir());
        ps.setString(4, model.getUsername());
        ps.setString(5, model.getPassword());
        ps.setString(6, model.getNohp_kasir());
        ps.executeUpdate();
    }
    
    public static void update(Connection con, Kasir_MODEL model) throws SQLException{
        String sql = "update kasir set nama_kasir=?, company_kasir=?, username=?, password=?, nohp_kasir=?"
                + "where id_kasir=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getNama_kasir());
        ps.setString(2, model.getCompany_kasir());
        ps.setString(3, model.getUsername());
        ps.setString(4, model.getPassword());
        ps.setString(5, model.getNohp_kasir());
        ps.setString(6, model.getId_kasir());
        ps.executeUpdate();
    }
    
   public static void delete(Connection con, Kasir_MODEL model) throws SQLException{
        String sql = "delete from kasir where id_kasir=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getId_kasir());
        ps.executeUpdate();
    }
    
    public static Kasir_MODEL getKasirModel(Connection con, String id_kasir) throws SQLException{
        String sql = "Select * from kasir where id_kasir=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id_kasir);
        Kasir_MODEL model = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            model = new Kasir_MODEL();
            model.setId_kasir(rs.getString(1));
            model.setNama_kasir(rs.getString(2));
            model.setCompany_kasir(rs.getString(3));
            model.setUsername(rs.getString(4));
            model.setPassword(rs.getString(5));
            model.setNohp_kasir(rs.getString(6));
        }
        return model;
    }
    public String login(Kasir_MODEL log) throws SQLException{
        String sql = "Select * from kasir where username = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,log.getUsername());
            ps.setString(2, log.getPassword());
            ResultSet rs =  ps.executeQuery();
            
            if (rs.next()){
                return 
                rs.getString(4);
            }
            return null;
        } 
}
