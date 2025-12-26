package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class JwtTokenProvider {

    private final Key key;
    private final long validityInMs;
    private final boolean someFlag;

    // 🔥 REQUIRED constructor (used directly in tests)
    public JwtTokenProvider(String secret, long validityInMs, boolean someFlag) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
        this.someFlag = someFlag;
    }

    // 🔥 USED IN TESTS
    public String generateToken(Authentication authentication, Long userId, String role) {

        String email = authentication.getName();
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔥 USED IN TESTS
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    // 🔥 USED IN TESTS
    public String getUsernameFromToken(String token) {
        return getAllClaims(token).getSubject();
    }

    // 🔥 USED IN TESTS
    public Map<String, Object> getAllClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return new HashMap<>(claims);
    }
}
