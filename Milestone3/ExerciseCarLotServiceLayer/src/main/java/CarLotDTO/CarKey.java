/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarLotDTO;

/**
 *
 * @author mohammedchowdhury
 */
public class CarKey {
    private String VIN;
    private boolean laserCut;
    // plus getters, setters & appropriate constructors

    public CarKey(String VIN) {
        this.VIN = VIN;
    }
    
    public CarKey(String VIN, boolean laserCut) {
        this.VIN = VIN;
        this.laserCut = laserCut;
    }

    public String getVIN() {
        return VIN;
    }

    public boolean isLaserCut() {
        return laserCut;
    }

    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }
}