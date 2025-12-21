package com.example.demo.security;
import io.jsonwebtoken.Claims;
public class JwtTokenProvider{

    public JwtTokenProvider(String secret,Long validityInMs, boolean someFlag){};

    String generateToken(Long userId, String email, String role){
        return null;
    }
    boolean validateToken(String token){
        return false;
    }
    Claims getClaimsFromToken(String token){
        return null;
    }
}