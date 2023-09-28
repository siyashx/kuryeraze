package com.kuryeraze.kuryeraze.dao.admin;

import com.kuryeraze.kuryeraze.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByEmail(String email);
    Admin findAdminByUsername(String username);

}
