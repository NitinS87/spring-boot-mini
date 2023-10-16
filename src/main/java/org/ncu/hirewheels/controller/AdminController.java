package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.UserService;
import org.ncu.hirewheels.services.VehicleService;
import org.ncu.hirewheels.utils.VehicleAdditionRequest;
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

    @Autowired
    UserService userService;

    //add a vehicle
    // This method should add a new vehicle to the system. Only the Admin should be able to add a
    // new vehicle to the system.
    @PostMapping(value = "/vehicles/{userId}")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleAdditionRequest vehicle, @PathVariable("userId") int userId) {
        if (userService.getUserByCriteria((long) userId, null, null, null, null) == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (userService.getUserByCriteria((long) userId, null, null, null, null).getRole().getRoleId() != 1) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Vehicle newVehicle = vehicleService.addVehicle(vehicle.vehicleModel, vehicle.vehicleNumber, vehicle.vehicleSubcategory, vehicle.color, vehicle.location, vehicle.fuelType, vehicle.availabilityStatus, vehicle.vehicleImageUrl);
        if (newVehicle == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("newVehicle: " + newVehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    //update a vehicle
    // This method should update the details of an existing vehicle in the system. Only the Admin
    // should be able to update the details of an existing vehicle in the system.
    @PutMapping(value = "/vehicles/{id}/{userId}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, int availabilityStatus, @PathVariable("userId") int userId) {
        if (userService.getUserByCriteria((long) userId, null, null, null, null) == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (userService.getUserByCriteria((long) userId, null, null, null, null).getRole().getRoleId() != 1) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, availabilityStatus);
        if (updatedVehicle == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("updatedVehicle: " + updatedVehicle);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }
}
