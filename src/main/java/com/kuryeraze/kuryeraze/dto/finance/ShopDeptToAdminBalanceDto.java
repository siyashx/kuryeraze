package com.kuryeraze.kuryeraze.dto.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShopDeptToAdminBalanceDto {

    private Long id;

    private Long courierId;
    private Long shopId;
    private Double price;
    private String date;
    private String time;
}
