package com.kuryeraze.kuryeraze.api.finance.controller;

import com.kuryeraze.kuryeraze.dto.finance.AdminDeptToShopBalanceDto;
import com.kuryeraze.kuryeraze.service.impl.finance.AdminDeptToShopBalanceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/adminDeptToShopBalance")
public class AdminDeptToShopBalanceController {

    private final AdminDeptToShopBalanceImpl service;

    public AdminDeptToShopBalanceController(AdminDeptToShopBalanceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdminDeptToShopBalanceDto>> getAllAdminDeptToShopBalance() {
        List<AdminDeptToShopBalanceDto> all = service.getAllAdminDeptToShopBalance();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<AdminDeptToShopBalanceDto> getAllAdminDeptToShopBalance(@PathVariable("detId") Long id) {
        AdminDeptToShopBalanceDto det = service.getAdminDeptToShopById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminDeptToShopBalanceDto> saveAdminDeptToShopBalance(@RequestBody AdminDeptToShopBalanceDto dto) {
        AdminDeptToShopBalanceDto adminDeptToShopBalanceDto = service.saveAdminDeptToShop(dto);
        return ResponseEntity.ok(adminDeptToShopBalanceDto);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteAdminDeptToShopBalance(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteAdminDeptToShop(id);
        if (deleted) {
            return ResponseEntity.ok("AdminDeptToShopBalance deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
