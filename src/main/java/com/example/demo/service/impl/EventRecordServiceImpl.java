package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.EventRecordService;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.entity.StudentEntity;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService{
    @Autowired StudentRepo student;
    @Override
    public StudentEntity postData(StudentEntity stu){
        return student.save(stu);
    }
}