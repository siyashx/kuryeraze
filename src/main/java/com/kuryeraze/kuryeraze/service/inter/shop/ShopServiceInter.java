package com.kuryeraze.kuryeraze.service.inter.shop;

import com.kuryeraze.kuryeraze.dto.shop.ShopDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShopServiceInter {

    List<ShopDto> getAllShops();
    ShopDto getShopById(Long id);
    ResponseEntity<ShopDto> createShop(ShopDto shopDto);
    ShopDto updateShop(Long id, ShopDto shopDto);
    void deleteShopById(Long id);
    Boolean isShopEmailTaken(String email);
    Boolean isShopUsernameTaken(String username);
    ShopDto findShopByEmail(String email);
    ShopDto findShopByUsername(String username);
}
