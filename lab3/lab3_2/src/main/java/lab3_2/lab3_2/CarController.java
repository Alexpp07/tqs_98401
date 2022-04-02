package lab3_2.lab3_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    
    @Autowired
    private CarManagerService carManagerService;

    @PostMapping
    public ResponseEntity<Car> createCar(Car c){
        HttpStatus status = HttpStatus.CREATED;
        Car saved_car = carManagerService.save(c);
        return new ResponseEntity<>(saved_car, status);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carManagerService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value="id") Long id){
        return ResponseEntity.ok().body(carManagerService.getCarDetails(id).get());
    }
}
