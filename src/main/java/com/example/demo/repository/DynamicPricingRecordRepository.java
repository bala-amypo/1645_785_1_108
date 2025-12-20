package com.example.demo.repository;

import com.example.demo.model.DynamicPriceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicPricingRecordRepository extends JpaRepository<DynamicPriceRecord, Long> {

    List<DynamicPriceRecord> findByEventIdOrderByComputedAtDesc(Long eventId);

    DynamicPriceRecord findFirstByEventIdOrderByComputedAtDesc(Long eventId);
}
