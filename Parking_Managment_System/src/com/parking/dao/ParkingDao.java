package com.parking.dao;

import com.parking.models.Customer;
import com.parking.models.Floor;
import com.parking.models.Slot;
import com.parking.models.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingDao {


    public Set<Floor> floors = new HashSet<>();

    public Set<Slot> slots = new HashSet<>();

    private List<Vehicle> vehicles = new ArrayList<>();

    private List<Customer> customers = new ArrayList<>();

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public Set<Slot> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slot> slots) {
        this.slots = slots;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
