// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.security.core.Authentication;

// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// public class JwtTokenProvider {

//     private final Key key;
//     private final long validityInMs;
//     private final boolean enabled;

//     public JwtTokenProvider(String secretKey, long validityInMs, boolean enabled) {
//         this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
//         this.validityInMs = validityInMs;
//         this.enabled = enabled;
//     }

//     public JwtTokenProvider() {
//         this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//         this.validityInMs = 3600000L;
//         this.enabled = true;
//     }

//     public String generateToken(Authentication authentication,Long userId, String role) {
//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setSubject(authentication.getName())
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .claim("email", authentication.getName())
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public String getUsernameFromToken(String token) {
//         return parseClaims(token).getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             parseClaims(token);
//             return true;
//         } catch (Exception ex) {
//             return false;
//         }
//     }

//     public Map<String, Object> getAllClaims(String token) {
//         Claims claims = parseClaims(token);
//         Map<String, Object> map = new HashMap<>();
//         map.putAll(claims);
//         return map;
//     }

//     private Claims parseClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @Component
// public class JwtTokenProvider {

//     private final String secret;
//     private final long validityInMs;
//     private final boolean enabled;

//     public JwtTokenProvider(String secret, long validityInMs, boolean enabled) {
//         this.secret = secret;
//         this.validityInMs = validityInMs;
//         this.enabled = enabled;
//     }

//     public String generateToken(Authentication auth, Long userId, String role) {

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", userId);
//         claims.put("role", role);
//         claims.put("email", auth.getName());

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(auth.getName())
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             if (!enabled) return true;
//             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//             return true;
//         } catch (Exception ex) {
//             return false;
//         }
//     }

//     public String getUsernameFromToken(String token) {
//         return getAllClaims(token).get("email").toString();
//     }

//     public Map<String, Object> getAllClaims(String token) {
//         Claims claims = Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//         return new HashMap<>(claims);
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
