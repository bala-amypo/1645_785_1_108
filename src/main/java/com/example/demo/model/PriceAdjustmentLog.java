
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
// public class PriceAdjustmentLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private Long eventId;     
//     private Double oldPrice;
//     private Double newPrice;
//     private String reason;
//     private LocalDateTime changedAt;

//     @PrePersist
//     protected void onCreate() {
//         this.changedAt = LocalDateTime.now();
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price_adjustment_logs")
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Double oldPrice;

    private Double newPrice;

    private String ruleApplied;

    private LocalDateTime adjustedAt;

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private EventRecord event;
}
