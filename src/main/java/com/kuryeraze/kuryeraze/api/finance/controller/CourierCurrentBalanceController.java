package com.kuryeraze.kuryeraze.api.finance.controller;

import com.kuryeraze.kuryeraze.dto.finance.CourierCurrentBalanceDto;
import com.kuryeraze.kuryeraze.service.impl.finance.CourierCurrentBalanceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/courierCurrentBalance")
public class CourierCurrentBalanceController {

    private final CourierCurrentBalanceImpl service;

    public CourierCurrentBalanceController(CourierCurrentBalanceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CourierCurrentBalanceDto>> getAllCourierCurrentBalance() {
        List<CourierCurrentBalanceDto> all = service.getAllCourierCurrentBalance();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<CourierCurrentBalanceDto> getCourierCurrentBalanceById(@PathVariable("detId") Long id) {
        CourierCurrentBalanceDto det = service.getCourierCurrentBalanceById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourierCurrentBalanceDto> saveCourierCurrentBalance(@RequestBody CourierCurrentBalanceDto dto) {
        CourierCurrentBalanceDto courierCurrentBalanceDto = service.saveCourierCurrentBalance(dto);
        return ResponseEntity.ok(courierCurrentBalanceDto);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteCourierCurrentBalance(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteCourierCurrentBalance(id);
        if (deleted) {
            return ResponseEntity.ok("CourierCurrentBalance deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
