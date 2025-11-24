package com.example.EmployeeManegement.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private String secret="n8VgZbH0gPgncX7uSLyYt1Jb0bD3sVhJWMFrDuU7bKk=";
 public String generateToken(String username){
     Map<String,Object> claims=new HashMap<>();
  return Jwts.builder()
          .claims()
          .add(claims)

          .subject(username)
          .issuedAt(new Date(System.currentTimeMillis()))
          .expiration(new Date(System.currentTimeMillis() +30*60*1000))
          .and().signWith(getKey()).compact();



 }
 private SecretKey getKey(){
     byte[]bytes= Decoders.BASE64.decode(secret);
return Keys.hmacShaKeyFor(bytes);
 }

    public String extractUserName(String token) {
     return extractClaims(token, Claims::getSubject);
    }
    public Date extractExpiration(String token){
     return extractClaims(token,Claims::getExpiration);
    }
    private <T> T extractClaims(String token, Function<Claims,T>claimsover) {
     final Claims claims=extarctAllclaims(token);
     return claimsover.apply(claims);
    }

    private Claims extarctAllclaims(String token) {
     return Jwts.parser()
             .verifyWith(getKey())
             .build()
             .parseSignedClaims(token)
             .getPayload();

    }

    public boolean validateToken(String token, UserDetails userDetails) {
     final String username=extractUserName(token);
     return(username.equals(userDetails.getUsername())&& ! isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
     return extractExpiration(token).before(new Date());
    }
}
