/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammedchowdhury
 */
public class Mouse {
    
    boolean dead; 
    int foodLevel; 
    int xLocation,yLocation; 
    
    public Mouse(){
        dead = false; 
        foodLevel = 100; 
        xLocation = 1; 
        yLocation = 1; 
    }

    public void setFoodLevel() {
        this.foodLevel = 100; 
    }
    
    public int getFoodLevel(){ // every time this is called we are decreasing the food level
        foodLevel--; 
        return foodLevel; 
    }
    
    public void setLocation(int x,int y){
        this.xLocation = x; 
        this.yLocation = y; 
    }

    public int[] getLocation(){ // gives us the string 
       int [] arr = new int[2]; 
       arr[0] = xLocation; 
       arr[1] = yLocation;   
       return arr;  
    }
    
    
}
