package com.sebastian.portfolio.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${jwt_secret}")
    private String jwtSecret;
    @Value("${jwt_expiration_ms}")
    private int jwtExpirationMs;

    public String generateJwt(Authentication authentication) {
        UserDetailsImplementation userPrincipal = (UserDetailsImplementation) authentication.getPrincipal();
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(userPrincipal.getUsername());
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(new Date().getTime() + jwtExpirationMs));
        builder.signWith(SignatureAlgorithm.HS512, jwtSecret);
        return builder.compact();
    }

    public String getUsernameFromJwt(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwt(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception ex){
            System.out.println("Error validating JWT: " + ex.getMessage());
        }
        return false;
    }
}
