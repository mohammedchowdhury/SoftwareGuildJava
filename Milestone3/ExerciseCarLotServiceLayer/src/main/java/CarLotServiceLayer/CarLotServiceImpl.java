package CarLotServiceLayer;

import CarLotDAO.CarLotDAO;
import CarLotDTO.Car;
import CarLotDTO.CarKey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class CarLotServiceImpl implements CarLotService {

    CarLotDAO dao;

    public CarLotServiceImpl(CarLotDAO dao) {
        this.dao = dao;
    }

    @Override
    public Car getACar(String VIN) {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> allCars = dao.getCars();
        List<Car> selectedCars = new ArrayList<Car>();

        for (int i = 0; i < allCars.size(); i++) {
            if (allCars.get(i).getColor().equals(color)) {
                selectedCars.add(allCars.get(i));
            }
        }
        return selectedCars;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        List<Car> allCars = dao.getCars();
        List<Car> selectedCars = new ArrayList<Car>();

        for (int i = 0; i < allCars.size(); i++) {
            int val = allCars.get(i).getPrice().compareTo(maxPrice); // if val is 0 the price is same, if val is  -1 the price is lower
            if (val <= 0) {
                selectedCars.add(allCars.get(i));
            }
        }
        return selectedCars;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> allCars = dao.getCars();
        List<Car> selectedCars = new ArrayList<Car>();
        for (int i = 0; i < allCars.size(); i++) {
            Car car = allCars.get(i);
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                selectedCars.add(car);
            }
        }
        return selectedCars;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        Car car = dao.getCar(VIN);

        if (car == null) {
            throw new NoSuchCarException("No such car exists");
        }
        BigDecimal carPrice = car.getPrice();
        if (percentDiscount.compareTo(new BigDecimal("1")) < 0) {

            BigDecimal percentage = new BigDecimal("1");  //1
            percentage = percentage.subtract(percentDiscount);// .85
            carPrice = carPrice.multiply(percentage);
            car.setPrice(carPrice);
        } else {

            BigDecimal percentage = new BigDecimal("100"); // 
            percentage = percentage.subtract(percentDiscount);
            percentage = percentage.divide(new BigDecimal("100"));

            carPrice = carPrice.multiply(percentage);
            car.setPrice(carPrice);
        }
        return car.getPrice();
    }

//    Given a VIN and a cash Amount, it should 'buy' - checking if the price matches, 
    //removing the car from the lot, and returning the associated CarKey.
//If there is no car that matches, it should throw a NoSuchCarException
//If they gave too much money, it should throw an OverpaidPriceException
//If they gave too little money, it should throw an UnderpaidPriceException
    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {

        Car car = dao.getCar(VIN); 
        
        if(car==null){
            throw new NoSuchCarException("No such car was found for "+VIN);
        }
        if(car.getPrice().compareTo(cashPaid)>0){
            throw new UnderpaidPriceException("You dont have enough money to buy this car"); 
            
        }
        if(car.getPrice().compareTo(cashPaid)<0){
             throw new OverpaidPriceException("You over paid"); 
        }
        
        if(car.getPrice().compareTo(cashPaid)==0){
            dao.removeCar(VIN);  
            return car.getKey();
        }
        
     return null; 
    }
}
