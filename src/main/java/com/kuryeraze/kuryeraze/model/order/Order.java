package com.kuryeraze.kuryeraze.model.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version; // Optimistic locking

    @Column(name = "courier_id")
    private Long courierId;

    @Column(name = "shop_id")
    private Long shopId;

    private String status;

    private String customerPhoneNumber;

    private String toLocation;

    private Double itemPrice;

    private Double deliveryPrice;

    private Double pickupCourierPrice;

    private String description;

    private String createdDate;

    private String createdTime;

    private String callCourierDate;

    private String callCourierTime;

    private String wayDate;

    private String wayTime;

    private String successDate;

    private String successTime;

    private String returnDate;

    private String returnTime;

}
