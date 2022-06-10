/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Raven
 */
public class Transaksi_Model {
    private String id_transaksi;
    private String id_pemesanan;
    private int totalbelanja;
    private String uangbayar;
    private String uangkembali;

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public int getTotalbelanja() {
        return totalbelanja;
    }

    public void setTotalbelanja(int totalbelanja) {
        this.totalbelanja = totalbelanja;
    }

 

    public String getUangbayar() {
        return uangbayar;
    }

    public void setUangbayar(String uangbayar) {
        this.uangbayar = uangbayar;
    }

    public String getUangkembali() {
        return uangkembali;
    }

    public void setUangkembali(String uangkembali) {
        this.uangkembali = uangkembali;
    }
    
    
}
