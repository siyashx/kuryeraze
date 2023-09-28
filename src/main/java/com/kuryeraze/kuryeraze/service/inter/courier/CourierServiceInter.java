package com.kuryeraze.kuryeraze.service.inter.courier;

import com.kuryeraze.kuryeraze.dto.courier.CourierDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourierServiceInter {

    List<CourierDto> getAllCouriers();
    CourierDto getCourierById(Long id);
    ResponseEntity<CourierDto> createCourier(CourierDto courierDto);
    CourierDto updateCourier(Long id, CourierDto courierDto);
    void deleteCourier(Long id);
    Boolean isCourierEmailTaken(String email);
    Boolean isCourierUsernameTaken(String username);
    CourierDto findCourierByEmail(String email);
    CourierDto findCourierByUsername(String username);
}
