package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findBookingsByUser_UserId(Long userId);

    List<Booking> findBookingsByVehicle_VehicleId(Long vehicleId);

    List<Booking> findBookingsByVehicle_Location_LocationId(Long locationId);
}
