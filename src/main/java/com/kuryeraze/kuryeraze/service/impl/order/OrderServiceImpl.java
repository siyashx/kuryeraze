package com.kuryeraze.kuryeraze.service.impl.order;

import com.kuryeraze.kuryeraze.dao.order.OrderRepository;
import com.kuryeraze.kuryeraze.dto.order.OrderDto;
import com.kuryeraze.kuryeraze.model.order.Order;
import com.kuryeraze.kuryeraze.service.inter.order.OrderServiceInter;
import org.modelmapper.ModelMapper;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService implements OrderServiceInter {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order = orderRepository.save(order);
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(order -> modelMapper.map(order, OrderDto.class)).orElse(null);
    }

    @Override
    public OrderDto updateOrder(Long orderId, Order orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            if (orderDto.getCourierId() != null) {
                order.setCourierId(orderDto.getCourierId());
            }

            if (orderDto.getShopId() != null) {
                order.setShopId(orderDto.getShopId());
            }

            if (orderDto.getStatus() != null) {
                order.setStatus(orderDto.getStatus());
            }

            if (orderDto.getCustomerPhoneNumber() != null) {
                order.setCustomerPhoneNumber(orderDto.getCustomerPhoneNumber());
            }

            if (orderDto.getToLocation() != null) {
                order.setToLocation(orderDto.getToLocation());
            }

            if (orderDto.getItemPrice() != null) {
                order.setItemPrice(orderDto.getItemPrice());
            }

            if (orderDto.getDeliveryPrice() != null) {
                order.setDeliveryPrice(orderDto.getDeliveryPrice());
            }

            if (orderDto.getPickupCourierPrice() != null) {
                order.setPickupCourierPrice(orderDto.getPickupCourierPrice());
            }

            if (orderDto.getDescription() != null) {
                order.setDescription(orderDto.getDescription());
            }

            order = orderRepository.save(order);
            return modelMapper.map(order, OrderDto.class);


        }
        return null;
    }

    @Override
    public Boolean removeById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderRepository.delete(order);
            return true;
        }
        return false;
    }


}
