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
 * @author ASUS
 */
public class RinciJualDao {
    List<RinciJual> data = new ArrayList();
    
    public void insert(RinciJual rinciJual){
        data.add(rinciJual);
    }
    
    public void update(int index, RinciJual rinciJual){
        data.set(index,rinciJual);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public RinciJual getRinciJual(int index){
        return data.get(index);
    }
    
    public List<RinciJual> getAllData(){
        return data;
    }
    
    public void clear(){
        data.clear();
    }
    
    public void setData(List<RinciJual> data){
        this.data = data;
    }
   
}
