// // package com.example.demo.controller;

// // import com.example.demo.dto.*;
// // import com.example.demo.model.User;
// // import com.example.demo.security.JwtTokenProvider;
// // import com.example.demo.service.UserService;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     private final UserService userService;
// //     private final PasswordEncoder passwordEncoder;
// //     private final JwtTokenProvider jwtTokenProvider;

// //     public AuthController(UserService userService,
// //                           PasswordEncoder passwordEncoder,
// //                           JwtTokenProvider jwtTokenProvider) {
// //         this.userService = userService;
// //         this.passwordEncoder = passwordEncoder;
// //         this.jwtTokenProvider = jwtTokenProvider;
// //     }

// //     @PostMapping("/register")
// //     public ResponseEntity<ApiResponse> register(@RequestBody User user) {

// //         user.setPassword(passwordEncoder.encode(user.getPassword()));
// //         if (user.getRole() == null) {
// //             user.setRole("USER");
// //         }

// //         User saved = userService.save(user);

// //         return ResponseEntity.ok(
// //                 new ApiResponse(true, "User registered successfully", saved)
// //         );
// //     }

// //     @PostMapping("/login")
// //     public ResponseEntity<?> login(@RequestBody AuthRequest request) {

// //         User user = userService.findByEmail(request.getEmail());

// //         if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
// //             return ResponseEntity.status(401)
// //                     .body(new ApiResponse(false, "Invalid email or password", null));
// //         }

// //         String token = jwtTokenProvider.generateToken(
// //                 user.getId(),
// //                 user.getEmail(),
// //                 user.getRole()
// //         );

// //         AuthResponse response = new AuthResponse(
// //                 token,
// //                 user.getId(),
// //                 user.getEmail(),
// //                 user.getRole()
// //         );

// //         return ResponseEntity.ok(
// //                 new ApiResponse(true, "Login successful", response)
// //         );
// //     }
// // }
//     // @GetMapping("/user/{email}")
//     // public ResponseEntity<User> getUserByEmail(@PathVariable String email) {

//     //     User user = userRepository.findByEmail(email)
//     //             .orElseThrow(() -> new RuntimeException("User not found"));

//     //     return ResponseEntity.ok(user);
//     // }

//     // @GetMapping("/current")
//     // public ResponseEntity<String> getCurrentUser() {

//     //     Authentication authentication =
//     //             SecurityContextHolder.getContext().getAuthentication();

//     //     String username = authentication.getName();

//     //     return ResponseEntity.ok(username);
//     // }


// package com.example.demo.controller;

// import java.util.Optional;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserRepository userRepository;

//     public AuthController(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @PostMapping("/user/register")
//     public ResponseEntity<User> createUser(@RequestBody User user) {
//         User savedUser = userRepository.save(user);
//         return ResponseEntity.ok(savedUser);
//     }

// }
package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAccountRepository userRepo;
    private final AuthenticationManager authManager;
    private final JwtUtil jwt;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        UserAccount u = userRepo.findByEmail(email).get();
        String token = jwt.generateToken(u.getUsername(), u.getId(), u.getEmail(), u.getRole());

        return Map.of("token", token);
    }
}
