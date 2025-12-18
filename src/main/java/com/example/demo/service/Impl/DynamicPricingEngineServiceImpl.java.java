package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepo;
import com.example.demo.entity.StudentEntity;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService{
    // @Autowired StudentRepo student;
    // @Override
    // public StudentEntity postData(StudentEntity stu){
    //     return student.save(stu);
    // }

    @Autowired EventRecordRepository event;
    @Override
    public String existsByEventCode(String code){
        return 
    }

}
