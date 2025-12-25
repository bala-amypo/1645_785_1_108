package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import com.example.demo.model.EventRecord;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId; 
    private Integer totalSeats;
    private Integer remainingSeats;
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "event_id")
    private EventRecord event;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
