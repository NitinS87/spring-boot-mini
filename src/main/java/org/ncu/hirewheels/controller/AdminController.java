package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/hirewheels/v1")
public class AdminController {
    @Autowired
    VehicleService vehicleService;

    //add a vehicle
    // This method should add a new vehicle to the system. Only the Admin should be able to add a
    // new vehicle to the system.
    @PostMapping(value = "/vehicles")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody String model, @RequestBody String number, @RequestBody String vehicle_subcategory, @RequestBody String color, @RequestBody String location, @RequestBody String fuelType, @RequestBody String availability_status, @RequestBody String vehicle_image_url) {
        Vehicle newVehicle = vehicleService.addVehicle(model, number, vehicle_subcategory, color, location, fuelType, availability_status, vehicle_image_url);
        if (newVehicle == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("newVehicle: " + newVehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    //update a vehicle
    // This method should update the details of an existing vehicle in the system. Only the Admin
    // should be able to update the details of an existing vehicle in the system.
    @PutMapping(value = "/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle.getAvailabilityStatus());
        if (updatedVehicle == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("updatedVehicle: " + updatedVehicle);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }
}
