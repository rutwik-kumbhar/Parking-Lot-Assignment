package com.parking.models;

import com.parking.types.VehicleType;

import java.time.LocalDateTime;

public class Vehicle {

    private  int id;

    private String vehicleName;

    private String vehicleNumber;

    private VehicleType vehicleType;

    private int perHrsPrice;

    private final LocalDateTime  parkDateTime =  LocalDateTime.now();

    private  int customerId;

    private int slotId;

    public Vehicle(int id, String vehicleName, String vehicleNumber, VehicleType vehicleType) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getParkDateTime() {
        return parkDateTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getPerHrsPrice() {
        return perHrsPrice;
    }

    public void setPerHrsPrice(int perHrsPrice) {
        this.perHrsPrice = perHrsPrice;
    }
}
