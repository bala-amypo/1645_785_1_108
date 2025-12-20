package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;

@RestController
public class DynamicPricingController {

    private final DynamicPricingEngineService service;

    public DynamicPricingController(DynamicPricingEngineService service) {
        this.service = service;
    }

    @PostMapping("/")
    public DynamicPriceRecord savePrice(@RequestBody DynamicPriceRecord record) {
        return service.savePrice(record);
    }

    @GetMapping("/latest/{eventId}")
    public DynamicPriceRecord getLatestPrice(@PathVariable Long eventId) {
        return service.getLatestPrice(eventId);
    }

    @GetMapping("/history/{eventId}")
    public List<DynamicPriceRecord> getPriceHistory(@PathVariable Long eventId) {
        return service.getPriceHistory(eventId);
    }

    @GetMapping("/")
    public List<DynamicPriceRecord> getAllPrices() {
        return service.getAllComputedPrices();
    }
}
