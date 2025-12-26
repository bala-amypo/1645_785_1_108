package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUserStatus(Long id, boolean active) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(active);
        return userRepo.save(user);
    }
}
