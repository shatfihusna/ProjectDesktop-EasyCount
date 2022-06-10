/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Customer_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DINI
 */
public class Customer_DAO {
    public static void insert(Connection con, Customer_MODEL model) throws SQLException{
        String sql = "insert into customer values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getKode_customer());
        ps.setString(2, model.getKode_menu());
        ps.setString(3, model.getId_pemesanan());
        ps.setString(4, model.getId_kasir());
        ps.setString(5, model.getBanyak_pesan());
        ps.setString(6, model.getJumlah());
        ps.setString(7, model.getUang_bayar());
        ps.executeUpdate();
    }
    
    public static void update(Connection con, Customer_MODEL model) throws SQLException{
        String sql = "update customer set banyak_pesan=?, jumlah=?, uang_bayar=? "
                + "where kode_customer=? and kode_menu=? and id_pemesanan=? and id_kasir=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getBanyak_pesan());
        ps.setString(2, model.getJumlah());
        ps.setString(3, model.getUang_bayar());
        ps.setString(4, model.getKode_customer());
        ps.setString(5, model.getKode_menu());
        ps.setString(6, model.getId_pemesanan());
        ps.setString(7, model.getId_kasir());
        ps.executeUpdate();
    }
    
   public static void delete(Connection con, Customer_MODEL model) throws SQLException{
        String sql = "delete from customer where kode_customer=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getKode_customer());
        ps.executeUpdate();
    }
    
    public static Customer_MODEL getCustomerModel(Connection con, String kode_customer) throws SQLException{
        String sql = "Select * from customer where kode_customer=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_customer);
        Customer_MODEL model = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            model = new Customer_MODEL();
            model.setKode_customer(rs.getString(1));
            model.setKode_menu(rs.getString(2));
            model.setId_pemesanan(rs.getString(3));
            model.setId_kasir(rs.getString(4));
            model.setBanyak_pesan(rs.getString(5));
            model.setJumlah(rs.getString(6));
            model.setUang_bayar(rs.getString(1));
        }
        return model;
    }

}
