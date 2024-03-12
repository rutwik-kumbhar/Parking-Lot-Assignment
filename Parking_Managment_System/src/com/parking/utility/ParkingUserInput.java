package com.parking.utility;

import com.parking.controller.ParkingController;
import com.parking.models.Customer;
import com.parking.models.Vehicle;
import com.parking.types.VehicleType;

import java.util.Scanner;

public class ParkingUserInput {

    private static final ParkingController parkingController = SingltonObject.getParkingControllerObject();

    private static Scanner input = MainAppInput.getScannerClass();

    public static void parkingOperationMenu() {
        System.out.println("Parking Related Operation : ");

        String operations = """
                1. Add Vehicle\s
                2. Remove Vehicle From The Parking\s
                3. Check Parking Slot \s
                4. Check Parking Slot By Vehicle \s
                """;
        System.out.println(operations);

    }


    private int id;
    private String firstName;

    private String lastName;

    private String mobileNumber;
    public static  void addVehicle(){

        System.out.print("Enter Customer ID: ");
        int customerId = input.nextInt();

        System.out.println("Enter FirstName : ");
        String firstName = input.next();

        System.out.println("Enter LastName : ");
        String lastName = input.next();

        System.out.println("Enter Mobile Number  : ");
        String number = input.next();

        System.out.print("Enter Vehicle ID: ");
        int vehicleId = input.nextInt();

        System.out.print("Enter Vehicle Name: ");
        String vehicleName = input.next();

        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = input.next();

        System.out.print("Enter Vehicle Type (TWO_WHEELER , FOUR_WHEELER , OTHER): ");
        VehicleType vehicleType = VehicleType.valueOf(input.next().toUpperCase());

        Customer customer = new Customer(customerId,firstName,lastName,number);

        Vehicle vehicle = new Vehicle(vehicleId,vehicleName,vehicleNumber,vehicleType);
        String message = parkingController.addVehicle(vehicle,customer);
        System.out.println(message);

    }

    public  static  void removeVehicle(){
        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = input.next();

        String message =  parkingController.removeVehicle(vehicleNumber);
        System.out.println(message);
    }

    public  static  void checkParkingSlot(){
       String message =  parkingController.checkParkingSlot();
       System.out.println(message);
    }

    public  static  void  checkParkingSlotByVehicleType(){
        System.out.print("Enter Vehicle Type (TWO_WHEELER , FOUR_WHEELER , OTHER): ");
        VehicleType vehicleType = VehicleType.valueOf(input.next().toUpperCase());
        String message =  parkingController.checkParkingSlotByVehicleType(vehicleType.name());
        System.out.println(message);
    }




}
