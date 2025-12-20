// package com.example.demo.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.demo.service.EventRecordService;
// import com.example.demo.repository.EventRecordRepository;
// import com.example.demo.model.EventRecord;
// import java.util.*;

// @Service
// public class EventRecordServiceImpl implements EventRecordService{
//     @Autowired EventRecordRepository eventR;
//     @Override
//     public EventRecord postData(EventRecord eve){
//         return eventR.save(eve);
//     }
//     @Override
//     public List<EventRecord>getAllData(){
//         return eventR.findAll();
//     }
// }