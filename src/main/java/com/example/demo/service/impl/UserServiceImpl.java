package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }
}
