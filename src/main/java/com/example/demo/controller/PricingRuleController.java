package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;

@RestController
@RequestMapping("/api/pricing-rules")
public class PricingRuleController {

    private final PricingRuleService service;

    public PricingRuleController(PricingRuleService service) {
        this.service = service;
    }

    @PostMapping("/")
    public PricingRule createRule(@RequestBody PricingRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public PricingRule updateRule(@PathVariable Long id,@RequestBody PricingRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<PricingRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/")
    public List<PricingRule> getAllRules() {
        return service.getAllRules();
    }
}