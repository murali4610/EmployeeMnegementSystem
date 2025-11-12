package com.example.EmployeeManegement.Repository;

import com.example.EmployeeManegement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepostotry extends JpaRepository<Employee,Integer> {
}
