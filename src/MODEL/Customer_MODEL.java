/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author DINI
 */
public class Customer_MODEL {
    private String kode_customer;
    private String kode_menu;
    private String id_pemesanan;
    private String id_kasir;
    private String banyak_pesan;
    private String jumlah;
    private String uang_bayar;

    public String getKode_customer() {
        return kode_customer;
    }

    public void setKode_customer(String kode_customer) {
        this.kode_customer = kode_customer;
    }

    public String getKode_menu() {
        return kode_menu;
    }

    public void setKode_menu(String kode_menu) {
        this.kode_menu = kode_menu;
    }

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(String id_kasir) {
        this.id_kasir = id_kasir;
    }

    public String getBanyak_pesan() {
        return banyak_pesan;
    }

    public void setBanyak_pesan(String banyak_pesan) {
        this.banyak_pesan = banyak_pesan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getUang_bayar() {
        return uang_bayar;
    }

    public void setUang_bayar(String uang_bayar) {
        this.uang_bayar = uang_bayar;
    }
    
    
}
