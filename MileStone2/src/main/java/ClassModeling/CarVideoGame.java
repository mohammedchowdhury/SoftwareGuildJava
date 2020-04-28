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
public class CarVideoGame {
    int xDirection,yDirection; 
    double speed; 

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public void stopCar(){
        this.speed = 0; 
    }  
    public void inCreaseSpeed(){
        speed++; 
    }
    
    
}
