/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referensi;

import java.util.*;
/**
 *
 * @author LABSIKOMP
 */
public class BarangDao {
    List<Barang> data = new ArrayList();
    public BarangDao(){
        data.add(new Barang("B001","Mouse",100000));
        data.add(new Barang("B002","Printer",250000));
    }
    public void insert(Barang barang){
        data.add(barang);
    }
    public void update(int index, Barang barang){
        data.set(index,barang);
    }
    public void delete(int index){
        data.remove(index);
    }
    public Barang getBarang (int index){
        return data.get(index);
    }
    public List<Barang>getAllData(){
        return data;
    }

    public Barang getBarang(String kode){
        for(Barang barang:data){
            if(barang.getKode().equals(kode)){
                return data.get(data.indexOf(barang));
            }
        }
        return null;
    }
}
