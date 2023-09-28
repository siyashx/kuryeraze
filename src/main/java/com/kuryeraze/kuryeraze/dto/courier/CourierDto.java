package com.kuryeraze.kuryeraze.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourierDto {

    private Long id;

    private String oneSignal;

    private String firstName;

    private String lastName;

    private String location;

    private String phoneNumber;

    private String familyPhoneNumber;

    private String finCode;

    private String username;

    private String email;

    private String password;

    private String createdDate;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
