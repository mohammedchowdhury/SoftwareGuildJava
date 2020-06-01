/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

/**
 *
 * @author mohammedchowdhury
 */
public class House3D {
    int numRooms,numBathrooms,numBedRooms, numWindows; 
    double area, areaOfLand;

    public House3D(int numRooms, int numBathrooms, int numBedRooms, int numWindows, double area, double areaOfLand) {
        this.numRooms = numRooms;
        this.numBathrooms = numBathrooms;
        this.numBedRooms = numBedRooms;
        this.numWindows = numWindows;
        this.area = area;
        this.areaOfLand = areaOfLand;
    }
    
    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public int getNumBedRooms() {
        return numBedRooms;
    }

    public void setNumBedRooms(int numBedRooms) {
        this.numBedRooms = numBedRooms;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getAreaOfLand() {
        return areaOfLand;
    }

    public void setAreaOfLand(double areaOfLand) {
        this.areaOfLand = areaOfLand;
    }
    
    
    
}
