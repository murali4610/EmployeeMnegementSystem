package com.example.EmployeeManegement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeGolableException {

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<Map<String,Object>> handleTheEmployeeNotfound(EmployeeNotFound employeeNotFound){
        Map<String,Object>map=new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", HttpStatus.NOT_FOUND.value());
        map.put("error","Employee Not Found");
        map.put("message",employeeNotFound.getMessage());
        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleTheInternalError(Exception exception){
        Map<String,Object>map=new HashMap<>();
        map.put("timestamp",LocalDateTime.now());
        map.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("error","internal server error");
        map.put("message",exception.getMessage());
        return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
