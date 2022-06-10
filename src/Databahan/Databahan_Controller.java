/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databahan;

import DAO.Admin_DAO;
import DAO.Bahan_DAO;
import static Databahan.Databahan_View.lbl_item;
import static Databahan.Databahan_View.lbl_low;
import static Databahan.Databahan_View.lbl_out;
import Koneksi_database.Koneksi;
import MODEL.Admin_MODEL;
import MODEL.Bahan_MODEL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
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
    Databahan_View view;
    Bahan_MODEL model;
    Bahan_DAO dao;
    Connection con;
    Koneksi k;
    Admin_MODEL admodel;
    
     public Databahan_Controller(Databahan_View view){
        this.view = view;
        dao = new Bahan_DAO();
        k = new Koneksi();
        try{
            con = k.getConnection();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
     
/**    public void onMouseClickTabeldata(){
        Bahan_DAO dao = new Bahan_DAO();
        
        String id = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 0).toString();
        String nama = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 1).toString();
        String jumlah = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 2).toString();
         String satuan = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 3).toString();
          String harga = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 4).toString();
           String tgl = view.getTbl_data().getValueAt(view.getTbl_data().getSelectedRow(), 5).toString();
           
        try{
            Bahan_MODEL model = dao.getBahan(con, id);
            view.getTxtKodeAnggota().setText(anggotamodel.getKode());
            view.getTxtNamaAnggota().setText(anggotamodel.getNama());
            view.getTxtAlamat().setText(anggotamodel.getAlamat());
            view.getCmbJekel().setSelectedItem(anggotamodel.getJekel());
         
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AnggotaControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
    
  
    public void Item() {
        try {
            String jumlah = dao.bahanAll();
         lbl_item.setText(jumlah);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
    
    public void ItemLow() {
        try {
            String jumlah = dao.bahanLow();
         lbl_low.setText(jumlah);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
    public void ItemOut() {
        try {
            String jumlah = dao.bahanOut();
         lbl_out.setText(jumlah);
        } catch (SQLException e) {
            e.printStackTrace();
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
