package com.kuryeraze.kuryeraze.service.impl.order;

import com.kuryeraze.kuryeraze.dao.order.OrderRepository;
import com.kuryeraze.kuryeraze.dto.order.OrderDto;
import com.kuryeraze.kuryeraze.model.order.Order;
import com.kuryeraze.kuryeraze.service.inter.order.OrderServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderServiceInter {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
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
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
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

            if (orderDto.getPaidType() != null) {
                order.setPaidType(orderDto.getPaidType());
            }

            if (orderDto.getDescription() != null) {
                order.setDescription(orderDto.getDescription());
            }

            if (orderDto.getCreatedDate() != null) {
                order.setCreatedDate(orderDto.getCreatedDate());
            }

            if (orderDto.getCreatedTime() != null) {
                order.setCreatedTime(orderDto.getCreatedTime());
            }

            if (orderDto.getCallCourierDate() != null) {
                order.setCallCourierDate(orderDto.getCallCourierDate());
            }

            if (orderDto.getCallCourierTime() != null) {
                order.setCallCourierTime(orderDto.getCallCourierTime());
            }

            if (orderDto.getWayDate() != null) {
                order.setWayDate(orderDto.getWayDate());
            }

            if (orderDto.getWayTime() != null) {
                order.setWayTime(orderDto.getWayTime());
            }

            if (orderDto.getSuccessDate() != null) {
                order.setSuccessDate(orderDto.getSuccessDate());
            }

            if (orderDto.getSuccessTime() != null) {
                order.setSuccessTime(orderDto.getSuccessTime());
            }

            if (orderDto.getReturnDate() != null) {
                order.setReturnDate(orderDto.getReturnDate());
            }

            if (orderDto.getReturnTime() != null) {
                order.setReturnTime(orderDto.getReturnTime());
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
