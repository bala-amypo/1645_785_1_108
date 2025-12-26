// package com.example.demo.service;

// import com.example.demo.model.User;
// import java.util.List;

// public interface UserService {
//     User save(User user);
//     User findByEmail(String email);
//     List<User> getAllUsers();
//     User getUserById(Long id);
//     // boolean existsByEmail(String name);
// }
package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
