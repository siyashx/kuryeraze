package com.kuryeraze.kuryeraze.dao.finance;

import com.kuryeraze.kuryeraze.model.finance.CourierCurrentBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierCurrentBalanceRepository
        extends JpaRepository<CourierCurrentBalance, Long> {
}
