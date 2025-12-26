
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
// import com.example.demo.model.EventRecord;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class PriceAdjustmentLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;  
//     private Double oldPrice;
//     private Double newPrice;
//     private String reason;
//     private LocalDateTime changedAt;

//     @ManyToOne
//     @JoinColumn(name = "event_id")
//     private EventRecord event;

//     @PrePersist
//     protected void onCreate() {
//         this.changedAt = LocalDateTime.now();
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_adjustment_logs")
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Double oldPrice;
    private Double newPrice;

    private LocalDateTime changedAt;

    @PrePersist
    public void prePersist() {
        this.changedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Double getOldPrice() { return oldPrice; }
    public void setOldPrice(Double oldPrice) { this.oldPrice = oldPrice; }

    public Double getNewPrice() { return newPrice; }
    public void setNewPrice(Double newPrice) { this.newPrice = newPrice; }

    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
}
