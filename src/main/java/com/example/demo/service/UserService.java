// package com.example.demo.service;

// import java.util.Optional;
// import com.example.demo.model.User;

// public interface UserService {
//     Optional<User> findByEmail(String email);
//     boolean existsByEmail(String email);
// }
package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.model.User;

public interface UserService {

    User save(User user);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
