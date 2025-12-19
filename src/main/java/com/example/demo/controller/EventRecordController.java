package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;

@RestController
public class EventRecordController{
    @Autowired EventRecordService ser;

    @PostMapping("/post")
    public EventRecord sendData(@RequestBody EventRecord stu){
        return ser.postData(stu);
    }
    @GetMapping("/get")
    public List<EventRecord> getData(){
        return ser.getAllData(stu);
    }
}