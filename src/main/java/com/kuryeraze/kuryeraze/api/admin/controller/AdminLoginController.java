package com.kuryeraze.kuryeraze.api.admin.controller;

import com.kuryeraze.kuryeraze.dto.admin.AdminDto;
import com.kuryeraze.kuryeraze.model.LoginRequest;
import com.kuryeraze.kuryeraze.service.inter.admin.AdminServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/login/admin")
public class AdminLoginController {

    private final AdminServiceInter adminService;

    public AdminLoginController(AdminServiceInter adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String email = loginRequest.getEmail();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        AdminDto adminDto = adminService.findAdminByEmail(email);
        AdminDto adminDto1 = adminService.findAdminByUsername(username);

        if (adminDto == null && adminDto1 == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username, email and password");
        }

        if (adminDto != null && adminDto.getPassword().equals(password)) {
            return ResponseEntity.ok(adminDto);
        }

        if (adminDto1 != null && adminDto1.getPassword().equals(password)) {
            return ResponseEntity.ok(adminDto1);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username, email and password");
    }
}
