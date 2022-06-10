/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HitungBelanja;


import DAO.Menu_Dao;
import DAO.Pemakaian_Dao;
import DAO.Pemesanan_DAO;
import DAO.Transaksi_DAO;
import static HitungBelanja.Hitungbelanja_View.lbl_tot;
import Koneksi_database.Koneksi;
import MODEL.Admin_MODEL;
import MODEL.Menu_Model;
import MODEL.Pemesanan_Model;
import MODEL.Transaksi_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DINI
 */
public class Hitungbelanja_Controller {
    Hitungbelanja_View view;
    Connection con;
    Koneksi k;
    Admin_MODEL admodel;
    Menu_Model menumodel;
    Menu_Dao menudao;
    Pemesanan_Model pemmodel;
    Pemesanan_DAO pemdao;
    Transaksi_Model trmodel;
    Transaksi_DAO trdao;
    
    List<Pemesanan_Model> list;
    
      public Hitungbelanja_Controller(Hitungbelanja_View view){
        this.view = view;
       
        k = new Koneksi();
        try{
            con = k.getConnection();
            menudao = new Menu_Dao();
            pemdao = new Pemesanan_DAO();
            trdao = new Transaksi_DAO();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    

    public void inputTransaksi(){
        trmodel = new Transaksi_Model();
        trmodel.setId_transaksi(view.getTxt_kodetransaksi().getText());
        trmodel.setId_pemesanan(view.gettxtId_pemesanan().getText());
        trmodel.setTotalbelanja(Integer.parseInt(view.getTxt_total().getText()));
        trmodel.setUangbayar(view.getTxt_bayar().getText());
        trmodel.setUangkembali(view.getTxt_kembali().getText());
        try{
            trdao.create(trmodel);
            javax.swing.JOptionPane.showMessageDialog(null, "Transaksi succses");
        } catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "error" + ex.getMessage());
        }
    }  
      
    public void inputPesanan() throws SQLException{
        pemmodel = new Pemesanan_Model();
        pemmodel.setId_pemesanan(view.gettxtId_pemesanan().getText());
        pemmodel.setTanggal_pesan(view.gettxtTgl().getText());
        pemmodel.setKode_transaksi(Integer.parseInt(view.getTxt_kodetransaksi().getText()));
        pemmodel.setKode_menu(view.gettxtKodemenu().getText());
        pemmodel.setNama_menu(view.gettxtNamamenu().getText());
        pemmodel.setHarga_menu(Integer.parseInt(view.getTxt_harga().getText()));
        pemmodel.setJumlah_pesan(Integer.parseInt(view.getSpn_jum().getValue().toString()));
     
        try{
            pemdao.create(pemmodel);
            javax.swing.JOptionPane.showMessageDialog(null, "Pesanan OK");
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            ex.printStackTrace();
        } finally{
            Total(view);
        }
    }  
      
  /*    private void sum(){
        DefaultTableModel dataModel = (DefaultTableModel) view.getTbl_pesan().getModel();
        int jumlah = dataModel.getRowCount();
        double total =0;
        
        for (int i = 0; i < jumlah; i++) {
            double jumlah = Double.valueOf(dataModel.getValueAt(i, 1).toString());
            double harga = Double.valueOf(dataModel.getValueAt(i, 2).toString());
            sumBerat += dataBerat;
            sumTinggi += dataTinggi;
        }
        jumlah_data.setText(Integer.toString(jumlah));
        sum_berat.setText(Double.toString(sumBerat));
        sum_tinggi.setText(Double.toString(sumTinggi));    
    }
    */
    public void getKodemenu(){
        String kodemenu = view.gettxtKodemenu().getText();
        try{
            menumodel = menudao.getMenu(kodemenu);
            if(menumodel != null){
                view.gettxtKodemenu().setText(menumodel.getKode_menu());
                view.gettxtNamamenu().setText(menumodel.getNama_menu());
                view.getTxt_harga().setText(menumodel.getHarga_menu());
        } else {
                JOptionPane.showMessageDialog(null, "Menu tak da");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }  
    
    public void Tanggal(Hitungbelanja_View view){
        java.util.Date now = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
        view.gettxtTgl().setText(kal.format(now));
    }
    
     public void Total(Hitungbelanja_View hit) throws SQLException {
        int JumlahBaris = hit.getTbl_pesan().getRowCount();
        int Total = 0;
        int Harga_Barang;
        int jumlah;
        TableModel tableModel;
        tableModel = hit.getTbl_pesan().getModel();
        for (int i = 0; i < JumlahBaris; i++) {
            Harga_Barang = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            jumlah = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            Total = (Total + (Harga_Barang * jumlah));
            hit.getTxt_total().setText(String.valueOf(Total));
        }
    }
    public void getTotalbelanja(){
        String id = (view.gettxtId_pemesanan().getText());
        try{
            pemmodel = pemdao.getTotal(id);
            if(pemmodel != null){
                view.gettxtId_pemesanan().setText(pemmodel.getId_pemesanan());
               
        } else {
                JOptionPane.showMessageDialog(null, "Menu tak da");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }
      
    public void AutoIsiKodeTransaksi(Hitungbelanja_View view) throws SQLException{
        try{
            String sql = "select max(kode_transaksi) from pemesanan";
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 int a = rs.getInt(1);
                 view.getTxt_kodetransaksi().setText("" + Integer.toString(a+1));
             } 
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error" +ex.getMessage());
        }
    }
    public void TetapIsiKodeTransaksi(Hitungbelanja_View view) throws SQLException{
        try{
            String sql = "select max(kode_transaksi) from pemesanan";
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 int a = rs.getInt(1);
                 view.getTxt_kodetransaksi().setText("" + Integer.toString(a));
             } 
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error" +ex.getMessage());
        }
    }
    
    public void AutoIsiIdPemesanan(Hitungbelanja_View view) throws SQLException{
        try{
            String sql = "select max(id_pemesanan) from pemesanan";
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 int a = rs.getInt(1);
                 view.gettxtId_pemesanan().setText("" + Integer.toString(a+1));
             } 
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error" +ex.getMessage());
        }
    }
    
    public void Kembalian(Hitungbelanja_View view){
        double total = Double.valueOf(view.getTxt_total().getText());
        double bayar = Double.valueOf(view.getTxt_bayar().getText());
        double kembalian = (bayar - total);
        view.getTxt_kembali().setText(String.valueOf(kembalian));
    }
    
    public void isiTabelpesan() throws SQLException{
        try{
            DefaultTableModel model = (DefaultTableModel) view.getTbl_pesan().getModel();
            model.setRowCount(0);
            pemmodel = new Pemesanan_Model();
            ResultSet rs = k.getQuery(con,"SELECT kode_menu, nama_menu, harga_menu,jumlah_pesan From pemesanan " + "where kode_transaksi= "+view.getTxt_kodetransaksi().getText());
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
            java.util.logging.Logger.getLogger(Hitungbelanja_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Total(view);
        }
    }  
    public void isiTabelDaftarMenu(){
        try{
            DefaultTableModel model = (DefaultTableModel) view.gettblDaftarMenu().getModel();
            model.setRowCount(0);
            ResultSet rs = k.getQuery(con,"SELECT kode_menu, nama_menu From menu");
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2)
                };
                model.addRow(data);
                }
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Hitungbelanja_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
