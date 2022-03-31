## lab3_1 - 98401

#### a) Identify a couple of examples on the use of AssertJ expressive methods chaining.

    In A_EmployeeRepositoryTest:
        assertThat( found ).isEqualTo(alex);
        assertThat(fromDb).isNull();
        ... and more ...

    In D_EmployeeRestControllerIT:
        assertThat(found).extracting(Employee::getName).containsOnly("bob");


#### b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).

    In C_EmployeeController_WithMockServiceTest:
        when( service.save(Mockito.any()) ).thenReturn( alex);


#### c) What is the difference between standard @Mock and @MockBean?

    @Mock - is a shorthand for the Mockito.mock() method. It is usefull in unit tests in business logic (only using JUnit and Mockito).

    @MockBean - is usefull in integration tests in order to mock a been when we write a test that is backed by a Spring Test Context.

    Both are creating Mock objects


#### d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

    The application-integrationtest.properties file contains the details to configure the persistence storage.

    The anotation @TestPropertySource commented in the D_EmployeeRestControllerIT class allows to configure the locations of properties files specific to the tests. In this case the configuration file to be used should be the application-integrationtest.properties file

#### e) The sample project demonstrates three test strategies to assess anAPI (C, D and E)developed with SpringBoot.Which are the main/keydifferences?

