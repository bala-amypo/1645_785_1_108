package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRecordController {

    private final EventRecordService service;

    public EventRecordController(EventRecordService service) {
        this.service = service;
    }

    @PostMapping
    public EventRecord createEvent(@RequestBody EventRecord event) {
        return service.createEvent(event);
    }

    @GetMapping("/{id}")
    public EventRecord getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/lookup/{eventCode}")
    public EventRecord getEventByCode(@PathVariable String eventCode) {
        return service.getEventByCode(eventCode).orElseThrow();
    }

    @GetMapping
    public List<EventRecord> getAllEvents() {
        return service.getAllEvents();
    }

    @PutMapping("/{id}/status")
    public EventRecord updateEventStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateEventStatus(id, active);
    }
}
