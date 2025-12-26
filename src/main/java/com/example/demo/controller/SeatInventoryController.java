// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;
// import com.example.demo.model.SeatInventoryRecord;
// import com.example.demo.service.SeatInventoryService;


// @RequestMapping("/inventory")
// @RestController
// public class SeatInventoryController {
//     private SeatInventoryService service;
//     public SeatInventoryController(SeatInventoryService service){
//         this.service = service;
//     }
//     @PostMapping("/")
//     public SeatInventoryRecord createInventory(@RequestBody SeatInventoryRecord inventory){
//         return service.createInventory(inventory);
//     }
//     @PutMapping("/{eventId}/remaining")
//     public SeatInventoryRecord updateRemainingSeats(@PathVariable Long eventId,@RequestParam Integer remainingSeats){
//         return service.updateRemainingSeats(eventId, remainingSeats);
//     }
//     @GetMapping("/event/{eventId}")
//     public SeatInventoryRecord getInventoryByEvent(@PathVariable Long eventId){
//         return service.getInventoryByEvent(eventId);
//     }
//     @GetMapping("/")
//     public List<SeatInventoryRecord> getAllInventories(){
//         return service.getAllInventories();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing-rules")
public class PricingRuleController {

 private final PricingRuleService service;

 public PricingRuleController(PricingRuleService service) {
  this.service = service;
 }

 @PostMapping
 public PricingRule create(@RequestBody PricingRule rule) {
  return service.createRule(rule);
 }

 @PutMapping("/{id}")
 public PricingRule update(@PathVariable Long id, @RequestBody PricingRule rule) {
  return service.updateRule(id, rule);
 }

 @GetMapping("/active")
 public List<PricingRule> getActive() {
  return service.getActiveRules();
 }

 @GetMapping("/{id}")
 public PricingRule getById(@PathVariable Long id) {
  return service.getAllRules().stream().filter(r -> r.getId().equals(id))
          .findFirst().orElseThrow();
 }

 @GetMapping
 public List<PricingRule> getAll() {
  return service.getAllRules();
 }
}
