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
public class Pemakaian_Model {
 private String kode_menu;
    private String id_bahan;
    private String nama_bahan;
    private String jumlah_pakai;

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    
    
    public String getKode_menu() {
        return kode_menu;
    }

    public void setKode_menu(String kode_menu) {
        this.kode_menu = kode_menu;
    }

    public String getId_bahan() {
        return id_bahan;
    }

    public void setId_bahan(String id_bahan) {
        this.id_bahan = id_bahan;
    }

    public String getJumlah_pakai() {
        return jumlah_pakai;
    }

    public void setJumlah_pakai(String jumlah_pakai) {
        this.jumlah_pakai = jumlah_pakai;
    }
    
}
