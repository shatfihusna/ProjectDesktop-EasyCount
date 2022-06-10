/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL;

/**
 *
 * @author HP
 */
public class Pemesanan_Model {
    private String id_pemesanan;
    private int kode_transaksi;
    private String tanggal_pesan;
    private String kode_menu;
    private String nama_menu;
    private int harga_menu;
    private int jumlah_pesan;

    public int getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(int kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }


    
    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getTanggal_pesan() {
        return tanggal_pesan;
    }

    public void setTanggal_pesan(String tanggal_pesan) {
        this.tanggal_pesan = tanggal_pesan;
    }

    public String getKode_menu() {
        return kode_menu;
    }

    public void setKode_menu(String kode_menu) {
        this.kode_menu = kode_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public int getHarga_menu() {
        return harga_menu;
    }

    public void setHarga_menu(int harga_menu) {
        this.harga_menu = harga_menu;
    }

    public int getJumlah_pesan() {
        return jumlah_pesan;
    }

    public void setJumlah_pesan(int jumlah_pesan) {
        this.jumlah_pesan = jumlah_pesan;
    }



    
}
