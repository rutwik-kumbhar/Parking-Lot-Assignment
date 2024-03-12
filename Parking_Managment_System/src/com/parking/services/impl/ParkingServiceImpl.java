package com.parking.services.impl;

import com.parking.dao.ParkingDao;
import com.parking.exceptions.AlreadyExistException;
import com.parking.exceptions.ResourcesNotFoundException;
import com.parking.models.Customer;
import com.parking.models.Floor;
import com.parking.models.Slot;
import com.parking.models.Vehicle;
import com.parking.services.ParkingService;
import com.parking.types.VehicleType;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingServiceImpl implements ParkingService {


    private final ParkingDao parkingDao;


    
    public ParkingServiceImpl() {
        this.parkingDao = new ParkingDao();
    }

    @Override
    public String addFloor(Floor floor) throws AlreadyExistException {
        Set<Floor> floors = parkingDao.getFloors();

        if (!floors.add(floor))
            throw new AlreadyExistException("Floor already exist with give id " + floor.getFloorNumber());

        int totalCapacity = floor.getTwoWheelerCapacity() + floor.getFourWheelerCapacity() + floor.getOtherCapacity();
        int parkedSlotCount = 1;

        for (int i = 1; i <= floor.getTwoWheelerCapacity(); i++) {
            Slot slot = new Slot(parkedSlotCount++, true, VehicleType.TWO_WHEELER, floor.getFloorNumber());
            parkingDao.getSlots().add(slot);
        }

        for (int i = 1; i <= floor.getFourWheelerCapacity(); i++) {
            Slot slot = new Slot(parkedSlotCount++, true, VehicleType.FOUR_WHEELER, floor.getFloorNumber());
            parkingDao.getSlots().add(slot);
        }

        for (int i = 1; i <= floor.getOtherCapacity(); i++) {
            Slot slot = new Slot(parkedSlotCount++, true, VehicleType.OTHER, floor.getFloorNumber());
            parkingDao.getSlots().add(slot);
        }

        floor.setTotalCapacity(totalCapacity);
        floor.setSlots(parkingDao.getSlots());

        System.out.println(floor);

        return "Floor successfully added with slots...!";

    }

    @Override
    public String getFloor(int floorNumber) throws ResourcesNotFoundException {
         if (parkingDao.getFloors().isEmpty())throw  new ResourcesNotFoundException("Floor is not available");
        Floor floor = parkingDao.floors.stream().filter((f -> f.getFloorNumber() == floorNumber)).toList().get(0);
        if (floor == null) throw new ResourcesNotFoundException("Floor Not Found Give Floor Number" + floorNumber);
        System.out.println(floor);
        return "Floor Getting Successfully...!";
    }

    @Override
    public String getAllFloor() {
        Set<Floor> floors = parkingDao.getFloors();
        System.out.println(floors);
        return "All Floors Getting Successfully";
    }

    @Override
    public String updateFloor(int floorNumber, Floor floor) throws ResourcesNotFoundException {
        Floor existFloor = parkingDao.floors.stream().filter((f -> f.getFloorNumber() == floorNumber)).toList().get(0);
        if (existFloor == null) throw new ResourcesNotFoundException("Floor Not Found Give Floor Number" + floorNumber);

        existFloor.setTwoWheelerCapacity(floor.getTwoWheelerCapacity());
        existFloor.setFourWheelerCapacity(floor.getFourWheelerCapacity());
        existFloor.setOtherCapacity(floor.getOtherCapacity());
        existFloor.setTotalCapacity(floor.getTwoWheelerCapacity() + floor.getFourWheelerCapacity() + floor.getOtherCapacity());

        return "Floor Updated Successfully ";
    }

    @Override
    public String deleteFloor(int floorNumber) throws ResourcesNotFoundException {
        Floor floor = parkingDao.floors.stream().filter(f -> f.getFloorNumber() == floorNumber).collect(Collectors.toList()).get(0);
        if (floor == null) throw new ResourcesNotFoundException("Floor Not Found Give Floor Number" + floorNumber);
        parkingDao.getFloors().remove(floor);
        return "Floor Deleted Successfully ";
    }

    @Override
    public Slot getSlot(int floorNumber) throws ResourcesNotFoundException {
        return null;
    }

    @Override
    public String addVehicle(Vehicle vehicle, Customer customer) {

        parkingDao.getCustomers().add(customer);

        Floor floor = null;

       VehicleType vehicleType =  vehicle.getVehicleType();

        if (vehicleType == VehicleType.valueOf("TWO_WHEELER")){

           floor =  parkingDao.getFloors().stream().filter((f)-> f.getParkCount() < f.getTotalCapacity() && f.getTwoWheelerParkCount() < f.getTwoWheelerParkCount()).toList().get(0);
           Slot slot =  floor.getSlots().stream().filter(s-> !s.isPark()).toList().get(0);
           slot.setPark(false);
           slot.setFloorId(floor.getFloorNumber());
           slot.setVehicleType(vehicleType);

           floor.setTwoWheelerCapacity(floor.getTwoWheelerCapacity()+1);

           vehicle.setSlotId(slot.getSlotId());
            vehicle.setPerHrsPrice(10);

        }else if (vehicleType == VehicleType.valueOf("FOUR_WHEELER")){

            floor =  parkingDao.getFloors().stream().filter((f)-> f.getParkCount() < f.getTotalCapacity() && f.getFourWheelerParkCount() < f.getFourWheelerParkCount()).toList().get(0);
            Slot slot =  floor.getSlots().stream().filter(s-> !s.isPark()).toList().get(0);
            slot.setPark(false);
            slot.setFloorId(floor.getFloorNumber());
            slot.setVehicleType(vehicleType);

            floor.setFourWheelerCapacity(floor.getFourWheelerCapacity()+1);

            vehicle.setSlotId(slot.getSlotId());
            vehicle.setPerHrsPrice(20);

        }else{

            floor =  parkingDao.getFloors().stream().filter((f)-> f.getParkCount() < f.getTotalCapacity() && f.getOtherParkCount() < f.getOtherParkCount()).toList().get(0);
            Slot slot =  floor.getSlots().stream().filter(s-> !s.isPark() ).toList().get(0);
            slot.setPark(false);
            slot.setFloorId(floor.getFloorNumber());
            slot.setVehicleType(vehicleType);

            floor.setOtherCapacity(floor.getOtherCapacity()+1);

            vehicle.setSlotId(slot.getSlotId());
            vehicle.setPerHrsPrice(30);

        }

        if (floor == null ){
            throw new ResourcesNotFoundException("Currently Slot Not Available For Parking");
        }

        floor.setParkCount(floor.getParkCount()+1);


        vehicle.setCustomerId(customer.getId());

        return "Vehicle Added Successfully";
    }

    @Override
    public String removeVehicle(String vehicleNumber) {

       Vehicle vehicle =  parkingDao.getVehicles().stream().filter(v-> v.getVehicleNumber().equalsIgnoreCase(vehicleNumber) ).toList().get(0);

     Slot slot =   parkingDao.getSlots().stream().filter(s-> s.getSlotId() == vehicle.getSlotId()).toList().get(0);
     slot.setPark(true);
     slot.setVehicleType(vehicle.getVehicleType());

        LocalTime currentTime = LocalTime.now();

        int hour = vehicle.getParkDateTime().getHour();
        int minute = vehicle.getParkDateTime().getMinute();
        int second = vehicle.getParkDateTime().getSecond();

        LocalTime parkedTime  = LocalTime.of(hour, minute, second);



        Duration duration=  Duration.between(parkedTime,currentTime);
        long parkedDuration = duration.toHours();
        int totalPrice =  vehicle.getPerHrsPrice()*(int)parkedDuration;


        return "Vehicle Remove Successfully Remove from Parking Your Cost Rs." + totalPrice;
    }

    @Override
    public String checkParkingSlot() {
        List<Slot> slots =  parkingDao.getSlots().stream().filter(Slot::isPark).toList();
        System.out.println(slots);
        return "Slots Getting Successfully";
    }

    @Override
    public String checkParkingSlotByVehicleType(String vehicleType) {
        List<Slot> slots =  parkingDao.getSlots().stream().filter(s-> s.isPark() && VehicleType.valueOf(vehicleType) == s.getVehicleType()).toList();
        System.out.println(slots);
        return "Getting Parking Slot Successfully";
    }
}
