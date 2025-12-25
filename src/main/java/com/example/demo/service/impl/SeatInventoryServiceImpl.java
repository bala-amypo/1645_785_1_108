// package com.example.demo.service.impl;

// import com.example.demo.model.SeatInventoryRecord;
// import com.example.demo.repository.SeatInventoryRecordRepository;
// import com.example.demo.repository.EventRecordRepository;
// import com.example.demo.service.SeatInventoryService;
// import com.example.demo.exception.BadRequestException;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class SeatInventoryServiceImpl implements SeatInventoryService{
//     private SeatInventoryRecordRepository inventoryRepository;
//     private EventRecordRepository eventRepository;

//     public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepository,EventRecordRepository eventRepository){
//         this.inventoryRepository = inventoryRepository;
//         this.eventRepository = eventRepository;
//     }

//     @Override
//     public SeatInventoryRecord createInventory(SeatInventoryRecord inventory) {
//         Long eventId = inventory.getEvent().getId();
//         if (eventId == null) {
//             throw new BadRequestException("Event ID cannot be null");
//         }
//         if (!eventRepository.existsById(eventId)) {
//             throw new BadRequestException("Event not found");
//         }
//         if (inventory.getRemainingSeats() != null && inventory.getTotalSeats() != null && inventory.getRemainingSeats() > inventory.getTotalSeats()) {
//             throw new BadRequestException("Remaining seats cannot exceed total seats");
//         }
//         return inventoryRepository.save(inventory);
//     }

//     @Override
//     public SeatInventoryRecord updateRemainingSeats(Long eventId, Integer remainingSeats) {
//         SeatInventoryRecord inventory = inventoryRepository.findByEventId(eventId);
//         if (inventory == null) {
//             throw new BadRequestException("Seat inventory not found");
//         }
//         inventory.setRemainingSeats(remainingSeats);
//         return inventoryRepository.save(inventory);
//     }

//     @Override
//     public SeatInventoryRecord getInventoryByEvent(Long eventId) {
//         SeatInventoryRecord inventory = inventoryRepository.findByEventId(eventId);
//         if (inventory == null) {
//             throw new BadRequestException("Inventory not found");
//         }
//         return inventory;
//     }

//     @Override
//     public List<SeatInventoryRecord> getAllInventories() {
//         return inventoryRepository.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.SeatInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatInventoryServiceImpl implements SeatInventoryService {

    private final SeatInventoryRecordRepository inventoryRepository;
    private final EventRecordRepository eventRepository;

    public SeatInventoryServiceImpl(SeatInventoryRecordRepository inventoryRepository,
                                    EventRecordRepository eventRepository) {
        this.inventoryRepository = inventoryRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public SeatInventoryRecord createInventory(SeatInventoryRecord inventory) {
        if (inventory.getEvent() == null || inventory.getEvent().getId() == null) {
            throw new BadRequestException("Event ID cannot be null");
        }

        Long eventId = inventory.getEvent().getId();

        if (!eventRepository.existsById(eventId)) {
            throw new BadRequestException("Event not found");
        }

        if (inventory.getRemainingSeats() != null && inventory.getTotalSeats() != null
                && inventory.getRemainingSeats() > inventory.getTotalSeats()) {
            throw new BadRequestException("Remaining seats cannot exceed total seats");
        }

        return inventoryRepository.save(inventory);
    }

    @Override
    public SeatInventoryRecord updateRemainingSeats(Long eventId, Integer remainingSeats) {
        SeatInventoryRecord inventory = inventoryRepository.findByEvent_Id(eventId);
        if (inventory == null) {
            throw new BadRequestException("Seat inventory not found");
        }

        inventory.setRemainingSeats(remainingSeats);
        return inventoryRepository.save(inventory);
    }

    @Override
    public SeatInventoryRecord getInventoryByEvent(Long eventId) {
        SeatInventoryRecord inventory = inventoryRepository.findByEvent_Id(eventId);
        if (inventory == null) {
            throw new BadRequestException("Inventory not found");
        }
        return inventory;
    }

    @Override
    public List<SeatInventoryRecord> getAllInventories() {
        return inventoryRepository.findAll();
    }
}
