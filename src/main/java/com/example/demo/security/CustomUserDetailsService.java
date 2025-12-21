package com.example.demo.security;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import java.util.*;
public class CustomUserDetailsService implements UserService{
    private UserRepository userRepository;

    public User loadUserByUsername(String email);
    public Map<String,User> registerUser(String fullName, String email, String password, String role);
}