package com.example.demo.controller;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dynamic-prices")
@RequiredArgsConstructor
public class DynamicPriceController {

    private final DynamicPriceService service;

    @GetMapping("/event/{eventId}/latest")
    public DynamicPriceRecord getLatestPrice(@PathVariable Long eventId) {
        return service.getLatestPrice(eventId).orElseThrow();
    }

    @GetMapping("/event/{eventId}")
    public List<DynamicPriceRecord> getPriceHistory(@PathVariable Long eventId) {
        return service.getPriceHistory(eventId);
    }
}
