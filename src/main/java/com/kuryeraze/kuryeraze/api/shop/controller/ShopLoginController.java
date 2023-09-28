package com.kuryeraze.kuryeraze.api.shop.controller;

import com.kuryeraze.kuryeraze.dto.shop.ShopDto;
import com.kuryeraze.kuryeraze.model.LoginRequest;
import com.kuryeraze.kuryeraze.service.impl.shop.ShopServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/login/shop")
public class ShopLoginController {

    private final ShopServiceImpl shopServiceImpl;

    public ShopLoginController(ShopServiceImpl shopServiceImpl) {
        this.shopServiceImpl = shopServiceImpl;
    }

    // Login
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        ShopDto shopDto = shopServiceImpl.findShopByEmail(email);
        ShopDto shopDto1 = shopServiceImpl.findShopByUsername(username);

        if (shopDto == null && shopDto1 == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    "Invalid username, email or password");
        }

        if (shopDto != null && shopDto.getPassword().equals(password)) {
            if (!shopDto.getIsDisable()) {
                return ResponseEntity.ok(shopDto);
            } else {
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted");
            }
        }

        if (shopDto1 != null && shopDto1.getPassword().equals(password)) {
            if (!shopDto1.getIsDisable()) {
                return ResponseEntity.ok(shopDto1);
            } else {
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                "Invalid username, email or password");
    }
}
