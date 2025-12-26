// package com.example.demo.config;

// import com.example.demo.security.*;
// import org.springframework.context.annotation.*;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public JwtTokenProvider jwtTokenProvider() {
//         return new JwtTokenProvider("secret", 86400000, true);
//     }

//     @Bean
//     public JwtAuthenticationFilter jwtFilter(JwtTokenProvider p, CustomUserDetailsService uds) {
//         return new JwtAuthenticationFilter(p, uds);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     http
//         .csrf(csrf -> csrf.disable())
//         .authorizeHttpRequests(auth -> auth
//             .requestMatchers(
//                 "/auth/register",
//                 "/auth/login",
//                 "/v3/api-docs/**",
//                 "/swagger-ui/**",
//                 "/swagger-ui.html"
//             ).permitAll()
//             .anyRequest().authenticated()
//         );

//     return http.build();
// }

// }
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(
                session -> session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}

