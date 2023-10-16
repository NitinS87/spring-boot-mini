package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public Booking createBooking(Vehicle vehicle) {
        //Create Booking
        return null;
    }

    @Override
    public Booking viewBooking(int bookingId) {
        return null;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        return false;
    }

    @Override
    public boolean changeBooking(int bookingId, String pickupDate, String dropoffDate) {
        return false;
    }

    @Override
    public List<Booking> viewAllBooking() {
        return null;
    }

    @Override
    public List<Booking> viewBookingByUser(int userId) {
        return null;
    }

    @Override
    public List<Booking> viewBookingByVehicle(int vehicleId) {
        return null;
    }

    @Override
    public List<Booking> viewBookingByLocation(int locationId) {
        return null;
    }


}