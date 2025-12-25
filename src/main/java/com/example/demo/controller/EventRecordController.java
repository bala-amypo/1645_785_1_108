package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;

@RestController
public class EventRecordController {
    private EventRecordService service;
    public EventRecordController(EventRecordService service) {
        this.service = service;
    }
    @PostMapping("/events/")
    public EventRecord createEvent(@RequestBody EventRecord event) {
        return service.createEvent(event);
    }

    @GetMapping("/events/{id}")
    public EventRecord getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/events/lookup/{eventCode}")
    public EventRecord getEventByCode(@PathVariable String eventCode) {
        return service.getEventByCode(eventCode);
    }

    @GetMapping("/events/")
    public List<EventRecord> getAllEvents() {
        return service.getAllEvents();
    }

    @PutMapping("/events/{id}/status")
    public EventRecord updateEventStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateEventStatus(id, active);
    }
}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;

@RestController
public class DynamicPricingController {

    private DynamicPricingEngineService service;

    public DynamicPricingController(DynamicPricingEngineService service) {
        this.service = service;
    }

    @PostMapping("/dynamic-pricing/compute/{eventId}")
    public DynamicPriceRecord savePrice(@RequestBody DynamicPriceRecord record) {
        return service.savePrice(record);
    }

    @GetMapping("/dynamic-pricing/latest/{eventId}")
    public DynamicPriceRecord getLatestPrice(@PathVariable Long eventId) {
        return service.getLatestPrice(eventId);
    }

    @GetMapping("/dynamic-pricing/history/{eventId}")
    public List<DynamicPriceRecord> getPriceHistory(@PathVariable Long eventId) {
        return service.getPriceHistory(eventId);
    }

    @GetMapping("/dynamic-pricing/")
    public List<DynamicPriceRecord> getAllPrices() {
        return service.getAllComputedPrices();
    }
}
package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        User saved = userService.save(user);

        return ResponseEntity.ok(
                new ApiResponse(true, "User registered successfully", saved)
        );
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401)
                    .body(new ApiResponse(false, "Invalid email or password", null));
        }

        String token = jwtTokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        AuthResponse response = new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(
                new ApiResponse(true, "Login successful", response)
        );
    }
}
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9170.pro604cr.amypo.ai/")
                ));
        }
}