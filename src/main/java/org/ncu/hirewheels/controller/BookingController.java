package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/hirewheels/v1")
public class BookingController {
    @Autowired
    BookingService bookingService;

    //view all booking
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBooking() {
        List<Booking> bookings = bookingService.viewAllBooking();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    //place a booking
    // This method should allow the user to place a booking for a vehicle. The user should be able to
    // place a booking for a vehicle only if the vehicle is available for booking for the given time
    // period.
    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> placeBooking(@RequestBody Vehicle vehicle) {
        Booking newBooking = bookingService.createBooking(vehicle);
        if (newBooking == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("newBooking: " + newBooking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    //view booking
    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable int id) {
        Booking booking = bookingService.viewBooking(id);
        if (booking == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }


    //cancel booking
    @PutMapping("/bookings/cancel/{id}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable int id) {
        if (!bookingService.cancelBooking(id)) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //change booking
    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> changeBooking(@PathVariable int id, @RequestBody String pickupDate, String dropoffDate) {
        Booking booking = bookingService.changeBooking(id, pickupDate, dropoffDate);
        if (booking == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    //view booking by user
    @GetMapping("/bookings/user/{id}")
    public ResponseEntity<List<Booking>> getBookingByUser(@PathVariable int id) {
        List<Booking> bookings = bookingService.viewBookingByUser(id);
        if (bookings == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    //view booking by vehicle
    @GetMapping("/bookings/vehicle/{id}")
    public ResponseEntity<List<Booking>> getBookingByVehicle(@PathVariable int id) {
        List<Booking> bookings = bookingService.viewBookingByVehicle(id);
        if (bookings == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    //view booking by location
    @GetMapping("/bookings/location/{id}")
    public ResponseEntity<List<Booking>> getBookingByLocation(@PathVariable int id) {
        List<Booking> bookings = bookingService.viewBookingByLocation(id);
        if (bookings == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

}
