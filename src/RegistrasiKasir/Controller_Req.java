/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistrasiKasir;

import DAO.Kasir_DAO;
import Koneksi_database.Koneksi;
import MODEL.Kasir_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Raven
 */
public class Controller_Req {
    FromRegister view;
    Kasir_MODEL model;
    Kasir_DAO dao;
    Connection con;
    Koneksi k;
    
    public Controller_Req(FromRegister view){
        this.view = view;
        dao = new Kasir_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void register(){
        model = new Kasir_MODEL();
        model.setId_kasir(view.getTxt_Id().getText());
        model.setNama_kasir(view.getTxt_nama().getText());
        model.setCompany_kasir(view.getTxt_company().getText());
        model.setUsername(view.getTxt_Email().getText());
        model.setPassword(view.getTxt_password().getText());
        model.setNohp_kasir(view.getTxt_nohp().getText());
        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Register Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
        
    }
    public void AutoIsiKodeTransaksi(FromRegister view) throws SQLException{
        try{
            String sql = "select max(id_kasir) from kasir";
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 int a = rs.getInt(1);
                 view.getTxt_Id().setText("" + Integer.toString(a+1));
             } 
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error" +ex.getMessage());
        }
    }
    
    public void clear(){
    view.getTxt_Id().setText("");
    view.getTxt_nama().setText("");
    view.getTxt_company().setText("");
    view.getTxt_Email().setText("");
    view.getTxt_password().setText("");
    view.getTxt_nohp().setText("");
}
}
