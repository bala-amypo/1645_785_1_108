package com.example.demo.service;
import com.example.demo.model.PricingRule;
import com.example.demo.model.DynamicPriceRecord;
import java.util.List;

public interface DynamicPricingEngineService {    
    Double calculatePriceWithRules(Double basePrice, int remainingSeats, int daysBeforeEvent, List<PricingRule> rules);
    DynamicPriceRecord savePrice(DynamicPriceRecord record);
    List<DynamicPriceRecord> getPriceHistory(Long eventId);
    DynamicPriceRecord getLatestPrice(Long eventId);
    List<DynamicPriceRecord> getAllComputedPrices();
}
