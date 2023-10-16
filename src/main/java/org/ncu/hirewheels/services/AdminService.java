package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

public interface AdminService {
    //register vehicle
    public boolean registerVehicle(Vehicle vehicle);

    //change availability
    public boolean changeAvailability(int vehicleId, boolean availability);
}