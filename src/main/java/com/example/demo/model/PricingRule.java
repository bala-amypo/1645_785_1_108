// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import jakarta.validation.constraints.Positive;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class PricingRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique=true)
//     private String ruleCode;
//     private String description;
//     private Integer minRemainingSeats;
//     private Integer maxRemainingSeats;
//     private Integer daysBeforeEvent;
//     @Positive
//     private Double priceMultiplier;
//     private Boolean active= true;
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pricing_rules")
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String conditionExpression;

    private Double adjustmentPercentage;

    private Boolean active;
}
