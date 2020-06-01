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
public class HouseGPS {
    double xCoordinate, yCoordinate; 
    double area;

    public HouseGPS(double xCoordinate, double yCoordinate, double area) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.area = area;
    }
    
    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }    
}
