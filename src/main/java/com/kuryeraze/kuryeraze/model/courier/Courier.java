package com.kuryeraze.kuryeraze.model.courier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oneSignal;

    private String firstName;

    private String lastName;

    private String location;

    private String phoneNumber;

    private String familyPhoneNumber;

    private String finCode;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String createdDate;

    @Column(name = "isDisable")
    private Boolean isDisable;
}
