package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;
import com.example.demo.exception.BadRequestException;
import java.util.List;

@Service
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository eventRecordRepository;

    public EventRecordServiceImpl(EventRecordRepository eventRecordRepository) {
        this.eventRecordRepository = eventRecordRepository;
    }

    @Override
    public EventRecord createEvent(EventRecord event) {
        if (eventRecordRepository.existsByEventCode(event.getEventCode())) {
            throw new BadRequestException("Event code already exists");
        }
        return eventRecordRepository.save(event);
    }

    @Override
    public EventRecord getEventById(Long id) {
    if (id == null) throw new BadRequestException("ID cannot be null");
        return eventRecordRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Event not found"));
    }

    @Override
    public EventRecord getEventByCode(String eventCode) {
        return eventRecordRepository.findByEventCode(eventCode);
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }

    @Override
    public EventRecord updateEventStatus(Long id, boolean active) {
    if (id == null) throw new BadRequestException("ID cannot be null");
        EventRecord event = eventRecordRepository.findById(id).orElseThrow(() -> new BadRequestException("Event not found"));
        event.setActive(active);
        return eventRecordRepository.save(event);
    }
}
