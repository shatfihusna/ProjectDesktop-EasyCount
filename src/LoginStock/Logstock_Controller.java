/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginStock;

import DAO.Admin_DAO;
import Koneksi_database.Koneksi;
import MODEL.Admin_MODEL;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raven
 */
public class Logstock_Controller {
    FromLoginStock view ;
    Admin_MODEL model;
    Admin_DAO dao;
    Connection con;
    Koneksi k;
    
    public Logstock_Controller(FromLoginStock view){
        this.view = view;
        dao = new Admin_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public String login() throws SQLException{
        model = new Admin_MODEL();
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
