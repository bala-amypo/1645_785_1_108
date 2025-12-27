// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// public class UserController {

//     private final UserService service;

//     public UserController(UserService service) {
//         this.service = service;
//     }

//     @PostMapping("/users/")
//     public User createUser(@RequestBody User user) {
//         return service.save(user);
//     }

//     @GetMapping("/users/{id}")
//     public User getUserById(@PathVariable Long id) {
//         return service.getUserById(id);
//     }

//     @GetMapping("/users/")
//     public List<User> getAllUsers() {
//         return service.getAllUsers();
//     }

//     @GetMapping("/users/email/{email}")
//     public User getUserByEmail(@PathVariable String email) {
//         return service.findByEmail(email);
//     }
// }
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
