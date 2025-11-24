package com.example.EmployeeManegement.Controller;

import com.example.EmployeeManegement.Entity.User;
import com.example.EmployeeManegement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String Hellow(){
        return "welcome to employeemangement";
    }
    @PostMapping("/Register")
    public ResponseEntity<User> regiseruser(@RequestBody User user){
        User user1=userService.saveuser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @PostMapping("/login")
    public String login(@RequestBody User usersInformtion){

        return userService.verifyLogin(usersInformtion);
    }
}
