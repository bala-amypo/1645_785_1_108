package com.example.demo.controller;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.service.SeatInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class SeatInventoryController {

    private final SeatInventoryService service;

    @PostMapping
    public SeatInventoryRecord createInventory(
            @RequestBody SeatInventoryRecord inventory) {
        return service.createInventory(inventory);
    }

    @GetMapping("/event/{eventId}")
    public SeatInventoryRecord getByEvent(@PathVariable Long eventId) {
        return service.getInventoryByEvent(eventId).orElseThrow();
    }

    @GetMapping
    public List<SeatInventoryRecord> getAllInventories() {
        return service.getAllInventories();
    }
}
