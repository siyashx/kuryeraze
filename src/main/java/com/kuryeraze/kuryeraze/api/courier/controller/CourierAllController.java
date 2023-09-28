package com.kuryeraze.kuryeraze.api.courier.controller;

import com.kuryeraze.kuryeraze.dto.courier.CourierDto;
import com.kuryeraze.kuryeraze.service.impl.courier.CourierServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/couriers")
public class CourierAllController {

    private final CourierServiceImpl courierServiceImpl;

    public CourierAllController(CourierServiceImpl courierServiceImpl) {
        this.courierServiceImpl = courierServiceImpl;
    }

    // List
    @GetMapping
    public List<CourierDto> getAllCouriers() {
        return courierServiceImpl.getAllCouriers();
    }
}
