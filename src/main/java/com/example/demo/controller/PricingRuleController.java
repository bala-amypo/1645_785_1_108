package com.example.demo.controller;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing-rules")
@RequiredArgsConstructor
public class PricingRuleController {

    private final PricingRuleService service;

    @PostMapping
    public PricingRule createRule(@RequestBody PricingRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<PricingRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<PricingRule> getAllRules() {
        return service.getAllRules();
    }
}
