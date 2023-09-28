package com.kuryeraze.kuryeraze.api.courier.controller;

import com.kuryeraze.kuryeraze.dto.courier.CourierDto;
import com.kuryeraze.kuryeraze.model.LoginRequest;
import com.kuryeraze.kuryeraze.service.inter.courier.CourierServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/login/courier")
public class CourierLoginController {

    private final CourierServiceInter courierServiceInter;

    public CourierLoginController(CourierServiceInter courierServiceInter) {
        this.courierServiceInter = courierServiceInter;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        CourierDto courierDto = courierServiceInter.findCourierByEmail(email);
        CourierDto courierDto1 = courierServiceInter.findCourierByUsername(username);

        if (courierDto == null && courierDto1 == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email, username or password");
        }

        if (courierDto != null && courierDto.getPassword().equals(password)) {
            if (!courierDto.getIsDisable()) {
                return ResponseEntity.ok(courierDto);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted");
            }
        }

        if (courierDto1 != null && courierDto1.getPassword().equals(password)) {
            if (!courierDto1.getIsDisable()) {
                return ResponseEntity.ok(courierDto1);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted");
            }
        }


        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid email, username or password");
    }
}
