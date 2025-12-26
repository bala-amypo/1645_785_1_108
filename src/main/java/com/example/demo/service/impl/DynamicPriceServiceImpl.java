package com.example.demo.service.impl;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.repository.DynamicPriceRecordRepository;
import com.example.demo.service.DynamicPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DynamicPriceServiceImpl implements DynamicPriceService {

    private final DynamicPriceRecordRepository repository;

    @Override
    public DynamicPriceRecord savePrice(DynamicPriceRecord record) {
        return repository.save(record);
    }

    @Override
    public Optional<DynamicPriceRecord> getLatestPrice(Long eventId) {
        return repository.findFirstByEventIdOrderByComputedAtDesc(eventId);
    }

    @Override
    public List<DynamicPriceRecord> getPriceHistory(Long eventId) {
        return repository.findByEventIdOrderByComputedAtDesc(eventId);
    }
}
