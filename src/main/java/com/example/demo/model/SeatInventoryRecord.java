// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import lombok.Data;
// // import lombok.AllArgsConstructor;
// // import lombok.NoArgsConstructor;

// // import java.time.LocalDateTime;
// // import jakarta.persistence.OneToOne;
// // import jakarta.persistence.JoinColumn;
// // import com.example.demo.model.EventRecord;

// // @Entity
// // @Data
// // @AllArgsConstructor
// // @NoArgsConstructor
// // public class SeatInventoryRecord {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;
// //     private Integer totalSeats;
// //     private Integer remainingSeats;
// //     private LocalDateTime updatedAt;
// //     @ManyToOne
// //     @JoinColumn(name="event_id")
// //     private EventRecord event;


// //     @PrePersist
// //     @PreUpdate
// //     protected void onUpdate() {
// //         this.updatedAt = LocalDateTime.now();
// //     }
// // }
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Table(name = "seat_inventory_record")
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class SeatInventoryRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "event_id", nullable = false)
//     private EventRecord event;

//     @Column(name = "total_seats")
//     private Integer totalSeats;

//     @Column(name = "remaining_seats")
//     private Integer remainingSeats;
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seat_inventory")
public class SeatInventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Integer totalSeats;
    private Integer remainingSeats;

    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Integer getTotalSeats() { return totalSeats; }
    public void setTotalSeats(Integer totalSeats) { this.totalSeats = totalSeats; }

    public Integer getRemainingSeats() { return remainingSeats; }
    public void setRemainingSeats(Integer remainingSeats) { this.remainingSeats = remainingSeats; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
