// package com.example.demo.security;

// import jakarta.servlet.*;
// import jakarta.servlet.http.*;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.*;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;
// import java.io.IOException;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtTokenProvider jwtProvider;
//     private final CustomUserDetailsService userDetailsService;

//     public JwtAuthenticationFilter(JwtTokenProvider jwtProvider, CustomUserDetailsService uds) {
//         this.jwtProvider = jwtProvider;
//         this.userDetailsService = uds;
//     }

//     @Override
//     protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//             throws ServletException, IOException {

//         String header = req.getHeader("Authorization");
//         if (header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);
//             if (jwtProvider.validateToken(token)) {
//                 String email = jwtProvider.getClaimsFromToken(token).getSubject();
//                 var userDetails = userDetailsService.loadUserByUsername(email);

//                 UsernamePasswordAuthenticationToken auth =
//                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

//                 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
//                 SecurityContextHolder.getContext().setAuthentication(auth);
//             }
//         }
//         chain.doFilter(req, res);
//     }
// }
// // package com.example.demo.security;

// // import jakarta.servlet.FilterChain;
// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.stereotype.Component;
// // import org.springframework.web.filter.OncePerRequestFilter;

// // import java.io.IOException;
// // import java.util.Collections;

// // @Component
// // public class JwtAuthenticationFilter extends OncePerRequestFilter {

// //     private final JwtTokenProvider jwtTokenProvider;

// //     public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
// //         this.jwtTokenProvider = jwtTokenProvider;
// //     }

// //     @Override
// //     protected void doFilterInternal(HttpServletRequest request,
// //                                     HttpServletResponse response,
// //                                     FilterChain filterChain)
// //             throws ServletException, IOException {

// //         String header = request.getHeader("Authorization");

// //         if (header != null && header.startsWith("Bearer ")) {
// //             String token = header.substring(7);

// //             if (jwtTokenProvider.validateToken(token)) {
// //                 String username = jwtTokenProvider.getUsernameFromToken(token);
// //                 UsernamePasswordAuthenticationToken auth =
// //                         new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
// //                 SecurityContextHolder.getContext().setAuthentication(auth);
// //             }
// //         }

// //         filterChain.doFilter(request, response);
// //     }
// // }
package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtProvider;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtProvider, CustomUserDetailsService uds) {
        this.jwtProvider = jwtProvider;
        this.userDetailsService = uds;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        String header = req.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            if (jwtProvider.validateToken(token)) {
                String email = jwtProvider.getClaimsFromToken(token).getSubject();
                var userDetails = userDetailsService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(req, res);
    }
}
