/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referensi;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author LABSIKOMP
 */
public class PelangganDao {
    List<Pelanggan> data = new ArrayList();
    public PelangganDao(){
        data.add(new Pelanggan("P001","Shatfi"));
        data.add(new Pelanggan("P002","Nikhy"));
    }
    public void insert(Pelanggan pelanggan){
        data.add(pelanggan);
    }
    
    public void update(int index, Pelanggan pelanggan){
        data.set(index, pelanggan);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Pelanggan getPelanggan(int index){
        return data.get(index);
    }
    public List<Pelanggan>getAllData(){
        return data;
    }
    
    public Pelanggan getPelanggan(String kode){
        for(Pelanggan pelanggan:data){
            if(pelanggan.getKode().equals(kode)){
                return data.get(data.indexOf(pelanggan));
            }
        }
        return null;
    }
}
