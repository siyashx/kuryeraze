package com.kuryeraze.kuryeraze.api.admin.controller;

import com.kuryeraze.kuryeraze.dto.admin.AdminDto;
import com.kuryeraze.kuryeraze.service.impl.admin.AdminServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/admins")
public class AdminAllController {

    private final AdminServiceImpl adminService;

    public AdminAllController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    // List
    @GetMapping
    public List<AdminDto> getAllAdmins() {
        return adminService.getAllAdmins();
    }
}
