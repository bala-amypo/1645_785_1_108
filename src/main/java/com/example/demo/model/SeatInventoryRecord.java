// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class SeatInventoryRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private Long eventId; 
//     private Integer totalSeats;
//     private Integer remainingSeats;
//     private LocalDateTime updatedAt;

//     @PrePersist
//     @PreUpdate
//     protected void onUpdate() {
//         this.updatedAt = LocalDateTime.now();
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seat_inventory_records")
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Integer totalSeats;

    private Integer availableSeats;

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private EventRecord event;
}
