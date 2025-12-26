package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_adjustment_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Logical link to EventRecord
    @Column(nullable = false)
    private Long eventId;

    private Double oldPrice;
    private Double newPrice;

    private String reason;

    private LocalDateTime changedAt;

    @PrePersist
    public void prePersist() {
        this.changedAt = LocalDateTime.now();
    }
}
