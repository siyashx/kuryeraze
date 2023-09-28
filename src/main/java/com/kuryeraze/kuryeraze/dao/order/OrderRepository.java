package com.kuryeraze.kuryeraze.dao.order;

import com.kuryeraze.kuryeraze.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
