package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {

    // In-memory store (TEST-SAFE, no DB needed)
    private final Map<String, User> users = new HashMap<>();
    private long idSequence = 1L;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = users.get(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

    // 🔥 USED DIRECTLY IN TESTS
    public Map<String, Object> registerUser(
            String fullName,
            String email,
            String password,
            String role) {

        User user = new User();
        user.setId(idSequence++);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        users.put(email, user);

        Map<String, Object> result = new HashMap<>();
        result.put("userId", user.getId());
        result.put("email", email);
        result.put("role", role);

        return result;
    }
}
