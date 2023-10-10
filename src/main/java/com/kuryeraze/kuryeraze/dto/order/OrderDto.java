package com.kuryeraze.kuryeraze.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class OrderDto {

    private Long id;

    private Long courierId;

    private Long shopId;

    private String status;

    private String customerPhoneNumber;

    private String toLocation;

    private Double itemPrice;

    private Double deliveryPrice;

    private Double pickupCourierPrice;

    private Integer paidType;

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
