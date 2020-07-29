package CarLotServiceLayer;


import CarLotDTO.Car;
import CarLotDTO.CarKey;
import java.math.BigDecimal;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author mohammedchowdhury
 */
public interface CarLotService {
    public Car getACar(String VIN);    
    public List<Car> getAllCars();
    public List<Car> getCarsByColor(String color);
    public List<Car> getCarsInBudget(BigDecimal maxPrice);
    public List<Car> getCarByMakeAndModel(String make, String model);

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
        throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)throws 
            NoSuchCarException,
            OverpaidPriceException,
            UnderpaidPriceException;
    
}