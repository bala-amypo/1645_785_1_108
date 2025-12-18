package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class StudentEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String eventCode;
    private String eventName;
    private String venue;
    private Date eventDate;
    private double basePrice;
    private Date createdAt;
    private Boolean active;

    public void setId(Long id){
        this.id=id;
    }
    public void setEventCode(String eventCode){
        this.eventCode=eventCode;
    }
    public void setEventName(String eventName){
        this.eventName=eventName;
    }
    public void setVenue(String venue){
        this.venue=venue;
    }
    public void setEventDate(Date eventDate){
        this.eventDate=eventDate;
    }
    public void setBasePrice(double basePrice){
        this.basePrice=basePrice;
    }
    public void setCreatedAt(Date createdAt){
        this.created=created;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Date getCreated(){
        return created;
    }

    public StudentEntity(){};
    public StudentEntity(Integer id, String name, String username, String password, Date created){
        this.id=id;
        this.name=name;
        this.username=username;
        this.password=password;
        this.created=created;
    }
}