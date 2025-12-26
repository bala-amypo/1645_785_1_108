// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// import com.example.demo.model.PriceAdjustmentLog;
// import com.example.demo.service.PriceAdjustmentLogService;

// @RestController
// public class PriceAdjustmentLogController {

//     private final PriceAdjustmentLogService service;

//     public PriceAdjustmentLogController(PriceAdjustmentLogService service) {
//         this.service = service;
//     }

//     @PostMapping("/price-adjustments/")
//     public PriceAdjustmentLog logAdjustment(@RequestBody PriceAdjustmentLog log) {
//         return service.logAdjustment(log);
//     }

//     @GetMapping("/price-adjustments/event/{eventId}")
//     public List<PriceAdjustmentLog> getAdjustmentsByEvent(@PathVariable Long eventId) {
//         return service.getAdjustmentsByEvent(eventId);
//     }

//     @GetMapping("/price-adjustments/")
//     public List<PriceAdjustmentLog> getAllAdjustments() {
//         return service.getAllAdjustments();
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-adjustments")
public class PriceAdjustmentLogController {

 private final PriceAdjustmentLogService service;

 public PriceAdjustmentLogController(PriceAdjustmentLogService service) {
  this.service = service;
 }

 @PostMapping
 public PriceAdjustmentLog log(@RequestBody PriceAdjustmentLog log) {
  return service.logAdjustment(log);
 }

 @GetMapping("/event/{eventId}")
 public List<PriceAdjustmentLog> getByEvent(@PathVariable Long eventId) {
  return service.getAdjustmentsByEvent(eventId);
 }

 @GetMapping
 public List<PriceAdjustmentLog> all() {
  return service.getAllAdjustments();
 }
}
