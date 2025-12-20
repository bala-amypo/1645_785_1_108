// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import java.util.Date;

// @Entity
// public class EventRecord{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String eventCode;
//     private String eventName;
//     private String venue;
//     private Date eventDate;
//     private double basePrice;
//     private Date createdAt;
//     private Boolean active;

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
//     public void setEventDate(Date eventDate){
//         this.eventDate=eventDate;
//     }
//     public void setBasePrice(double basePrice){
//         this.basePrice=basePrice;
//     }
//     public void setCreatedAt(Date createdAt){
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
//     public Date getEventDate(){
//         return eventDate;
//     }
//     public Double getBasePrice(){
//         return basePrice;
//     }
//     public Date getCreatedAt(){
//         return createdAt;
//     }
//     public Boolean getActive(){
//         return active;
//     }

//     public EventRecord(){};
//     public EventRecord(Long id, String eventCode, String eventName,String venue,Date eventDate,double basePrice,Date createdAt,Boolean active){
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