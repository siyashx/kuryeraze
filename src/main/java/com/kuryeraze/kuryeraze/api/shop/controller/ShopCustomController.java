package com.kuryeraze.kuryeraze.api.shop.controller;

import com.kuryeraze.kuryeraze.dto.shop.ShopDto;
import com.kuryeraze.kuryeraze.service.impl.shop.ShopServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/shop")
public class ShopCustomController {

    private final ShopServiceImpl shopServiceImpl;

    public ShopCustomController(ShopServiceImpl shopServiceImpl) {
        this.shopServiceImpl = shopServiceImpl;
    }

    // Id
    @GetMapping("/{shopId}")
    public ResponseEntity<?> getShopById(@PathVariable("shopId") Long shopId) {
        ShopDto shopDto = shopServiceImpl.getShopById(shopId);
        if (shopDto != null) {
            return ResponseEntity.ok(shopDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Shop doesn't exist with given id..");
    }

    // Update
    @PutMapping("/{shopId}")
    public ResponseEntity<?> updateShop(
            @PathVariable("shopId") Long id,
            @RequestBody ShopDto shopDto
    ) {
        ShopDto updatedShop = shopServiceImpl.updateShop(id, shopDto);
        if (updatedShop != null) {
            return ResponseEntity.ok(updatedShop);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{shopId}")
    public ResponseEntity<?> deleteShopById(@PathVariable("shopId") Long shopId) {
        shopServiceImpl.deleteShopById(shopId);
        return ResponseEntity.ok().build();
    }
}
