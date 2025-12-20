package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;
    private Integer minRemainingSeats;
    private Integer maxRemainingSeats;
    private Integer daysBeforeEvent;
    private Double priceMultiplier;
    private Boolean active= true;
}