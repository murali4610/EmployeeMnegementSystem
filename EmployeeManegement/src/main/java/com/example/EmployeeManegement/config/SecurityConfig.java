package com.example.EmployeeManegement.config;

import com.example.EmployeeManegement.Service.JwtFilter;
import com.example.EmployeeManegement.Service.MyUserDetailesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailesService myUserDetailesService;

    @Autowired
     private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(custumizer -> custumizer.disable())
                .authorizeHttpRequests(request -> request.requestMatchers("/Register","/login")
                        .permitAll()
                        .anyRequest().authenticated())
                .formLogin(f -> f.disable()) // disable username/password login filter
                .httpBasic(h -> h.disable())
                .sessionManagement(sesstion->sesstion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())

                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)


                .build();
    }
    @Bean
     public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider  authenticationProvider=new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    authenticationProvider.setUserDetailsService(myUserDetailesService);
        return authenticationProvider;
}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();

    }

}
