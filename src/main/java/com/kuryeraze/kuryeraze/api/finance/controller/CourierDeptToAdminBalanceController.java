package com.kuryeraze.kuryeraze.api.finance.controller;

import com.kuryeraze.kuryeraze.dto.finance.CourierDeptToAdminBalanceDto;
import com.kuryeraze.kuryeraze.service.impl.finance.CourierDeptToAdminBalanceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/courierDeptToAdminBalance")
public class CourierDeptToAdminBalanceController {

    private final CourierDeptToAdminBalanceImpl service;

    public CourierDeptToAdminBalanceController(CourierDeptToAdminBalanceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CourierDeptToAdminBalanceDto>> getAllCourierDeptToAdminBalance() {
        List<CourierDeptToAdminBalanceDto> all = service.getAllCourierDeptToAdmin();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<CourierDeptToAdminBalanceDto> getCourierDeptToAdminBalanceById(@PathVariable("detId") Long id) {
        CourierDeptToAdminBalanceDto det = service.getCourierDeptToAdminBalanceById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourierDeptToAdminBalanceDto> saveCourierDeptToAdminBalance(@RequestBody CourierDeptToAdminBalanceDto dto) {
        CourierDeptToAdminBalanceDto created = service.saveCourierDeptToAdminBalance(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteCourierDeptToAdminBalance(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteCourierDeptToAdminBalance(id);
        if (deleted) {
            return ResponseEntity.ok("CourierDeptToAdminBalance deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
