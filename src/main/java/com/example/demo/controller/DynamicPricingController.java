// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// import com.example.demo.model.DynamicPriceRecord;
// import com.example.demo.service.DynamicPricingEngineService;

// @RestController
// public class DynamicPricingController {

//     private DynamicPricingEngineService service;

//     public DynamicPricingController(DynamicPricingEngineService service) {
//         this.service = service;
//     }

//     @PostMapping("/dynamic-pricing/compute/{eventId}")
//     public DynamicPriceRecord savePrice(@RequestBody DynamicPriceRecord record) {
//         return service.savePrice(record);
//     }

//     @GetMapping("/dynamic-pricing/latest/{eventId}")
//     public DynamicPriceRecord getLatestPrice(@PathVariable Long eventId) {
//         return service.getLatestPrice(eventId);
//     }

//     @GetMapping("/dynamic-pricing/history/{eventId}")
//     public List<DynamicPriceRecord> getPriceHistory(@PathVariable Long eventId) {
//         return service.getPriceHistory(eventId);
//     }

//     @GetMapping("/dynamic-pricing/")
//     public List<DynamicPriceRecord> getAllPrices() {
//         return service.getAllComputedPrices();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
public class DynamicPricingController {

    private final DynamicPricingEngineService service;

    public DynamicPricingController(DynamicPricingEngineService service) {
        this.service = service;
    }

    @PostMapping("/{eventId}/compute")
    public ResponseEntity<DynamicPriceRecord> compute(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.computeDynamicPrice(eventId));
    }

    @GetMapping("/{eventId}/latest")
    public ResponseEntity<DynamicPriceRecord> latest(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.getLatestPrice(eventId));
    }

    @GetMapping("/{eventId}/history")
    public ResponseEntity<List<DynamicPriceRecord>> history(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.getPriceHistory(eventId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DynamicPriceRecord>> all() {
        return ResponseEntity.ok(service.getAllComputedPrices());
    }
}
