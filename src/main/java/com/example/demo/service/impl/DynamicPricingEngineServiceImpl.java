package com.example.demo.service.impl;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.repository.DynamicPricingRecordRepository;
import com.example.demo.service.DynamicPricingEngineService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService {

    private final DynamicPricingRecordRepository priceRepository;

    public DynamicPricingEngineServiceImpl(DynamicPricingRecordRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public DynamicPriceRecord savePrice(DynamicPriceRecord record) {
        if ( record.getComputedPrice() <= 0) {
            throw new BadRequestException("Computed price must be > 0");
        }
        return priceRepository.save(record);
    }

    @Override
    public List<DynamicPriceRecord> getPriceHistory(Long eventId) {
        return priceRepository.findByEventIdOrderByComputedAtDesc(eventId);
    }

    @Override
    public DynamicPriceRecord getLatestPrice(Long eventId) {
        return priceRepository.findFirstByEventIdOrderByComputedAtDesc(eventId);

    }

    @Override
    public List<DynamicPriceRecord> getAllComputedPrices() {
        return priceRepository.findAll();
    }
}
