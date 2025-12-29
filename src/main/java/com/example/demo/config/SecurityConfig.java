// // package com.example.demo.config;

// // import com.example.demo.security.*;
// // import org.springframework.context.annotation.*;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.web.SecurityFilterChain;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.http.SessionCreationPolicy;

// // @Configuration
// // public class SecurityConfig {

// //     @Bean
// //     public JwtTokenProvider jwtTokenProvider() {
// //         return new JwtTokenProvider("secret", 86400000, true);
// //     }

// //     @Bean
// //     public JwtAuthenticationFilter jwtFilter(JwtTokenProvider p, CustomUserDetailsService uds) {
// //         return new JwtAuthenticationFilter(p, uds);
// //     }

// //     @Bean
// //     public PasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }

// // @Bean
// // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// //     http
// //         .csrf(csrf -> csrf.disable())
// //         .authorizeHttpRequests(auth -> auth
// //             .requestMatchers(
// //                 "/auth/register",
// //                 "/auth/login",
// //                 "/v3/api-docs/**",
// //                 "/swagger-ui/**",
// //                 "/swagger-ui.html"
// //             ).permitAll()
// //             .anyRequest().authenticated()
// //         );

// //     return http.build();
// // }
// // }

// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// class PasswordConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
    
// }
package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.CustomUserDetailsService;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtTokenProvider provider,
                                                           CustomUserDetailsService uds) {
        return new JwtAuthenticationFilter(provider, uds);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                    .requestMatchers("/api/**").authenticated()
                    .anyRequest().permitAll()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
