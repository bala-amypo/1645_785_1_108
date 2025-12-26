package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pricing_rules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleCode;

    private String description;

    private Integer minRemainingSeats;
    private Integer maxRemainingSeats;

    // number of days before event when rule applies
    private Integer daysBeforeEvent;

    private Double priceMultiplier;

    private Boolean active;
}
