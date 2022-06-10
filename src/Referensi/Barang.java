/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referensi;


/**
 *
 * @author ASUS
 */
public class Barang {
    private String kode;
    private String nama;
    private double harga;
    
    public Barang(String kode, String nama, double harga){
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }
    
    public double getHarga(){
        return harga;
    }
    public String getKode(){
        return kode;
    }
    public String getNama(){
        return nama;
    }
    public void setHarga(double harga){
        this.harga = harga;
    }
    public void setKode(String Kode){
        this.harga = harga;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
