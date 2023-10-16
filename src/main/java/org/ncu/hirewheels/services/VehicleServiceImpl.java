package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    VehicleCategoryRepository vehicleCategoryRepository;
    @Autowired
    VehicleSubCategoryRepository vehicleSubCategoryRepository;
    @Autowired
    FuelTypeRepository fuelTypeRepository;

    //add a vehicle
    @Override
    public Vehicle addVehicle(String model, String number, String vehicle_subcategory, String color, String location, String fuelType, String availability_status, String vehicle_image_url) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel(model);
        vehicle.setVehicleNumber(number);
        vehicle.setVehicleSubcategory(vehicleSubCategoryRepository.findByVehicleSubcategoryNameIgnoreCase(vehicle_subcategory));
        vehicle.setColor(color);
        vehicle.setLocation(locationRepository.findLocationByLocationNameEqualsIgnoreCase(location));
        vehicle.setFuelType(fuelTypeRepository.findByFuelTypeIgnoreCase(fuelType));
        vehicle.setAvailabilityStatus(Integer.parseInt(availability_status));
        vehicle.setVehicleImageUrl(vehicle_image_url);
        vehicleRepository.save(vehicle);

        return vehicle;
    }
    //update a vehicle
    @Override
    public Vehicle updateVehicle(int id, int availabilityStatus) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle != null) {
            vehicle.setAvailabilityStatus(availabilityStatus);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    //get all vehicles
    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findVehiclesByAvailabilityStatus(1);
    }

    @Override
    public Vehicle getVehicle(int id){
        return vehicleRepository.findById(id).orElse(null);
    }
}