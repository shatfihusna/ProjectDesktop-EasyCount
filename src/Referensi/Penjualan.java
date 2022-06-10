/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referensi;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class Penjualan {
    private String nofaktur;
    private String tanggal;
    private Pelanggan pelanggan;
    private List<RinciJual>rinciJuals;
    
    public List<RinciJual>getRinciJuals(){
        return rinciJuals;
    }
    
    public void setRinciJuals(List<RinciJual>rinciJuals){
        this.rinciJuals = rinciJuals;
    }

    public String getNofaktur() {
        return nofaktur;
    }

    public void setNofaktur(String nofaktur) {
        this.nofaktur = nofaktur;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    } 
}
