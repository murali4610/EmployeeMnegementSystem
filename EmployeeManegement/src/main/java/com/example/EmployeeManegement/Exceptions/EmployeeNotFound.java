package com.example.EmployeeManegement.Exceptions;

public class EmployeeNotFound extends  RuntimeException{
    public EmployeeNotFound(String message) {
        super(message);
    }
}
