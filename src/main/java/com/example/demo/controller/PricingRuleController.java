package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;

@RestController
public class PricingRuleController {

    private PricingRuleService service;

    public PricingRuleController(PricingRuleService service) {
        this.service = service;
    }

    @PostMapping("/pricing-rules/")
    public PricingRule createRule(@RequestBody PricingRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/pricing-rules/{id}")
    public PricingRule updateRule(@PathVariable Long id,@RequestBody PricingRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/pricing-rules/active")
    public List<PricingRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/pricing-rules/")
    public List<PricingRule> getAllRules() {
        return service.getAllRules();
    }
}