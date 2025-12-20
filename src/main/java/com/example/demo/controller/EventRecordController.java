package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;

@RestController
public class EventRecordController {
    private final EventRecordService service;
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
