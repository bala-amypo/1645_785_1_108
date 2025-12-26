// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import jakarta.validation.constraints.Positive;

// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
// import com.example.demo.model.EventRecord;

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
//     @ManyToOne
//     @JoinColumn(name = "event_id")
//     private EventRecord event;
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;

    private Integer daysBeforeEvent;
    private Integer minRemainingSeats;
    private Integer maxRemainingSeats;

    private Double priceMultiplier;
    private Boolean active;
}
