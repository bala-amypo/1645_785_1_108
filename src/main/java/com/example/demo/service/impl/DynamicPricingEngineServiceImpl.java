package com.example.demo.service.impl;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.repository.DynamicPricingRecordRepository;
import com.example.demo.service.DynamicPricingEngineService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;
import com.example.demo.entity.PricingRule;
import java.util.List;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService {

    private DynamicPricingRecordRepository priceRepository;

    public DynamicPricingEngineServiceImpl(DynamicPricingRecordRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
@Override
public Double calculatePriceWithRules(Double basePrice, int remainingSeats, int daysBeforeEvent, List<PricingRule> rules) {
    for (PricingRule rule : rules) {
        if (rule.getActive()
            && remainingSeats >= rule.getMinRemainingSeats()
            && remainingSeats <= rule.getMaxRemainingSeats()
            && daysBeforeEvent <= rule.getDaysBeforeEvent()) {
            return basePrice * rule.getPriceMultiplier();
        }
    }
    return basePrice; 
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
