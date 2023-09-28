package com.kuryeraze.kuryeraze.dao.courier;

import com.kuryeraze.kuryeraze.model.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    Courier findCourierByEmail(String email);
    Courier findCourierByUsername(String username);
}
