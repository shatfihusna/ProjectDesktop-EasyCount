/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBarangAdmin;

import inputstock.*;
import Databahan.*;
import DataBarangAdmin.*;
import DAO.Admin_DAO;
import DAO.Bahan_DAO;
import static Databahan.Databahan_View.lbl_item;
import Koneksi_database.Koneksi;
import MODEL.Admin_MODEL;
import MODEL.Bahan_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Raven
 */
public class Databahan_Controller {
    DatabahanAdmin_View view;
    Bahan_MODEL model;
    Bahan_DAO dao;
    Connection con;
    Koneksi k;
    Admin_MODEL admodel;
    
     public Databahan_Controller(DatabahanAdmin_View view){
        this.view = view;
        dao = new Bahan_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
     
     public void onMouseClickTabeldata(){
        Bahan_DAO dao = new Bahan_DAO();
        
        String id_bahan = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 0).toString();
        String nama = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 1).toString();
        String jumlah = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 2).toString();
        String satuan = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 3).toString();
        String harga = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 4).toString();
        String tgl = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 5).toString();
           
        try{
            Bahan_MODEL model = dao.getBahan(con, id_bahan);
            view.getTxtId_bahan().setText(model.getId_bahan());
            view.getTxtNama_bahan().setText(model.getNama_bahan());
            view.getTxtJumlah().setText(model.getJumlah_bahan());
            view.getTxtSatuan().setText(model.getSatuan_bahan());
            view.getTxtHarga().setText(model.getHarga_bahan());
            view.getTxtTgl().setText(model.getTanggal_masuk());
         
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Databahan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
 
    
    public void isiTabel(){
        try{
            DefaultTableModel model = (DefaultTableModel) view.getTbl_data().getModel();
            model.setRowCount(0);
            ResultSet rs = k.getQuery(con,"SELECT * From bahan");
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                };
                model.addRow(data);
                }
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Databahan_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(){
        model = new Bahan_MODEL();
        model.setId_bahan(view.getTxtId_bahan().getText());
        model.setNama_bahan(view.getTxtNama_bahan().getText());
        model.setJumlah_bahan(view.getTxtJumlah().getText());
        model.setSatuan_bahan(view.getTxtSatuan().getText());
        model.setHarga_bahan(view.getTxtHarga().getText());
        model.setTanggal_masuk(view.getTxtTgl().getText());
       
        try {
            Bahan_DAO.insert(con, model);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
     public void update() {
        model = new Bahan_MODEL();
        model.setId_bahan(view.getTxtId_bahan().getText());
        model.setNama_bahan(view.getTxtNama_bahan().getText());
        model.setJumlah_bahan(view.getTxtJumlah().getText());
        model.setSatuan_bahan(view.getTxtSatuan().getText());
        model.setHarga_bahan(view.getTxtHarga().getText());
        model.setTanggal_masuk(view.getTxtTgl().getText());
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin melakukan perubahan pada data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (confirm == 0) {
        try {
            Bahan_DAO.update(con, model);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
        }
    }
    public void delete(){
        model = new Bahan_MODEL();
        model.setId_bahan(view.getTxtId_bahan().getText());
        model.setNama_bahan(view.getTxtNama_bahan().getText());
        model.setJumlah_bahan(view.getTxtJumlah().getText());
        model.setSatuan_bahan(view.getTxtSatuan().getText());
        model.setHarga_bahan(view.getTxtHarga().getText());
        model.setTanggal_masuk(view.getTxtTgl().getText());
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (confirm == 0) {
        try {
            Bahan_DAO.delete(con, model);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
        }
    }
     
    public void clearForm(){
        view.getTxtId_bahan().setText("");
        view.getTxtNama_bahan().setText("");
        view.getTxtJumlah().setText("");
        view.getTxtSatuan().setText("");
        view.getTxtHarga().setText("");
        view.getTxtTgl().setText("");
    }
    
     public void Tanggal(DatabahanAdmin_View view){
        java.util.Date now = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
        view.getTxtTgl().setText(kal.format(now));
    }
    
     public void previewBahan() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/bahan.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
