package com.example.demo.service;

import com.example.demo.model.DynamicPriceRecord;

import java.util.List;
import java.util.Optional;

public interface DynamicPriceService {

    DynamicPriceRecord savePrice(DynamicPriceRecord record);

    Optional<DynamicPriceRecord> getLatestPrice(Long eventId);

    List<DynamicPriceRecord> getPriceHistory(Long eventId);
}
