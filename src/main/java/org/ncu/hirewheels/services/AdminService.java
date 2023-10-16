package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Vehicle;

public interface AdminService {
    //change availability
    public Vehicle changeAvailability(int vehicleId, boolean availability);
}