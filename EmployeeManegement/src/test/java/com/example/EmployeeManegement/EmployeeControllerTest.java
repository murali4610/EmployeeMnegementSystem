//package com.example.EmployeeManegement;
//
//import com.example.EmployeeManegement.Controller.EmployeeController;
//import com.example.EmployeeManegement.Entity.Employee;
//import com.example.EmployeeManegement.Service.EmployeeService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//
//@SpringBootTest
//public class EmployeeControllerTest {
//    @Mock
//    private EmployeeService employeeService;
//    @InjectMocks
//    private EmployeeController employeeController;
//   @Test
//    public void insertTheEmployeeTest(){
//        Employee employee=new Employee(1,"sai",23500.00);
//        Mockito.when(employeeService.inserEmployeeData(employee)).thenReturn(employee);
//
//        ResponseEntity<Employee>  responseEntity=employeeController.insertTheEmployee(employee);
//        Assertions.assertNotNull(responseEntity);
//        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
//        Assertions.assertEquals("sai",employee.getName());
//        Assertions.assertEquals(23500.00,employee.getSalary());
//        Mockito.verify(employeeService,Mockito.times(1)).inserEmployeeData(employee);
//    }
//    @Test
//    public void insertAllEmployeesTest(){
//        List<Employee> employees= Arrays.asList(new Employee(1,"babu",2300.00),
//                new Employee(2,"siva",5230.00));
//        Mockito.when(employeeService.insertAllEmployee(employees)).thenReturn(employees);
//        ResponseEntity<List<Employee>> listResponseEntity=employeeController.insertAllEmployees(employees);
//      //  Assertions.assertNull(listResponseEntity);
//        Assertions.assertNotNull(listResponseEntity);
//        Assertions.assertEquals(HttpStatus.CREATED,listResponseEntity.getStatusCode());
//        Assertions.assertEquals(2,listResponseEntity.getBody().size());
//        Assertions.assertEquals("babu",listResponseEntity.getBody().get(0).getName());
//        Mockito.verify(employeeService,Mockito.times(1)).insertAllEmployee(employees);
//    }
//    @Test
//    public void getByAllEmployeeSucess_Test(){
//       List<Employee> employees=Arrays.asList(new Employee(1,"manu",2400.00),
//               new Employee(2,"kanna",6300.00));
//       Mockito.when(employeeService.getByAll()).thenReturn(employees);
//
//       ResponseEntity<List<Employee>> listResponseEntity=employeeController.getByAllEmployee();
//
//        Assertions.assertNotNull(listResponseEntity);
//       Assertions.assertEquals(HttpStatus.OK,listResponseEntity.getStatusCode());
//       Assertions.assertEquals(2,listResponseEntity.getBody().size());
//       Assertions.assertEquals("manu",listResponseEntity.getBody().get(0).getName());
//       Mockito.verify(employeeService,Mockito.times(1)).getByAll();
//    }
//    @Test
//    public  void getByAllEmployeeNocontent_Test(){
//       Mockito.when(employeeService.getByAll()).thenReturn(new ArrayList<>());
//       ResponseEntity<List<Employee>> listResponseEntity=employeeController.getByAllEmployee();
//
//        Assertions.assertNotNull(listResponseEntity);
//       Assertions.assertEquals(HttpStatus.NO_CONTENT,listResponseEntity.getStatusCode());
//       Mockito.verify(employeeService,Mockito.times(1)).getByAll();
//    }
//  //  deleteTheEmployee
//    @Test
//    public void deleteTheEmployeeTest(){
//       Integer id=1;
//       String medelete="employee remove sucsfully";
//    //   Employee employee=new Employee(1,"babu",2300.00);
//         doNothing().when(employeeService).deleteById(id);
//        ResponseEntity<String> responseEntity=employeeController.deleteTheEmployee(id);
//      //  Assertions.assertNull(responseEntity);
//        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
//      // Assertions.assertEquals(medelete,responseEntity.getBody());
//       Mockito.verify(employeeService,Mockito.times(1)).deleteById(id);
//    }
//    @Test
//    public void gettByIdSuccess_Test(){
//       Integer id=1;
//       Employee employee=new Employee(1,"babu",3300.00);
//       Mockito.when(employeeService.getById(id)).thenReturn(employee);
//
//       ResponseEntity<Employee> responseEntity=employeeController.gettById(id);
//     //  Assertions.assertNull(responseEntity);
//        Assertions.assertNotNull(responseEntity);
//       Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
//       Assertions.assertEquals(employee,responseEntity.getBody());
//       Mockito.verify(employeeService,Mockito.times(1)).getById(id);
//   }
//   @Test
//   public void gettByIdNocontent_Test(){
//       Integer id=9;
//       Mockito.when(employeeService.getById(id)).thenReturn(null);
//       ResponseEntity<Employee> responseEntity=employeeController.gettById(id);
//       Assertions.assertNotNull(responseEntity);
//       Assertions.assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
//     //  Assertions.assertEquals(HttpStatus.NO_CONTENT,responseEntity.getStatusCode());
//       Assertions.assertNull(responseEntity.getBody());
//       Mockito.verify(employeeService,Mockito.times(1)).getById(id);
//   }
//    @Test
//    public void updateEmployeedataTest() {
//        Integer id=1;
//        Employee employee=new Employee(1,"murali",5500.00);
//        Employee updateemloyee=new Employee(1,"murali mohan",700000.00);
//        Mockito.when(employeeService.updteEmployee(id,employee)).thenReturn(updateemloyee);
//
//        ResponseEntity<Employee> responseEntity=employeeController.updateEmployeedata(id,employee);
//      //  Assertions.assertNull(responseEntity);
//        Assertions.assertNotNull(responseEntity);
//        Assertions.assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
//        Assertions.assertEquals("murali mohan",responseEntity.getBody().getName());
//       // Assertions.assertEquals("murali mohan",responseEntity.getBody().getName());
//        Assertions.assertEquals(700000.00,responseEntity.getBody().getSalary());
//      //  Assertions.assertEquals(700000.00,responseEntity.getBody().getSalary());
//        Mockito.verify(employeeService,Mockito.times(1)).updteEmployee(id,employee);
//    }
//}
