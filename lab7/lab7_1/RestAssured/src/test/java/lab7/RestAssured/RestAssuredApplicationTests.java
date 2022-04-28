package lab7.RestAssured;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestAssuredApplicationTests {

	private final String APIurl = "https://jsonplaceholder.typicode.com/todos";

    @Test
    public void whenEndpointListAllAvailable(){
        when().request("GET", APIurl).then().statusCode(200);
    }

    @Test 
    public void whenQueryingToDo4(){
        when().request("GET", APIurl+"/4").then().assertThat().body("title", equalTo("et porro tempora"));
    }

    @Test
    public void whenListAll(){
        when().request("GET", APIurl).then().body("id", hasItems(198,199));
    }  
}
