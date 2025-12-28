package com.example.demo.controller;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/api/pricing")
@SecurityRequirement(name = "bearerAuth")
public class DynamicPricingController {
    
    private final DynamicPricingEngineService service;

    public DynamicPricingController(DynamicPricingEngineService service) {
        this.service = service;
    }

    @PostMapping("/{eventId}/compute")
    public ResponseEntity<DynamicPriceRecord> compute(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.computeDynamicPrice(eventId));
    }

    @GetMapping("/{eventId}/latest")
    public ResponseEntity<DynamicPriceRecord> latest(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.getLatestPrice(eventId));
    }

    @GetMapping("/{eventId}/history")
    public ResponseEntity<List<DynamicPriceRecord>> history(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.getPriceHistory(eventId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DynamicPriceRecord>> all() {
        return ResponseEntity.ok(service.getAllComputedPrices());
    }
}
