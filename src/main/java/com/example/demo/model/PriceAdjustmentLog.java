
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId;     
    private Double oldPrice;
    private Double newPrice;
    private String reason;
    private LocalDateTime changedAt;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventRecord event;
    
    @PrePersist
    protected void onCreate() {
        this.changedAt = LocalDateTime.now();
    }
}
