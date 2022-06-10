/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input_Menu;

import DAO.Menu_Dao;
import Koneksi_database.Koneksi;
import MODEL.Menu_Model;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class Menu_Controller {
    Form_Inputmenu view;
    Menu_Model model;
    Menu_Dao dao;
    Connection con;
    Koneksi k;
    
    public Menu_Controller(Form_Inputmenu view){
        this.view = view;
        dao = new Menu_Dao();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void input_menu(){
        model = new Menu_Model();
        model.setKode_menu(view.getTxt_kode().getText());
        model.setNama_menu(view.getTxt_nama().getText());
        model.setHarga_menu(view.getTxt_harga().getText());
        if (view.getCbxmakanan().isSelected())
        { model.setJenis_menu(view.getCbxmakanan().getText());
        
        }
        else if (view.getCbxminuman().isSelected())
        { model.setJenis_menu(view.getCbxminuman().getText());
        
        }
       
        try{
            dao.create(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Menu Berhasil Ditambahkan");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
        
    }
    
    public void clear(){
    view.getTxt_kode().setText("");
    view.getTxt_nama().setText("");
    view.getTxt_harga().setText("");
}
    public void previewTransaksi() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/transaksi.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}