// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import lombok.Data;
// // import lombok.AllArgsConstructor;
// // import lombok.NoArgsConstructor;
// // import jakarta.validation.constraints.Positive;

// // import java.time.LocalDateTime;

// // import jakarta.persistence.ManyToOne;
// // import jakarta.persistence.JoinColumn;
// // import com.example.demo.model.EventRecord;

// // @Entity
// // @Data
// // @AllArgsConstructor
// // @NoArgsConstructor
// // public class DynamicPriceRecord {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;
// //     @Positive
// //     private double computedPrice;
// //     private String appliedRuleCodes;
// //     private LocalDateTime computedAt;

// //     @ManyToOne
// //     @JoinColumn(name = "event_id")
// //     private EventRecord event;

// //     @PrePersist
// //     protected void onCreate() {
// //         this.computedAt = LocalDateTime.now();
// //     }
// // }
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// @Entity
// @Table(name = "dynamic_price_record")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class DynamicPriceRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private double computedPrice;
//     @Column(name = "calculated_at")
//     private LocalDateTime calculatedAt;

// @ManyToOne
// @JoinColumn(name = "event_id", nullable = false)
// @JsonBackReference
// private EventRecord event;

// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dynamic_price_records")
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Double computedPrice;
    private String appliedRuleCodes;

    private LocalDateTime computedAt;

    @PrePersist
    public void prePersist() {
        computedAt = LocalDateTime.now();
    }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Double getComputedPrice() { return computedPrice; }
    public void setComputedPrice(Double computedPrice) { this.computedPrice = computedPrice; }

    public String getAppliedRuleCodes() { return appliedRuleCodes; }
    public void setAppliedRuleCodes(String appliedRuleCodes) { this.appliedRuleCodes = appliedRuleCodes; }

    public LocalDateTime getComputedAt() { return computedAt; }
    public void setComputedAt(LocalDateTime computedAt) { this.computedAt = computedAt; }
}
