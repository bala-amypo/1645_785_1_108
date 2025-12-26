package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.service.SeatInventoryService;


@RequestMapping("/inventory")
@RestController
public class SeatInventoryController {
    private SeatInventoryService service;
    public SeatInventoryController(SeatInventoryService service){
        this.service = service;
    }
    @PostMapping("/")
    public SeatInventoryRecord createInventory(@RequestBody SeatInventoryRecord inventory){
        return service.createInventory(inventory);
    }
    @PutMapping("/{eventId}/remaining")
    public SeatInventoryRecord updateRemainingSeats(@PathVariable Long eventId,@RequestParam Integer remainingSeats){
        return service.updateRemainingSeats(eventId, remainingSeats);
    }
    @GetMapping("/event/{eventId}")
    public SeatInventoryRecord getInventoryByEvent(@PathVariable Long eventId){
        return service.getInventoryByEvent(eventId);
    }
    @GetMapping("/")
    public List<SeatInventoryRecord> getAllInventories(){
        return service.getAllInventories();
    }
}
