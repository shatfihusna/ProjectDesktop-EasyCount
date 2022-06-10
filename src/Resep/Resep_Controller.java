/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resep;

import DAO.Bahan_DAO;
import DAO.Pemakaian_Dao;
import Koneksi_database.Koneksi;
import MODEL.Bahan_MODEL;
import MODEL.Pemakaian_Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Raven
 */
public class Resep_Controller {
    Resep_View view;
    Pemakaian_Model model;
    Pemakaian_Dao dao;
    Bahan_MODEL bamodel;
    Bahan_DAO badao;
    Connection con;
    Koneksi k;
    
    public Resep_Controller(Resep_View view){
        this.view = view;
        dao = new Pemakaian_Dao();
        badao = new Bahan_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void input_resep(){
        model = new Pemakaian_Model();
        model.setKode_menu(view.getTxt_kodemenu().getText());
        model.setId_bahan(view.getTxt_idbahan().getText());
        model.setNama_bahan(view.getTxt_namabahan().getText());
        model.setJumlah_pakai(view.getSpn_jumlah().getValue().toString());

        try{
            dao.create(model);
            javax.swing.JOptionPane.showMessageDialog(null, "Done");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
        
    }
    public void update() {
        model = new Pemakaian_Model();
        model.setKode_menu(view.getTxt_kodemenu().getText());
        model.setId_bahan(view.getTxt_idbahan().getText());
        model.setNama_bahan(view.getTxt_namabahan().getText());
        model.setJumlah_pakai(view.getSpn_jumlah().getValue().toString());
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin melakukan perubahan pada data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (confirm == 0) {
        try {
            dao.update(model);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
        }
    }
    
    public void isiTabelbahan(){
        try{
            DefaultTableModel model = (DefaultTableModel) view.getTbl_bahan().getModel();
            model.setRowCount(0);
            ResultSet rs = k.getQuery(con,"SELECT id_bahan, nama_bahan From bahan");
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2)
                };
                model.addRow(data);
                }
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Resep_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiTabelresep(){
        try{
            DefaultTableModel model = (DefaultTableModel) view.getTbl_resep().getModel();
            model.setRowCount(0);
            ResultSet rs = k.getQuery(con,"SELECT * From pemakaian");
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                };
                model.addRow(data);
                }
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Resep_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
    
     public void getIdbahan(){
        String idbahan = view.getTxt_idbahan().getText();
        try{
            bamodel = badao.getBahan(con, idbahan);
            if(bamodel != null){
                view.getTxt_idbahan().setText(bamodel.getId_bahan());
                view.getTxt_namabahan().setText(bamodel.getNama_bahan());
        } else {
                JOptionPane.showMessageDialog(null, "Bahan tak da");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }
     
   public void onMouseClickTabelresep(){
        dao = new Pemakaian_Dao();
        
        String id_bahan = view.getTbl_resep().getValueAt(view.getTbl_resep().getSelectedRow(), 0).toString();
        String kode_menu = view.getTbl_resep().getValueAt(view.getTbl_resep().getSelectedRow(), 1).toString();
        String nama = view.getTbl_resep().getValueAt(view.getTbl_resep().getSelectedRow(), 2).toString();
        String jumlah = view.getTbl_resep().getValueAt(view.getTbl_resep().getSelectedRow(), 3).toString();
           
        try{
            model = dao.getpakai(kode_menu);
            view.getTxt_idbahan().setText(model.getId_bahan());
            view.getTxt_kodemenu().setText(model.getKode_menu());
            view.getTxt_namabahan().setText(model.getJumlah_pakai());
            view.getSpn_jumlah().setValue(model.getJumlah_pakai());
         
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Resep_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
   
    public void clearForm(){
        view.getTxt_idbahan().setText("");
        view.getTxt_kodemenu().setText("");
        view.getTxt_namabahan().setText("");
        view.getSpn_jumlah().setValue("");
 
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
