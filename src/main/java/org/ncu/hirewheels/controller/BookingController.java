package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/hirewheels/v1")
public class BookingController {
    @Autowired
    BookingService bookingService;

    //place a booking
    // This method should allow the user to place a booking for a vehicle. The user should be able to
    // place a booking for a vehicle only if the vehicle is available for booking for the given time
    // period.
    @PostMapping (value = "/bookings")
    public ResponseEntity<Booking> placeBooking(@RequestBody Vehicle vehicle) {
        Booking newBooking = bookingService.createBooking(vehicle);
        if (newBooking == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("newBooking: " + newBooking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

}
