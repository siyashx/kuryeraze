package com.kuryeraze.kuryeraze.dao.finance;

import com.kuryeraze.kuryeraze.model.finance.ShopDeptToAdminBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDeptToAdminBalanceRepository
        extends JpaRepository<ShopDeptToAdminBalance, Long> {
}
