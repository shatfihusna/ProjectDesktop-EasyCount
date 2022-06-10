/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegStock;

import DAO.Admin_DAO;
import Koneksi_database.Koneksi;
import MODEL.Admin_MODEL;
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
    FromRegister_Admin view;
    Admin_MODEL model;
    Admin_DAO dao;
    Connection con;
    Koneksi k;
    
    public Controller_Req(FromRegister_Admin view){
        this.view = view;
        dao = new Admin_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void register(){
        model = new Admin_MODEL();
        model.setId_admin(view.getTxt_id().getText());
        model.setNama_admin(view.getTxtemail().getText());
        model.setCompany_admin(view.getTxtpassword().getText());
        model.setUsername(view.getTxtnama().getText());
        model.setPassword(view.getTxtcompany().getText());
        model.setNohp_admin(view.getTxt_nohp().getText());
        
        try{
            dao.insert(con, model);
            javax.swing.JOptionPane.showMessageDialog(null, "Register Berhasil");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
        
    }
    public void AutoIsiKodeTransaksi(FromRegister_Admin view) throws SQLException{
        try{
            String sql = "select max(id_admin) from admin";
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 int a = rs.getInt(1);
                 view.getTxt_id().setText("" + Integer.toString(a+1));
             } 
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error" +ex.getMessage());
        }
    }
}
