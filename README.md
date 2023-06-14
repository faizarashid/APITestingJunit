# APITestingJunit

Explaination:

Table Used: Employee ( id , name, city , contactno)

To Test a Service ::
@ExtendWith(MockitoExtension.class)
@Mock allows us to create and inject a mock of EmployeeRepository
@InjectMocks is used to create an instance of our service EmployeeServiceImpl so that we can test it
Using getAllEmployees test method check if the lenght is same with actual and expected value.

To test a Controller::
@WebMvcTest(EmployeeController.class)
@MockBean to create a mock of EmployeeService and add it into the application context.
@Autowiring Mockmvc
Using getAllEmployees method to insert a behaviour when employeeservice.getAllEmployees actuall method is called and then return a test list. Also perform controller request on out endpoint and check actual and expected result.

Reference Atricle:: https://devwithus.com/spring-boot-rest-api-unit-testing/
