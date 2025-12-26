package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User createUser(User user) {

        if (repository.existsByUsername(user.getUsername())) {
            throw new BadRequestException("Username already exists");
        }

        if (user.getActive() == null) {
            user.setActive(true);
        }

        return repository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUserStatus(Long id, boolean active) {
        User user = repository.findById(id).orElseThrow();
        user.setActive(active);
        return repository.save(user);
    }
}
