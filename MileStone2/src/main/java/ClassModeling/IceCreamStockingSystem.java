/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

import java.util.Hashtable;

/**
 *
 * @author mohammedchowdhury
 */
public class IceCreamStockingSystem {
    private Hashtable<String,Integer> iceCream ; 
    
    public IceCreamStockingSystem(){
        iceCream = new Hashtable<>(); 
    }
    
   public void addIceCream(String name){
       
       if(iceCream.get(name)==null){
           iceCream.put(name,1); 
       }else{
            int a = iceCream.get(name); 
            a++; 
            iceCream.put(name, a);    
       }
   }
     public int getIceCream(String name){
       
       if(iceCream.get(name)==null){
           return 0; 
       }else{
            int a = iceCream.get(name); 
            a--; 
            if(a==0){
                iceCream.remove(name);
            }else{
                iceCream.put(name, a);    
            }
          
       }
       return 1; 
   }
    
    
    
    
    
    
}
