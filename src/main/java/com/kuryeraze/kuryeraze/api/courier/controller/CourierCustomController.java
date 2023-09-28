package com.kuryeraze.kuryeraze.api.courier.controller;

import com.kuryeraze.kuryeraze.dto.courier.CourierDto;
import com.kuryeraze.kuryeraze.service.impl.courier.CourierServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/courier")
public class CourierCustomController {

    private final CourierServiceImpl courierServiceImpl;

    public CourierCustomController(CourierServiceImpl courierServiceImpl) {
        this.courierServiceImpl = courierServiceImpl;
    }

    // Id
    @GetMapping("/{courierId}")
    public ResponseEntity<?> getCourierById(@PathVariable("courierId") Long courierId) {
        CourierDto courierDto = courierServiceImpl.getCourierById(courierId);
        if (courierDto != null) {
            return ResponseEntity.ok(courierDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Courier doesn't exist with given id..");
    }

    // Update
    @PutMapping("/{courierId}")
    public ResponseEntity<?> updateCourier(
            @PathVariable("courierId") Long id,
            @RequestBody CourierDto courierDto) {
        CourierDto updatedCourier = courierServiceImpl.updateCourier(id, courierDto);
        if (updatedCourier != null) {
            return ResponseEntity.ok(updatedCourier);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{courierId}")
    public ResponseEntity<?> deleteCourierById(@PathVariable("courierId") Long courierId) {
        courierServiceImpl.deleteCourier(courierId);
        return ResponseEntity.ok().build();
    }
}
