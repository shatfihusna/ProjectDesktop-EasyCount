/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Databahan.Databahan_View;
import static Databahan.Databahan_View.Lbl_Nama;
import Koneksi_database.Koneksi;
import MODEL.Admin_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Admin_DAO {
    Connection con;
    Databahan_View view;
    
    public Admin_DAO(){
        Koneksi k =new Koneksi();
        con = k.getConnection();
    }
    public String login(Admin_MODEL log) throws SQLException{
        String sql = "Select * from admin where username = ? and password = ?";
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
    
   public void insert(Connection con, Admin_MODEL admin) throws SQLException{
        String sql = "insert into admin values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, admin.getId_admin());
        ps.setString(2, admin.getUsername());
        ps.setString(3, admin.getPassword());
        ps.setString(4, admin.getNama_admin());
        ps.setString(5, admin.getCompany_admin());
        ps.setString(6, admin.getNohp_admin());
        ps.executeUpdate();
    }
    
    public static void update(Connection con, Admin_MODEL admin) throws SQLException{
        String sql = "update admin set username=?, password=? "
                + "where nama_admin=? and company_admin=? and nohp_admin=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, admin.getId_admin());
        ps.setString(2, admin.getUsername());
        ps.setString(3, admin.getPassword());
        ps.setString(4, admin.getNama_admin());
        ps.setString(5, admin.getCompany_admin());
        ps.setString(6, admin.getNohp_admin());
        ps.executeUpdate();
    }
    
    public static void delete(Connection con, Admin_MODEL admin) throws SQLException{
        String sql = "delete from admin where id_admin=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, admin.getId_admin());
        ps.executeUpdate();
    }
    
    public static Admin_MODEL getAdmin(Connection con, String id_admin) throws SQLException{
        String sql = "Select * from admin where id_admin=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id_admin);
        Admin_MODEL admin = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            admin = new Admin_MODEL();
            admin.setId_admin(rs.getString(1));
            admin.setUsername(rs.getString(2));
            admin.setPassword(rs.getString(3));
            admin.setNama_admin(rs.getString(4));
            admin.setCompany_admin(rs.getString(5));
            admin.setNohp_admin(rs.getString(6));
        }
        return admin;
    }
}