package lab7_3.TestContainers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lab7_3.TestContainers.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}