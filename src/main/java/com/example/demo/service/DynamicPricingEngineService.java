package com.example.demo.service;
import com.example.demo.model.
import com.example.demo.model.DynamicPriceRecord;
import java.util.List;

public interface DynamicPricingEngineService {
    DynamicPriceRecord savePrice(DynamicPriceRecord record);
    List<DynamicPriceRecord> getPriceHistory(Long eventId);
    DynamicPriceRecord getLatestPrice(Long eventId);
    List<DynamicPriceRecord> getAllComputedPrices();
    Double calculatePriceWithRules(Double basePrice, int remainingSeats, int daysBeforeEvent, List<PricingRule> rules);
}
