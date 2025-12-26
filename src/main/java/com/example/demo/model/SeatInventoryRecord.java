package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seat_inventory_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Linked logically (no JPA relationship)
    @Column(nullable = false)
    private Long eventId;

    private Integer totalSeats;
    private Integer remainingSeats;

    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
