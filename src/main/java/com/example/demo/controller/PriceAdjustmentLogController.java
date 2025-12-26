package com.example.demo.controller;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.service.PriceAdjustmentLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-adjustments")
@RequiredArgsConstructor
public class PriceAdjustmentLogController {

    private final PriceAdjustmentLogService service;

    @GetMapping("/event/{eventId}")
    public List<PriceAdjustmentLog> getByEvent(@PathVariable Long eventId) {
        return service.getAdjustmentsByEvent(eventId);
    }

    @GetMapping
    public List<PriceAdjustmentLog> getAllAdjustments() {
        return service.getAllAdjustments();
    }
}
