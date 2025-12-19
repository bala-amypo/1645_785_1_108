package com.example.demo.service;

import com.example.demo.model.EventRecord;
import java.util.*;

public interface EventRecordService{
    EventRecord postData(EventRecord eve);
    public List<EventRecord>getAllData();
}