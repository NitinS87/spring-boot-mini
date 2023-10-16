package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    //change availability
    public Vehicle changeAvailability(int vehicleId, boolean availability) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;
        vehicle.setAvailabilityStatus(availability ? 1 : 0);
        return vehicleRepository.save(vehicle);
    }
}