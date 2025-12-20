package com.example.demo.service.impl;

import com.example.demo.model.PricingRule;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.service.PricingRuleService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    private final PricingRuleRepository ruleRepository;

    public PricingRuleServiceImpl(PricingRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public PricingRule createRule(PricingRule rule) {
        if (ruleRepository.existsByRuleCode(rule.getRuleCode())) {
            throw new BadRequestException("Rule code already exists");
        }
        if (rule.getPriceMultiplier() != null && rule.getPriceMultiplier() <= 0) {
            throw new BadRequestException("Price multiplier must be > 0");
        }
        return ruleRepository.save(rule);
    }

    @Override
    public PricingRule updateRule(Long id, PricingRule updatedRule) {
    if (id == null) throw new BadRequestException("ID cannot be null");
        PricingRule rule = ruleRepository.findById(id).orElseThrow(() -> new BadRequestException("Rule not found"));

        rule.setDescription(updatedRule.getDescription());
        rule.setMinRemainingSeats(updatedRule.getMinRemainingSeats());
        rule.setMaxRemainingSeats(updatedRule.getMaxRemainingSeats());
        rule.setDaysBeforeEvent(updatedRule.getDaysBeforeEvent());
        rule.setPriceMultiplier(updatedRule.getPriceMultiplier());
        rule.setActive(updatedRule.getActive());

        return ruleRepository.save(rule);
    }

    @Override
    public PricingRule getRuleByCode(String ruleCode) {
        return ruleRepository.findByRuleCode(ruleCode).orElseThrow(() -> new BadRequestException("Rule not found"));
    }


    @Override
    public List<PricingRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }

    @Override
    public List<PricingRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
