package com.kuryeraze.kuryeraze.api.shop.controller;

import com.kuryeraze.kuryeraze.dto.shop.ShopDto;
import com.kuryeraze.kuryeraze.service.impl.shop.ShopServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/create/shop")
public class ShopRegisterController {

    private final ShopServiceImpl shopServiceImpl;

    public ShopRegisterController(ShopServiceImpl shopServiceImpl) {
        this.shopServiceImpl = shopServiceImpl;
    }

    // Create
    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto) {
        return shopServiceImpl.createShop(shopDto);
    }

}
