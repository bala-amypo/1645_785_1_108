package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    List<User> getAllUsers();
    User getUserById(Long id);
}
