package lab7_3.TestContainers.Entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;

    @Column(name="salary")
    private int salary;

    @Column(name="birthday")
    private LocalDate birthday;

    public Employee(String name, int salary, LocalDate birthday){
        this.name=name;
        this.salary=salary;
        this.birthday=birthday;
    }

    public Employee(){}

}