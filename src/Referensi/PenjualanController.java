/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referensi;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class PenjualanController {
    FormJual view;
    Penjualan penjualan;
    BarangDao barangDao = new BarangDao();
    PelangganDao pelangganDao = new PelangganDao();
    PenjualanDao penjualanDao = new PenjualanDao();
    RinciJualDao rinciJualDao = new RinciJualDao();
    
    public  PenjualanController(FormJual view){
        this.view = view;
        isiCboPelanggan();
        clearFormFaktur();
        clearFormBarang();
        clearFormHasil();
    }
    
    public void clearFormFaktur(){
        view.gettxtNoFaktur().setText("");
        view.gettxtTanggal().setText("");
    }
    
    public void clearFormBarang(){
        view.gettxtKodeBarang().setText("");
        view.gettxtNamabarang().setText("");
        view.gettxtHarga().setText("");
        view.gettxtJumlah().setText("");
        view.gettxtDiskon().setText("");
    }
    
    public void clearFormHasil(){
        view.gettxtTotal().setText("");
        view.gettxtTotalDiskon().setText("");
        view.gettxtTotalBayar().setText("");
    }
    
    public void isiCboPelanggan(){
        view.getCboPelanggan().removeAllItems();
        List<Pelanggan> dataPelanggan = pelangganDao.getAllData();
        for(Pelanggan pelanggan:dataPelanggan){
            view.getCboPelanggan().addItem(pelanggan.getKode()+"-"+pelanggan.getNama());
        }
    }
    
    public void onKeyPressKodeBarang(){
        Barang barang = barangDao.getBarang(view.gettxtKodeBarang().getText());
        if(barang!=null){
            view.gettxtNamabarang().setText(""+barang.getNama());
            view.gettxtHarga().setText(""+barang.getHarga()); 
        }else{
            JOptionPane.showMessageDialog(view, "Data Barang Tidak Ada");
        }
    }
    
    public void onClickBtnInsert() {
        Barang barang = barangDao.getBarang(view.gettxtKodeBarang().getText());
        RinciJual rinciJual = new RinciJual();
        rinciJual.setId(view.getTblRinciJual().getRowCount() + 1);
        rinciJual.setBarang(barang);
        rinciJual.setJumlah(Integer.parseInt(view.gettxtJumlah().getText()));
        rinciJual.setHarga(Double.parseDouble(view.gettxtHarga().getText()));
        rinciJual.setDiskon(Double.parseDouble(view.gettxtDiskon().getText()));
        double tot =(rinciJual.getJumlah() * rinciJual.getHarga()) - rinciJual.getDiskon();
        rinciJual.setTotal(tot);
        rinciJualDao.insert(rinciJual); 
    }
    
    public void onClickBtnUpdate() {
        try {
            //penjualan = new Penjualan();
            int index = penjualanDao.getIndex(penjualan);
            penjualan.setNofaktur(view.gettxtNoFaktur().getText());
            penjualan.setPelanggan(pelangganDao.getPelanggan(view.getCboPelanggan().getSelectedItem().toString().split("-")[0]));
            penjualan.setTanggal(view.gettxtTanggal().getText());
            penjualan.setRinciJuals(rinciJualDao.getAllData());
            penjualanDao.update(index, penjualan);
            clearFormFaktur();
            clearFormBarang();
            clearFormHasil();
            rinciJualDao = new RinciJualDao();
            viewTabelRinciJual();
            JOptionPane.showMessageDialog(view, "Update Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void onClickBtnDeleteFaktur() {
        try {
            //penjualan = new Penjualan();
            int index = penjualanDao.getIndex(penjualan);
            penjualanDao.delete(index);
            clearFormFaktur();
            clearFormBarang();
            clearFormHasil();
            rinciJualDao = new RinciJualDao();
            viewTabelRinciJual();
            JOptionPane.showMessageDialog(view, "Update Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void viewTabelRinciJual() {
        DefaultTableModel tabelModel = (DefaultTableModel) view.getTblRinciJual().getModel();
        tabelModel.setRowCount(0);
        double totalharga=0;
        double totaldiskon=0;
        double totalbayar=0;
        for (RinciJual rinciJual : rinciJualDao.getAllData()) {
            totalharga += rinciJual.getHarga();
            totaldiskon += rinciJual.getDiskon();
            totalbayar += rinciJual.getTotal();
            Object[] data = {
                rinciJual.getBarang().getKode(),
                rinciJual.getBarang().getNama(),
                rinciJual.getJumlah(),
                rinciJual.getHarga(),
                rinciJual.getDiskon(),
                rinciJual.getTotal()
            };
            tabelModel.addRow(data);
        }
        view.gettxtTotal().setText(totalharga+"");
        view.gettxtTotalDiskon().setText(totaldiskon+"");
        view.gettxtTotalBayar().setText(totalbayar+""); 
    }
    
    public void onClickBtnDelete() {
        rinciJualDao.delete(view.getTblRinciJual().getSelectedRow()); 
        JOptionPane.showMessageDialog(view, "Delete Ok");
    }
    
    public void onClickBtnSimpan() {
        try {
            penjualan = new Penjualan();
            penjualan.setNofaktur(view.gettxtNoFaktur().getText());
            penjualan.setPelanggan(pelangganDao.getPelanggan(view.getCboPelanggan().getSelectedItem().toString().split("-")[0]));
            penjualan.setTanggal(view.gettxtTanggal().getText());
            penjualan.setRinciJuals(rinciJualDao.getAllData());
            penjualanDao.insert(penjualan);
            clearFormFaktur();
            clearFormBarang();
            clearFormHasil();
            rinciJualDao = new RinciJualDao();
            viewTabelRinciJual();
            JOptionPane.showMessageDialog(view, "Entri Data OK");
            JOptionPane.showMessageDialog(view, "Data Tersimpan");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
           
        }
    }

    public void onClickBtnCari() {
        String nofaktur = view.gettxtNoFaktur().getText();
        penjualan = penjualanDao.getPenjualan(nofaktur);
        if (penjualan != null) {
            view.getCboPelanggan().setSelectedItem(
                    penjualan.getPelanggan().getKode() + "-" + penjualan.getPelanggan().getNama());
            view.gettxtTanggal().setText(penjualan.getTanggal());
            rinciJualDao.setData(penjualan.getRinciJuals());
            viewTabelRinciJual();
            JOptionPane.showMessageDialog(view, "Data ditemukan ");
        }else{
            JOptionPane.showMessageDialog(view, "Data Tidak Ada");
        }
    }
    
}
