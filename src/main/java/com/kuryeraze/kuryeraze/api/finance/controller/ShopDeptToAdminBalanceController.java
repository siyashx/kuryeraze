package com.kuryeraze.kuryeraze.api.finance.controller;

import com.kuryeraze.kuryeraze.dto.finance.ShopDeptToAdminBalanceDto;
import com.kuryeraze.kuryeraze.service.impl.finance.ShopDeptToAdminBalanceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/shopDeptToAdminBalance")
public class ShopDeptToAdminBalanceController {

    private final ShopDeptToAdminBalanceImpl service;

    public ShopDeptToAdminBalanceController(ShopDeptToAdminBalanceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShopDeptToAdminBalanceDto>> getAllShopDeptToAdminBalance() {
        List<ShopDeptToAdminBalanceDto> all = service.getAllShopDeptToAdmin();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<ShopDeptToAdminBalanceDto> getShopDeptToAdminBalanceById(@PathVariable("detId") Long id) {
        ShopDeptToAdminBalanceDto det = service.getShopDeptToAdminBalanceById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ShopDeptToAdminBalanceDto> saveShopDeptToAdminBalance(@RequestBody ShopDeptToAdminBalanceDto dto) {
        ShopDeptToAdminBalanceDto created = service.saveShopDeptToAdminBalance(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteShopDeptToAdminBalance(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteShopDeptToAdminBalance(id);
        if (deleted) {
            return ResponseEntity.ok("ShopDeptToAdminBalance deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
