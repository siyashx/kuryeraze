package com.kuryeraze.kuryeraze.service.inter.order;

import com.kuryeraze.kuryeraze.dto.order.OrderDto;

import java.util.List;

public interface OrderServiceInter {
    OrderDto createOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    Boolean removeById(Long orderId);

    OrderDto getOrderById(Long orderId);

    OrderDto updateOrder(Long orderId, OrderDto orderDto);
}
