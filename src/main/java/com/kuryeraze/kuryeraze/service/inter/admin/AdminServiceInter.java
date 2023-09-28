package com.kuryeraze.kuryeraze.service.inter.admin;

import com.kuryeraze.kuryeraze.dto.admin.AdminDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminServiceInter {

    List<AdminDto> getAllAdmins();
    AdminDto getAdminById(Long id);
    ResponseEntity<AdminDto> createAdmin(AdminDto adminDto);
    AdminDto updateAdmin(Long id, AdminDto adminDto);
    Boolean deleteAdmin(Long id);
    Boolean isAdminEmailTaken(String email);
    Boolean isAdminUsernameTaken(String username);
    AdminDto findAdminByEmail(String email);
    AdminDto findAdminByUsername(String username);
}
