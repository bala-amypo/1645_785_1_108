package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PricingRule;

@Repository
public interface PricingRuleRepository extends JpaRepository<PricingRule,Integer>{

}