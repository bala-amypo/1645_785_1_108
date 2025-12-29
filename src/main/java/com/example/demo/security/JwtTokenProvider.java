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
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenProvider {

    private final String jwtSecret = "mySecretKeymySecretKeymySecretKeymySecretKey"; // min 32 chars
    private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

    public Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
