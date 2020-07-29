/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarLotDTO;

import java.math.BigDecimal;

/**
 *
 * @author mohammedchowdhury
 */
public class Car { 
//VIN(String)::make(String)::model(String)::color(String)::price(String)::odometerMiles(Long)::key(Boolean)
    private String VIN;
    private String make;
    private String model;
    private String color;

    private BigDecimal price;
    private long odometerMiles;

    private CarKey key;

    // plus getters, setters & appropriate constructors
    public Car(String VIN) {
        this.VIN = VIN;
    }

    public Car(String VIN, String make, String model, String color, BigDecimal price, long odometerMiles, CarKey key) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
        this.odometerMiles = odometerMiles;
        this.key = key;
    }

    public Car(String VIN, String make, String model, String color, String price, long odometerMiles, boolean laserCut) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = new BigDecimal(price);
        this.odometerMiles = odometerMiles;
        this.key = new CarKey(VIN, laserCut);
    }

    public String getVIN() {
        return VIN;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getOdometerMiles() {
        return odometerMiles;
    }

    public CarKey getKey() {
        return key;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOdometerMiles(long odometerMiles) {
        this.odometerMiles = odometerMiles;
    }

    public void setKey(CarKey key) {
        this.key = key;
    }

    public void setKey(boolean laserCut) {
        this.key = new CarKey(this.VIN, laserCut);
    }

}
