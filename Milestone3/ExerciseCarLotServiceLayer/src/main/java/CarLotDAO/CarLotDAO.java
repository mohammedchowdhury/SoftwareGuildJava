/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarLotDAO;

import CarLotDTO.Car;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public interface CarLotDAO {
    
    /**
     * return null if car was not added under that same VIN
     * return a old car to be replaced
     * 
     * @param VIN
     * @param car
     * @return 
     */
    public Car addCar(String VIN, Car car);    
    
    /**
     * gets car under VIN or returns null if empty
     * 
     * @param VIN
     * @return 
     */
    public Car getCar(String VIN);   
    
    /**
     * returns a list of cars
     * 
     * @return 
     */
    public List<Car> getCars();

    /**
     * 
     * replaces the old car under the VIN 
     * 
     * @param VIN
     * @param car 
     */
    public void editCar(String VIN, Car car);    

    /**
     * removes a car from the list
     * 
     * @param VIN
     * @return 
     */
    public Car removeCar(String VIN);    
}