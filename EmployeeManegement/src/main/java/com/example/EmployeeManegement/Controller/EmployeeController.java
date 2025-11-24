package com.example.EmployeeManegement.Controller;

import com.example.EmployeeManegement.Entity.Employee;
import com.example.EmployeeManegement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
     @PostMapping("/add/employee")
    public ResponseEntity<Employee> insertTheEmployee(@RequestBody Employee employee){
        Employee employees =employeeService.inserEmployeeData(employee);
        return  ResponseEntity.status( HttpStatus.CREATED).body(employees);
    }
    @PostMapping("/add/all/employess")
    public ResponseEntity<List<Employee>> insertAllEmployees(@RequestBody List<Employee> employeeList){
         List<Employee> employeeList1=employeeService.insertAllEmployee(employeeList);
         return ResponseEntity.status(HttpStatus.CREATED).body(employeeList1);
    }
    @PutMapping("/update/employee/{id}")
    public ResponseEntity<Employee> updateEmployeedata(@PathVariable Integer id, @RequestBody  Employee employee){
         Employee employee1=employeeService.updteEmployee(id,employee);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee1);

    }
    @GetMapping("/findByid/{id}")
    public ResponseEntity<Employee>gettById(@PathVariable Integer id) {
        Employee employee = employeeService.getById(id);
        if (employee != null) {
          return  ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employee);

        }

    }
    @GetMapping("/findAllEmployee")
    public ResponseEntity<List<Employee>>getByAllEmployee(){
         List<Employee> employeess=employeeService.getByAll();
         if(employeess.isEmpty()){
     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
         }
   return ResponseEntity.status(HttpStatus.OK).body(employeess);
         }
@DeleteMapping("/deletById/{id}")
public ResponseEntity<String> deleteTheEmployee(@PathVariable Integer id){
           employeeService.deleteById(id);
         return ResponseEntity.status(HttpStatus.OK).build();



}






}



