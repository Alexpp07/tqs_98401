package lab3_2.lab3_2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car c){
        return carRepository.save(c);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarDetails(Long id){
        Car c = carRepository.findByCardId(id);
        Optional<Car> car;
        if(c!=null){
            car = Optional.of(c);
        } else{
            car = Optional.empty();
        }
        return car;
    }
}
