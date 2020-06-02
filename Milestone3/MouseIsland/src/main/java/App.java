/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammedchowdhury
 */
public class App {
    
    static int numSimulation = 0; 
    static int width,height; 
    static int[][]map;
    static String title; 
    
    //mouse facts
    
    

    public static void main(String[] args) {

        ReadFromFile.readFromFile();
        numSimulation = ReadFromFile.simulations; 
        width = ReadFromFile.Width; 
        height = ReadFromFile.Height; 
        map = ReadFromFile.map; 
        title = ReadFromFile.title; 

        RunSimulation();

    }

    public static void RunSimulation() {
        
        for(int i=0;i<numSimulation;i++){
            Mouse newMouse = new Mouse(); 
            
            while(!newMouse.dead){
               
                newMouse.getLocation(); 
                
                
                
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
            
            
        }
    }

}
