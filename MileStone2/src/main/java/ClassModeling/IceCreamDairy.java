/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

import java.util.ArrayList;

/**
 *
 * @author mohammedchowdhury
 */
public class IceCreamDairy {
    private ArrayList<String> flavors; 
    private int producedToday; 
    
    public IceCreamDairy()  {    
        flavors = new ArrayList<>(); 
        producedToday = 0; 
    } 
    
    public void MakeIceCream(){
        producedToday++;       
    }

    public ArrayList<String> getFlavors() {
        return flavors;
    }

    public void setFlavors(ArrayList<String> flavors) {
        this.flavors = flavors;
    }

    public int getProducedToday() {
        return producedToday;
    }

    public void setProducedToday(int producedToday) {
        this.producedToday = producedToday;
    }
    
    
    
    
}
