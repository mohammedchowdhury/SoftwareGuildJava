/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarystretchgoals.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class User {  // userId::name::n::n-1::n-2:: ....:: n-n  
    private int userId; 
    private String name; 
    private List<String> borrowedItem; /// this will have a list of DVD user borrowed. 
    
    public User(int userId,String name){
        this.userId = userId; 
        this.name = name; 
        borrowedItem = new ArrayList<String>(); 
        
    }
    
    public User(int userId){
        this.userId = userId; 
        borrowedItem = new ArrayList<String>(); 
    }

    public int getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBorrowedItem() {
        return borrowedItem;
    }
    public boolean removeItem(String item){ // removed a specfic item from the list
       return  borrowedItem.remove(item); 
    }
    
    public void addItem(String title){
        borrowedItem.add(title); 
    }
    
}