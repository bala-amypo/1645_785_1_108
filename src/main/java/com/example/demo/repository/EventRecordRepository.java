package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.EventRecord;

@Repository
public interface EventRecordRecordRepository extends JpaRepository<EventRecord,Integer>{

}