package com.kuryeraze.kuryeraze.api.admin.controller;

import com.kuryeraze.kuryeraze.dto.admin.AdminDto;
import com.kuryeraze.kuryeraze.service.impl.admin.AdminServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/create/admin")
public class AdminRegisterController {

    private final AdminServiceImpl adminService;

    public AdminRegisterController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    // Create
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
        return adminService.createAdmin(adminDto);
    }

}
