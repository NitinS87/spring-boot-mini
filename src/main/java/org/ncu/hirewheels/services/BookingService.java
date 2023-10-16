package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;

import java.util.List;

public interface BookingService {
    //place booking
    public Booking createBooking(Vehicle vehicle);

    //view booking
    public Booking viewBooking(int bookingId);

    //cancel booking
    public boolean cancelBooking(int bookingId);

    //change booking
    public boolean changeBooking(int bookingId, String pickupDate, String dropoffDate);

    //view all booking
    public List<Booking> viewAllBooking();

    //view booking by user
    public List<Booking> viewBookingByUser(int userId);

    //view booking by vehicle
    public List<Booking> viewBookingByVehicle(int vehicleId);

    //view booking by location
    public List<Booking> viewBookingByLocation(int locationId);

}