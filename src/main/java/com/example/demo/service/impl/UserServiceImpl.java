package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new BadRequestException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new BadRequestException("Email Id not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        if (id == null) throw new BadRequestException("ID cannot be null");
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }
    @Override
    public boolean existsByEmail(String email){
        if(email==null) throw new BadRequestException("Email cannot be null");
        return userRepository.existByEmail(email);
    }
}

