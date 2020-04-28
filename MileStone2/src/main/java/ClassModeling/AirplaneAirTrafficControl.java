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
public class AirplaneAirTrafficControl {
   int numPlanesOnGround, numPlanesOnAir; 
   ArrayList<String> planes; 
    ArrayList<String> planesOnLand;
    ArrayList<String>planesOnAir; 
   String nextLanding,nextTakingOff; 

    public AirplaneAirTrafficControl() {

        numPlanesOnAir = 0; 
        numPlanesOnGround = 0; 
        planes = new ArrayList<>(); 
        planesOnLand = new ArrayList<>(); 
        planesOnAir = new ArrayList<>(); 
        nextLanding = null; 
        nextTakingOff = null; 
    }

    public int getNumPlanesOnGround() {
        return numPlanesOnGround;
    }

    public void setNumPlanesOnGround(int numPlanesOnGround) {
        this.numPlanesOnGround = numPlanesOnGround;
    }

    public int getNumPlanesOnAir() {
        return numPlanesOnAir;
    }

    public void setNumPlanesOnAir(int numPlanesOnAir) {
        this.numPlanesOnAir = numPlanesOnAir;
    }

    public ArrayList<String> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<String> planes) {
        this.planes = planes;
    }
    
    public void addPlane(String plane){
        this.planes.add(plane);
    }
    
    public void removePlane(String plane){
        for(int a=0; a<planes.size();a++){
            if(planes.get(a).equals(plane)){
                planes.remove(a); 
                break; 
            }
        }
    }

    public ArrayList<String> getPlanesOnLand() {
        return planesOnLand;
    }
    
    public void removePlaneOnLand(){
        String temp = planesOnLand.get(0); 
        planesOnLand.remove(0);
        planesOnAir.add(temp);    
    }

    public void setPlanesOnLand(ArrayList<String> planesOnLand) {
        this.planesOnLand = planesOnLand;
    }

    public ArrayList<String> getPlanesOnAir() {
        return planesOnAir;
    }

    public void setPlanesOnAir(ArrayList<String> planesOnAir) {
        this.planesOnAir = planesOnAir;
    }
    
    public void removePlaneOnAir(){
        String temp = planesOnAir.get(0); 
        planesOnAir.remove(0);
        planesOnLand.add(temp);    
    }
    

    public String getNextLanding() {
        return nextLanding;
    }

    public void setNextLanding() {
        this.nextLanding = planesOnAir.get(0); 
    }

    public String getNextTakingOff() {
        return nextTakingOff;
    }

    public void setNextTakingOff() {
      nextTakingOff = planesOnLand.get(0); 
    } 
    
}
