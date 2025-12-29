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

import com.example.demo.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    private final JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/auth/**","/v3/api-docs/**","/swagger-ui/**","/swagger-ui.html").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(entryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
