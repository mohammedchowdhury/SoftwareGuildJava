import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammedchowdhury
 */
public class Cat {
    int xLocation,yLocation; 
    
    public Cat(){
        this.xLocation = 2; 
        this.yLocation = 2; 
    }
    
    public void setLocation(int x,int y){
        this.xLocation = x; 
        this.yLocation = y; 
    }
    
    public int[] getCatLocation(int width,int height){
        int [] arr = new int [2]; 
        arr[0] = xLocation; 
        arr[1] = yLocation;  
        return arr; 
    }
}
