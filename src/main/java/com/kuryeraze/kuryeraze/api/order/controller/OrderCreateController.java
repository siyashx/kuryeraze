package com.kuryeraze.kuryeraze.api.order.controller;

import com.kuryeraze.kuryeraze.dto.order.OrderDto;
import com.kuryeraze.kuryeraze.service.impl.order.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/create/order")
public class OrderCreateController {

    private final OrderServiceImpl orderServiceImpl;

    public OrderCreateController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    // Create
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderServiceImpl.createOrder(orderDto);
        return ResponseEntity.ok(createdOrder);
    }
}
