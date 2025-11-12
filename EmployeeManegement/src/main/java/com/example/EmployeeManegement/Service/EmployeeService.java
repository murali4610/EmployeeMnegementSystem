package com.example.EmployeeManegement.Service;

import com.example.EmployeeManegement.Entity.Employee;
import com.example.EmployeeManegement.Exceptions.EmployeeNotFound;
import com.example.EmployeeManegement.Repository.EmployeeRepostotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepostotry employeeRepostotry;

    public Employee inserEmployeeData(Employee employee){
        return employeeRepostotry.save(employee);
    }

    public List<Employee> insertAllEmployee(List<Employee> employeeList){
        return employeeRepostotry.saveAll(employeeList);
    }

    public Employee updteEmployee(Integer id,Employee  employee){
        Employee employee1=employeeRepostotry.findById(employee.getId()).orElse(null);
        if(employee1==null){
        throw   new RuntimeException("employee not found exception"+employee.getId());
        }
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        return employeeRepostotry.save(employee1);
    }
    public Employee getById(Integer id){
        return employeeRepostotry.findById(id).orElseThrow(()->
                new EmployeeNotFound("employee not found"+id+"not found"));
    }
    public List<Employee> getByAll(){
        return employeeRepostotry.findAll();
    }

    public void deleteById(Integer id){
        Employee employeeex=employeeRepostotry.findById(id).orElseThrow(()->
                new EmployeeNotFound("employee id with"+id+"not found"));
        employeeRepostotry.deleteById(id);
    }


}
