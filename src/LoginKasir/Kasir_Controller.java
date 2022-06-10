/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginKasir;

import DAO.Kasir_DAO;
import Koneksi_database.Koneksi;
import MODEL.Kasir_MODEL;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Kasir_Controller {
    Form_Login view;
    Kasir_MODEL model;
    Kasir_DAO dao;
    Connection con;
    Koneksi k;
    
    public Kasir_Controller(Form_Login view){
        this.view = view;
        dao = new Kasir_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public String login() throws SQLException{
        model = new Kasir_MODEL();
        model.setUsername(view.getTxtUsername().getText());
        model.setPassword(view.getTxtPassword().getText());
      
        try{
            if(dao.login(model) != null){
                javax.swing.JOptionPane.showMessageDialog(null, "Login Berhasil");
                return dao.login(model);
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(null, "Invalid");
            }
        }catch(Exception ex){
        javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
        return null;
    }
    
    public void clear(){
    view.getTxtUsername().setText("");
    view.getTxtPassword().setText("");
    }

    boolean onClickBtnLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
