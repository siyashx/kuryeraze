package com.kuryeraze.kuryeraze.dao.finance;

import com.kuryeraze.kuryeraze.model.finance.AdminDeptToCourierBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDeptToCourierBalanceRepository
        extends JpaRepository<AdminDeptToCourierBalance, Long> {
}
