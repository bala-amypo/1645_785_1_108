package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.SeatInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRecordRepository inventoryRepository;
    private final EventRecordRepository eventRepository;

    @Override
    public SeatInventoryRecord createInventory(SeatInventoryRecord inventory) {

        // Ensure event exists
        eventRepository.findById(inventory.getEventId()).orElseThrow();

        if (inventory.getRemainingSeats() > inventory.getTotalSeats()) {
            throw new BadRequestException(
                "Remaining seats cannot exceed total seats"
            );
        }
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<SeatInventoryRecord> getInventoryByEvent(Long eventId) {
        return inventoryRepository.findByEventId(eventId);
    }

    @Override
    public List<SeatInventoryRecord> getAllInventories() {
        return inventoryRepository.findAll();
    }
}
