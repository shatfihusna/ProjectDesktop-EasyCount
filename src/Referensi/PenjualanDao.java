/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Referensi;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LABSIKOMP
 */
public class PenjualanDao {
    List<Penjualan> data = new ArrayList();
    
    public void insert(Penjualan penjualan){
        data.add(penjualan);
    }
    
    public void update(int index, Penjualan penjualan){
        data.set(index,penjualan);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Penjualan getPenjualan(int index){
        return data.get(index);
    }
    
    public List<Penjualan> getAllData(){
        return data;
    }
    
    public int getIndex(Penjualan penjualan){
        return data.indexOf(penjualan);
    }
    
     public Penjualan getPenjualan(String kode){
        for(Penjualan penjualan:data){
            if(penjualan.getNofaktur().equals(kode)){
                return data.get(data.indexOf(penjualan));
            }
        }
        return null;
    }
    
}
