package lab3_2.lab3_2;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarManagerService mService;

    private Car car;

    @BeforeEach
    public void init() throws Exception{
        car = new Car("Renault", "Megane");
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @DisplayName("When posted a car, a car ir created")
    @Test
    public void postCar_createCar() throws Exception{
        when(mService.save(car)).thenReturn(car);
        RestAssuredMockMvc.given()
        .header("Content-type", "application/json")
        .and()
        .body(car)
        .when()
        .post("/api/cars")
        .then()
        .statusCode(201);
    }

    @DisplayName("When trying to get cars, they are return in a JSON Array")
    @Test
    public void getCars_returnJsonArray() throws Exception {

        Car car1 = new Car("Bugati","Chiron");
        Car car2 = new Car("Audi","S3");

        List<Car> cars = Arrays.asList(car, car1, car2);

        when(mService.getAllCars()).thenReturn(cars);

        RestAssuredMockMvc.when().get("/api/cars").then().body("maker", hasItems("Bugati","Chiron")).statusCode(200);

        verify(mService, VerificationModeFactory.times(1)).getAllCars();

    }

}
