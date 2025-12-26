package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}/status")
    public User updateUserStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateUserStatus(id, active);
    }
}
