package com.kuryeraze.kuryeraze.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminDto {

    private Long id;

    private String oneSignal;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;
}
