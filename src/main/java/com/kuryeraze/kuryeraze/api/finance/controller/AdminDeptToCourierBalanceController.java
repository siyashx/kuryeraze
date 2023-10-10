package com.kuryeraze.kuryeraze.api.finance.controller;

import com.kuryeraze.kuryeraze.dto.finance.AdminDeptToCourierBalanceDto;
import com.kuryeraze.kuryeraze.service.impl.finance.AdminDeptToCourierBalanceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/adminDeptToCourierBalance")
public class AdminDeptToCourierBalanceController {

    private final AdminDeptToCourierBalanceImpl service;

    public AdminDeptToCourierBalanceController(AdminDeptToCourierBalanceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdminDeptToCourierBalanceDto>> getAllAdminDeptToCourierBalance() {
        List<AdminDeptToCourierBalanceDto> all = service.getAllAdminDeptToCourierBalance();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<AdminDeptToCourierBalanceDto> getAllAdminDeptToCourierBalance(@PathVariable("detId") Long id) {
        AdminDeptToCourierBalanceDto det = service.getAdminDeptToCourierById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminDeptToCourierBalanceDto> saveAdminDeptToCourierBalance(@RequestBody AdminDeptToCourierBalanceDto dto) {
        AdminDeptToCourierBalanceDto adminDeptToCourierBalanceDto = service.saveAdminDeptToCourier(dto);
        return ResponseEntity.ok(adminDeptToCourierBalanceDto);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteAdminDeptToCourierBalance(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteAdminDeptToCourier(id);
        if (deleted) {
            return ResponseEntity.ok("adminDeptToCourierBalance deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
