//package com.example.EmployeeManegement;
//
//import com.example.EmployeeManegement.Entity.Employee;
//import com.example.EmployeeManegement.Exceptions.EmployeeNotFound;
//import com.example.EmployeeManegement.Repository.EmployeeRepostotry;
//import com.example.EmployeeManegement.Service.EmployeeService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//public class EmployeeServiceTest {
//     @Mock
//    private EmployeeRepostotry employeeRepostotry;
//     @InjectMocks
//     private EmployeeService employeeService;
//@Test
// public void  inserEmployeeDataTest(){
//     Employee employee=new Employee(1,"mohan",3300.00);
//
//     Mockito.when(employeeRepostotry.save(employee)).thenReturn(employee);
//     Employee employee1=employeeService.inserEmployeeData(employee);
//     Assertions.assertEquals(1,employee1.getId());
//     Assertions.assertEquals("mohan",employee1.getName());
//     Assertions.assertEquals(3300.00,employee1.getSalary());
//     Mockito.verify(employeeRepostotry,Mockito.times(1)).save(employee);
//
//
// }
// @Test
// public void insertAllEmployeeTest(){
//     List<Employee> employees= Arrays.asList(new Employee(1,"babu",2200.00),
//             new Employee(2,"sai",3300.0));
//     Mockito.when(employeeRepostotry.saveAll(employees)).thenReturn(employees);
//     List<Employee> employeeList=employeeService.insertAllEmployee(employees);
//     Assertions.assertNotNull(employeeList);
//     Assertions.assertEquals(2,employeeList.size());
//     Assertions.assertEquals("babu",employeeList.get(0).getName());
//     Assertions.assertEquals("sai",employeeList.get(1).getName());
//     Mockito.verify(employeeRepostotry,Mockito.times(1)).saveAll(employees);
// }
// @Test
// public void updteEmployeeTest(){
//    Integer id=1;
//    Employee   employee=new Employee(1,"lok",2200.00);
//    Employee employee1=new Employee(1,"manu",2300.00);
//    Mockito.when(employeeRepostotry.findById(1)).thenReturn(Optional.of(employee));
//    Mockito.when(employeeRepostotry.save(Mockito.any(Employee.class))).thenReturn(employee1);
//    Employee employee2=employeeService.updteEmployee(id,employee);
//    Assertions.assertNotNull(employee2);
//    Assertions.assertEquals("manu",employee2.getName());
//    Assertions.assertEquals(2300.00,employee2.getSalary());
//    Mockito.verify(employeeRepostotry,Mockito.times(1)).findById(id);
//    Mockito.verify(employeeRepostotry,Mockito.times(1)).save(employee);
// }
// @Test
// public void updteEmployeenot_test(){
//  Employee employee=new Employee(1,"lok",2200.00);
//  Mockito.when(employeeRepostotry.findById(employee.getId())).thenReturn(Optional.empty());
// RuntimeException runtimeException=Assertions.assertThrows(RuntimeException.class,()->{
//   employeeService.updteEmployee(1,employee);
//     });
// Assertions.assertTrue(runtimeException.getMessage().contains("employee not found"));
// Mockito.verify(employeeRepostotry,Mockito.times(1)).findById(1);
// Mockito.verify(employeeRepostotry,Mockito.never()).save(Mockito.any());
// }
// @Test
// public void getByIdsucess_test(){
//    Integer id=1;
//    Employee employee=new Employee(1,"siva",3300.00);
//    Mockito.when(employeeRepostotry.findById(id)).thenReturn(Optional.of(employee));
//  Employee employee1=employeeService.getById(id);
//  Assertions.assertNotNull(employee1);
//  Assertions.assertEquals(1,employee1.getId());
//  Assertions.assertEquals("siva",employee1.getName());
//  Assertions.assertEquals(3300.00,employee1.getSalary());
//  Mockito.verify(employeeRepostotry,Mockito.never()).findById(id);
//
// }
// @Test
// public void getByIdNotfpond_Test(){
//    Integer id=9;
//    Mockito.when(employeeRepostotry.findById(id)).thenReturn(Optional.empty());
//     RuntimeException employeeNotFound=Assertions.assertThrows(RuntimeException.class,()->{
//         employeeService.getById(id);
//
//     });
//
//
//     Mockito.verify(employeeRepostotry,Mockito.times(1)).findById(1);
// }
//}
