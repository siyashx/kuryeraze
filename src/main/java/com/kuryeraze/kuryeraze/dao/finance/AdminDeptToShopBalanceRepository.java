package com.kuryeraze.kuryeraze.dao.finance;

import com.kuryeraze.kuryeraze.model.finance.AdminDeptToShopBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDeptToShopBalanceRepository
        extends JpaRepository<AdminDeptToShopBalance, Long> {
}
