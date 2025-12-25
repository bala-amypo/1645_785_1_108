// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Column;
// import jakarta.validation.constraints.Positive;

// import jakarta.persistence.OneToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.CascadeType;
// import com.example.demo.model.SeatInventoryRecord;
// import com.example.demo.model.DynamicPriceRecord;
// import com.example.demo.model.PriceAdjustmentLog;
// import java.util.*;

// @Entity
// public class EventRecord{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique=true)
//     private String eventCode;
//     private String eventName;
//     private String venue;
//     private LocalDate eventDate;
//     @Positive
//     private double basePrice;
//     private LocalDateTime createdAt;
//     private Boolean active=true;

//     @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
//     private SeatInventoryRecord seatInventory;

//     @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//     private List<DynamicPriceRecord> priceRecords;

//     @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//     private List<PriceAdjustmentLog> adjustmentLogs;
    
//     @PrePersist
//     public void OnCreate(){
//         LocalDateTime now= LocalDateTime.now();
//         this.createdAt=now;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public void setEventCode(String eventCode){
//         this.eventCode=eventCode;
//     }
//     public void setEventName(String eventName){
//         this.eventName=eventName;
//     }
//     public void setVenue(String venue){
//         this.venue=venue;
//     }
//     public void setEventDate(LocalDate eventDate){
//         this.eventDate=eventDate;
//     }
//     public void setBasePrice(double basePrice){
//         this.basePrice=basePrice;
//     }
//     public void setCreatedAt(LocalDateTime createdAt){
//         this.createdAt=createdAt;
//     }
//     public void setActive(Boolean active){
//         this.active=active;
//     }

//     public Long getId(){
//         return id;
//     }
//     public String getEventCode(){
//         return eventCode;
//     }
//     public String getEventName(){
//         return eventName;
//     }
//     public String getVenue(){
//         return venue;
//     }
//     public LocalDate getEventDate(){
//         return eventDate;
//     }
//     public Double getBasePrice(){
//         return basePrice;
//     }
//     public LocalDateTime getCreatedAt(){
//         return createdAt;
//     }
//     public Boolean getActive(){
//         return active;
//     }

//     public EventRecord(){};
//     public EventRecord(Long id, String eventCode, String eventName,String venue,LocalDate eventDate,double basePrice,LocalDateTime createdAt,Boolean active){
//         this.id=id;
//         this.eventCode=eventCode;
//         this.eventName=eventName;
//         this.venue=venue;
//         this.eventDate=eventDate;
//         this.basePrice=basePrice;
//         this.createdAt=createdAt;
//         this.active=active;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "event_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String eventCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private LocalDateTime eventDateTime;

    @Column(nullable = false)
    private int totalSeats;

    @Column(nullable = false)
    private int availableSeats;

    @Column(nullable = false)
    private double basePrice;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DynamicPriceRecord> priceHistory;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    @Column(nullable = false)
    private boolean active = true;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
