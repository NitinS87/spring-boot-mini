package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    //add a vehicle
    public Vehicle addVehicle(String model, String number, String vehicle_subcategory, String color, String location, String fuelType, String availability_status, String vehicle_image_url);

    //get all vehicles
    public List<Vehicle> getAllVehicles();

    //get available vehicles
    // This method should fetch a list of all the vehicles that are available for booking based on the
    // Vehicle Category and the Booking Details (pickup location, pickup date and time, drop-off date
    // and time) provided by the user.
    public List<Vehicle> getAvailableVehicles();

    //update a vehicle

    public Vehicle updateVehicle(int id, int availabilityStatus);

    public Vehicle getVehicle(int id);

}