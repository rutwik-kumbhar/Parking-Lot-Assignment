package com.parking.services;

import com.parking.exceptions.AlreadyExistException;
import com.parking.exceptions.ResourcesNotFoundException;
import com.parking.models.Customer;
import com.parking.models.Floor;
import com.parking.models.Slot;
import com.parking.models.Vehicle;
import com.parking.types.VehicleType;

public interface ParkingService {

    String addFloor(Floor floor) throws AlreadyExistException;

    String getFloor(int floorNumber) throws ResourcesNotFoundException;

    String getAllFloor();

    String updateFloor(int floorNumber, Floor floor) throws ResourcesNotFoundException;

    String deleteFloor(int floorNumber) throws ResourcesNotFoundException;

    Slot getSlot(int floorNumber) throws ResourcesNotFoundException;

    String addVehicle(Vehicle vehicle, Customer customer);

    String removeVehicle(String vehicleNumber);

    String checkParkingSlot();

    String checkParkingSlotByVehicleType(String vehicleType);
}
