package com.example.demo.security;
// import io.jsonwebtoken.Claims;
public class JwtTokenProvider{

    public JwtTokenProvider(String secret,Long validityInMs, boolean someFlag){};

    public String generateToken(Long userId, String email, String role){
        return null;
    }
    public boolean validateToken(String token){
        return false;
    }
    // public Claims getClaimsFromToken(String token);
}