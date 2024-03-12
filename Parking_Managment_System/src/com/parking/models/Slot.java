package com.parking.models;

import com.parking.types.VehicleType;

public class Slot {

    private int slotId;

    private boolean isPark ;

    private VehicleType vehicleType;

    private int floorId;

    public Slot() {
    }

    public Slot(int slotId, boolean isPark, VehicleType vehicleType, int floorId) {
        this.slotId = slotId;
        this.isPark = isPark;
        this.vehicleType = vehicleType;
        this.floorId = floorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isPark() {
        return isPark;
    }

    public void setPark(boolean park) {
        isPark = park;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", isPark=" + isPark +
                ", vehicleType=" + vehicleType +
                ", floorId=" + floorId +
                '}';
    }
}
