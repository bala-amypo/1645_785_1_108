// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// import com.example.demo.model.PricingRule;
// import com.example.demo.service.PricingRuleService;

// @RestController
// public class PricingRuleController {

//     private PricingRuleService service;

//     public PricingRuleController(PricingRuleService service) {
//         this.service = service;
//     }

//     @PostMapping("/pricing-rules/")
//     public PricingRule createRule(@RequestBody PricingRule rule) {
//         return service.createRule(rule);
//     }

//     @PutMapping("/pricing-rules/{id}")
//     public PricingRule updateRule(@PathVariable Long id,@RequestBody PricingRule rule) {
//         return service.updateRule(id, rule);
//     }

//     @GetMapping("/pricing-rules/active")
//     public List<PricingRule> getActiveRules() {
//         return service.getActiveRules();
//     }

//     @GetMapping("/pricing-rules/")
//     public List<PricingRule> getAllRules() {
//         return service.getAllRules();
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
