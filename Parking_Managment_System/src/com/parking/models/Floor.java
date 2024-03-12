package com.parking.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Floor {

    Set<Slot> slots = new HashSet<>();
    private int floorNumber;
    private int totalCapacity;
    private int twoWheelerCapacity;
    private int fourWheelerCapacity;
    private int otherCapacity;
    private int parkCount = 0;
    private int twoWheelerParkCount = 0;
    private int fourWheelerParkCount = 0;
    private int otherParkCount = 0;

    public Floor() {
    }

    public Floor(int floorNumber, int twoWheelerCapacity, int fourWheelerCapacity, int otherCapacity) {
        this.floorNumber = floorNumber;
        this.twoWheelerCapacity = twoWheelerCapacity;
        this.fourWheelerCapacity = fourWheelerCapacity;
        this.otherCapacity = otherCapacity;
    }

    public Floor(int twoWheelerCapacity, int fourWheelerCapacity, int otherCapacity) {
        this.twoWheelerCapacity = twoWheelerCapacity;
        this.fourWheelerCapacity = fourWheelerCapacity;
        this.otherCapacity = otherCapacity;
    }

    public Floor(int floorNumber, int totalCapacity, int twoWheelerCapacity, int fourWheelerCapacity, int otherCapacity, int parkCount, int twoWheelerParkCount, int fourWheelerParkCount, int otherParkCount) {
        this.floorNumber = floorNumber;
        this.totalCapacity = totalCapacity;
        this.twoWheelerCapacity = twoWheelerCapacity;
        this.fourWheelerCapacity = fourWheelerCapacity;
        this.otherCapacity = otherCapacity;
        this.parkCount = parkCount;
        this.twoWheelerParkCount = twoWheelerParkCount;
        this.fourWheelerParkCount = fourWheelerParkCount;
        this.otherParkCount = otherParkCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return false;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Floor floor = (Floor) obj;
        return this.floorNumber == floor.getFloorNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getTwoWheelerCapacity() {
        return twoWheelerCapacity;
    }

    public void setTwoWheelerCapacity(int twoWheelerCapacity) {
        this.twoWheelerCapacity = twoWheelerCapacity;
    }

    public int getFourWheelerCapacity() {
        return fourWheelerCapacity;
    }

    public void setFourWheelerCapacity(int fourWheelerCapacity) {
        this.fourWheelerCapacity = fourWheelerCapacity;
    }

    public int getOtherCapacity() {
        return otherCapacity;
    }

    public void setOtherCapacity(int otherCapacity) {
        this.otherCapacity = otherCapacity;
    }

    public int getParkCount() {
        return parkCount;
    }

    public void setParkCount(int parkCount) {
        this.parkCount = parkCount;
    }

    public int getTwoWheelerParkCount() {
        return twoWheelerParkCount;
    }

    public void setTwoWheelerParkCount(int twoWheelerParkCount) {
        this.twoWheelerParkCount = twoWheelerParkCount;
    }

    public int getFourWheelerParkCount() {
        return fourWheelerParkCount;
    }

    public void setFourWheelerParkCount(int fourWheelerParkCount) {
        this.fourWheelerParkCount = fourWheelerParkCount;
    }

    public int getOtherParkCount() {
        return otherParkCount;
    }

    public void setOtherParkCount(int otherParkCount) {
        this.otherParkCount = otherParkCount;
    }

    public Set<Slot> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", totalCapacity=" + totalCapacity +
                ", twoWheelerCapacity=" + twoWheelerCapacity +
                ", fourWheelerCapacity=" + fourWheelerCapacity +
                ", otherCapacity=" + otherCapacity +
                ", parkCount=" + parkCount +
                ", twoWheelerParkCount=" + twoWheelerParkCount +
                ", fourWheelerParkCount=" + fourWheelerParkCount +
                ", otherParkCount=" + otherParkCount +
                ", slots=" + slots +
                '}';
    }
}
