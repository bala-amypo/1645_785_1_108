package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dynamic_price_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Logical link to EventRecord
    @Column(nullable = false)
    private Long eventId;

    private Double computedPrice;

    // comma-separated rule codes applied
    private String appliedRuleCodes;

    private LocalDateTime computedAt;

    @PrePersist
    public void prePersist() {
        this.computedAt = LocalDateTime.now();
    }
}
