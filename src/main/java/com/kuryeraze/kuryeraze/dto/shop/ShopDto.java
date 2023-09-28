package com.kuryeraze.kuryeraze.dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShopDto {

    private Long id;

    private String oneSignal;

    private String firstName;

    private String location;

    private String phoneNumber;

    private String latLong;

    private String username;

    private String email;

    private String password;

    private String createdDate;

    @JsonProperty("isDisable")
    private Boolean isDisable;

}
