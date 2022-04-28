package lab3_2.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired 
    private CarRepository carRepository;


    private Car car;

    @BeforeEach
    public void init() {
        car = new Car("Renault","Megane"); 
    }

    
    @DisplayName("When invalid ID is used, should return null")
    @Test
    public void invalidId_returnNull() {
        Car newCar = carRepository.findByCardId(10L);
        assertThat(newCar).isNull();
    }

    @DisplayName("When valid ID is used, should return a car")
    @Test
    public void validId_returnCar() {

        entityManager.persistAndFlush(car);
        Car newCar = carRepository.findByCardId(car.getCarId());
        assertThat(newCar).isNotNull();
        assertThat(newCar.getMaker()).isEqualTo(car.getMaker());
    }

    @DisplayName("When given 3 cars,find all should return 3 cars")
    @Test
    public void find3_return3() {
        Car car2 = new Car("BMW","Serie 1");
        Car car3 = new Car("Volvo","V40");

        entityManager.persist(car);
        entityManager.persist(car2);
        entityManager.persist(car3);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getMaker).containsOnly(car.getMaker(), car2.getMaker(), car3.getMaker());
    }

}
