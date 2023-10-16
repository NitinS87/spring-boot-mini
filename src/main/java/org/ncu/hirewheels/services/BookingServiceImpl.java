package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Vehicle vehicle) {
        //Create Booking
        //Check if vehicle is available

        //If available, create booking
        //Else, return null
        return null;
    }

    //get booking by id
    @Override
    public Booking viewBooking(int bookingId) {
        //return booking
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        //delete the booking
        if (bookingRepository.findById(bookingId).orElse(null) == null) return false;
        else bookingRepository.delete(Objects.requireNonNull(bookingRepository.findById(bookingId).orElse(null)));
        return true;
    }

    @Override
    public Booking changeBooking(int bookingId, String pickupDate, String dropoffDate) {
        //convert pickupDate and dropoffDate to Date format
        Date pickupDate1 = new Date(pickupDate);
        Date dropoffDate1 = new Date(dropoffDate);

        //change the booking if it exists
        if (bookingRepository.findById(bookingId).orElse(null) == null) return null;

        bookingRepository.findById(bookingId).orElse(null).setPickupDate(pickupDate1);
        bookingRepository.findById(bookingId).orElse(null).setDropoffDate(dropoffDate1);
        return bookingRepository.save(bookingRepository.findById(bookingId).orElse(null));
    }

    @Override
    public List<Booking> viewAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> viewBookingByUser(int userId) {
        return bookingRepository.findBookingsByUser_UserId((long) userId);
    }

    @Override
    public List<Booking> viewBookingByVehicle(int vehicleId) {
        return bookingRepository.findBookingsByVehicle_VehicleId((long) vehicleId);
    }

    @Override
    public List<Booking> viewBookingByLocation(int locationId) {
        return bookingRepository.findBookingsByVehicle_Location_LocationId((long) locationId);
    }


}