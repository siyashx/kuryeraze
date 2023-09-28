package com.kuryeraze.kuryeraze.api.order.controller;

import com.kuryeraze.kuryeraze.dto.order.OrderDto;
import com.kuryeraze.kuryeraze.service.impl.order.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderAllController {

    private final OrderServiceImpl orderServiceImpl;

    public OrderAllController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtoList = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(orderDtoList);
    }
}
