package com.parking.controller;

import com.parking.models.Customer;
import com.parking.models.Floor;
import com.parking.models.Vehicle;
import com.parking.services.ParkingService;
import com.parking.services.impl.ParkingServiceImpl;

public class ParkingController {


    private final ParkingService parkingService;



    public ParkingController() {
        this.parkingService = new ParkingServiceImpl();
    }

    public String addFloor(Floor floor) {
        return parkingService.addFloor(floor);
    }

    public String getFloorById(int floorNumber) {
        return parkingService.getFloor(floorNumber );
    }

    public String getAllFloors() {
        return parkingService.getAllFloor();
    }

    public String updateFloors(int floorNumber, Floor floor) {
        return parkingService.updateFloor(floorNumber, floor);
    }

    public String deleteFloor(int floorNumber) {
        return parkingService.deleteFloor(floorNumber);
    }

   public String addVehicle(Vehicle vehicle, Customer customer){
        return  parkingService.addVehicle(vehicle,customer);
   }

    public String removeVehicle(String vehicleNumber){
        return parkingService.removeVehicle(vehicleNumber);
    }

    public String checkParkingSlot(){
        return  parkingService.checkParkingSlot();
    }

    public  String checkParkingSlotByVehicleType(String vehicleType){
        return parkingService.checkParkingSlotByVehicleType(vehicleType);
    }
}
