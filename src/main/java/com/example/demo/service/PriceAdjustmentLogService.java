package com.example.demo.service;

import com.example.demo.model.PriceAdjustmentLog;
import java.util.List;

public interface PriceAdjustmentLogService {

    PriceAdjustmentLog logAdjustment(PriceAdjustmentLog log);

    List<PriceAdjustmentLog> getAdjustmentsByEvent(Long eventId);

    List<PriceAdjustmentLog> getAllAdjustments();
}
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.repository.PriceAdjustmentLogRepository;
import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceAdjustmentLogServiceImpl implements PriceAdjustmentLogService {

    private final PriceAdjustmentLogRepository logRepository;

    public PriceAdjustmentLogServiceImpl(PriceAdjustmentLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public PriceAdjustmentLog logAdjustment(PriceAdjustmentLog log) {
    if (log == null) throw new BadRequestException("ID cannot be null");
        return logRepository.save(log);
    }

    @Override
    public List<PriceAdjustmentLog> getAdjustmentsByEvent(Long eventId) {
        return logRepository.findByEventId(eventId);
    }

    @Override
    public List<PriceAdjustmentLog> getAllAdjustments() {
        return logRepository.findAll();
    }
}
package com.example.demo.repository;

import com.example.demo.model.PriceAdjustmentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceAdjustmentLogRepository extends JpaRepository<PriceAdjustmentLog, Long> {

    List<PriceAdjustmentLog> findByEventId(Long eventId);
}
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "price_adjustment_logs")
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;     // foreign key to EventRecord
    private Double oldPrice;
    private Double newPrice;
    private String reason;
    private LocalDateTime changedAt;

    @PrePersist
    protected void onCreate() {
        this.changedAt = LocalDateTime.now();
    }
}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.service.PriceAdjustmentLogService;

@RestController
@RequestMapping("/api/price-adjustments")
public class PriceAdjustmentLogController {

    private final PriceAdjustmentLogService service;

    public PriceAdjustmentLogController(PriceAdjustmentLogService service) {
        this.service = service;
    }

    @PostMapping("/")
    public PriceAdjustmentLog logAdjustment(@RequestBody PriceAdjustmentLog log) {
        return service.logAdjustment(log);
    }

    @GetMapping("/event/{eventId}")
    public List<PriceAdjustmentLog> getAdjustmentsByEvent(@PathVariable Long eventId) {
        return service.getAdjustmentsByEvent(eventId);
    }

    @GetMapping("/")
    public List<PriceAdjustmentLog> getAllAdjustments() {
        return service.getAllAdjustments();
    }
}

