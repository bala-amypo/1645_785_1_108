// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import jakarta.validation.constraints.Positive;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class DynamicPriceRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long eventId;
//     @Positive
//     private double computedPrice;
//     private String appliedRuleCodes;
//     private LocalDateTime computedAt;

//     @PrePersist
//     protected void onCreate() {
//         this.computedAt = LocalDateTime.now();
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
@Table(name = "dynamic_price_records")
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Double computedPrice;

    private String reason;

    private LocalDateTime computedAt;

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    private EventRecord event;
}
