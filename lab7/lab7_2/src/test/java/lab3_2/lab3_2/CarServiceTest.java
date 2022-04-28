package lab3_2.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService mService;

    private Car car;

    @BeforeEach
    public void init() {
        car = new Car("Renault","Megane"); 
    }

    @DisplayName("When valid ID is used, should return a car")
    @Test
    public void validId_returnCar() {
        
        when(carRepository.findByCardId(car.getCarId())).thenReturn(car);
        Optional<Car> newCar = mService.getCarDetails(car.getCarId());
        assertThat(newCar.get().getMaker()).isEqualTo("Renault");
        verify(carRepository, VerificationModeFactory.times(1)).findByCardId(car.getCarId());
    }

    @DisplayName("When invalid ID is used, should return null")
    @Test
    public void invalidId_returnNull() {
        when(carRepository.findByCardId(10L)).thenReturn(null);
        Optional<Car> newCar = mService.getCarDetails(10L);
        verify(carRepository, VerificationModeFactory.times(1)).findByCardId(10L);
        assertThat(newCar.isEmpty()).isEqualTo(true);
    }

    @DisplayName("When given 4 cars,find all should return 4 cars")
    @Test
    public void find4_return4() {
        Car car2 = new Car("BMW","Serie 1");
        Car car3 = new Car("Volvo","V40");
        Car car4 = new Car("Fiat","500");
        List<Car> allCars = Arrays.asList(car, car2, car3, car4);

        when(carRepository.findAll()).thenReturn(allCars);

        List<Car> cars = mService.getAllCars();
        
        verify(carRepository, VerificationModeFactory.times(1)).findAll();
        assertThat(cars).hasSize(4).extracting(Car::getMaker).contains(car.getMaker(), car2.getMaker(), car3.getMaker(), car4.getMaker());
    }

    @DisplayName("When we save a car, the car should be saved")
    @Test
    public void saveCar_carSave() {
        
        
        when(carRepository.save(car)).thenReturn(car);

        Car car_saved = mService.save(car);
        
        verify(carRepository, VerificationModeFactory.times(1)).save(car);
        assertThat(car_saved.getMaker()).isEqualTo("Renault");
    }
}