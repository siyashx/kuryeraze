package com.kuryeraze.kuryeraze.api.shop.controller;

import com.kuryeraze.kuryeraze.dto.shop.ShopDto;
import com.kuryeraze.kuryeraze.service.impl.shop.ShopServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/shops")
public class ShopAllController {

    private final ShopServiceImpl shopServiceImpl;

    public ShopAllController(ShopServiceImpl shopServiceImpl) {
        this.shopServiceImpl = shopServiceImpl;
    }

    // List
    @GetMapping
    public List<ShopDto> getAllShops() {
        return shopServiceImpl.getAllShops();
    }
}
