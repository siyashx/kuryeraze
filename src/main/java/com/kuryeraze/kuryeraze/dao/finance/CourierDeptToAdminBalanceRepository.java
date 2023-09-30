package com.kuryeraze.kuryeraze.dao.finance;

import com.kuryeraze.kuryeraze.model.finance.CourierDeptToAdminBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierDeptToAdminBalanceRepository
        extends JpaRepository<CourierDeptToAdminBalance, Long> {
}
