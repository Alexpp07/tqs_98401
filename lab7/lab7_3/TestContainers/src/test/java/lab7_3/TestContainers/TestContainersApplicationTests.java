package lab7_3.TestContainers;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import lab7_3.TestContainers.Entity.Employee;
import lab7_3.TestContainers.Repository.EmployeeRepository;

@Testcontainers
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestContainersApplicationTests {

	@Container
  	public static PostgreSQLContainer container = new PostgreSQLContainer().withUsername("admin").withPassword("admin").withDatabaseName("employee");

	@Autowired
	private EmployeeRepository employeeRepository;

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}

	@Order(1)
	@DisplayName("Saving new employess to the database")
	@Test
	public void saveEmployees(){
		Employee emp1 = new Employee("Alexandre Pinto",1200,LocalDate.of(2001, 7, 22));
		Employee emp2 = new Employee("João Almeida",7750,LocalDate.of(1997,04,27));
		Employee emp3 = new Employee("Cristiano Ronaldo",950500,LocalDate.of(1985,02,05));

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);

		System.out.println("Saved successfully! 3 employees were saved.");
	}

	@Order(2)
	@DisplayName("Getting all employees from database")
	@Test
	public void getEmployees(){
		System.out.println("Getting all employees");
		employeeRepository.findAll().stream().forEach(System.out::println);
	}
}
