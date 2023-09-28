package com.kuryeraze.kuryeraze.api.admin.controller;

import com.kuryeraze.kuryeraze.dto.admin.AdminDto;
import com.kuryeraze.kuryeraze.service.impl.admin.AdminServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/admin")
public class AdminCustomController {

    private final AdminServiceImpl adminService;

    public AdminCustomController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    // Id
    @GetMapping("/{adminId}")
    public ResponseEntity<?> getAdminById(@PathVariable("adminId") Long adminId) {
        AdminDto adminDto = adminService.getAdminById(adminId);
        if (adminDto != null) {
            return ResponseEntity.ok(adminDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Admin doesn't exist with given id..");
    }

    // Update
    @PutMapping("/{adminId}")
    public ResponseEntity<?> updateAdmin(
            @PathVariable("adminId") Long id,
            @RequestBody AdminDto adminDto) {
        AdminDto updatedAdmin = adminService.updateAdmin(id, adminDto);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        }

        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteAdminById(@PathVariable("adminId") Long adminId) {
        boolean deleted = adminService.deleteAdmin(adminId);
        if (deleted) {
            return ResponseEntity.ok("Admin deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
