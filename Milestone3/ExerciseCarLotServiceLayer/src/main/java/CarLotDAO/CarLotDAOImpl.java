package CarLotDAO;
import CarLotDTO.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author mohammedchowdhury
 */
public class CarLotDAOImpl implements CarLotDAO {
    Map<String, Car> carList = new HashMap<String, Car>();

    @Override
    public Car addCar(String VIN, Car car) {
        return carList.put(VIN, car);
    }

    @Override
    public Car getCar(String VIN) {
        return carList.get(VIN);
    }

    @Override
    public List<Car> getCars() {
        return new ArrayList(carList.values());
    }

    @Override
    public void editCar(String VIN, Car car) {
        carList.put(VIN, car);
    }

    @Override
    public Car removeCar(String VIN) {
        return carList.remove(VIN); 
    }
}