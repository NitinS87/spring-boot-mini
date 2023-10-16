package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/hirewheels/v1")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


    //get all vehicles
    // This method should fetch a list of all the vehicles that are available for booking based on the
    // Vehicle Category and the Booking Details (pickup location, pickup date and time, drop-off date
    // and time) provided by the user.
    @GetMapping(value = "/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("vehicles: " + vehicles);
        return ResponseEntity.ok(vehicles);
    }

    //get available vehicles
    // This method should fetch a list of all the vehicles that are available for booking based on the
    // Vehicle Category and the Booking Details (pickup location, pickup date and time, drop-off date
    // and time) provided by the user.
    @GetMapping(value = "/vehicles/available")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles() {
        List<Vehicle> vehicles = vehicleService.getAvailableVehicles();
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("vehicles: " + vehicles);
        return ResponseEntity.ok(vehicles);
    }
}