package com.example.EmployeeManegement.Service;

import com.example.EmployeeManegement.Entity.User;
import com.example.EmployeeManegement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager manager;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User saveuser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verifyLogin(User user){
        Authentication authentication=manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
   if(authentication.isAuthenticated())
return jwtService.generateToken(user.getUsername());
return "fail";

    }
}
