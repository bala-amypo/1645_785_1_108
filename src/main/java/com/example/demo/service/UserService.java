package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserByUsername(String username);

    List<User> getAllUsers();

    User updateUserStatus(Long id, boolean active);
}
