package com.parking.utility;


import com.parking.controller.ParkingController;
import com.parking.models.Floor;

import java.util.Scanner;

public class FloorUserInput {

    private static final ParkingController parkingController = SingltonObject.getParkingControllerObject();
    public static Scanner input = MainAppInput.getScannerClass();

    public static void floorOperationsMenu() {
        System.out.println("Floor Related Operations ");
        String operations = """
                1. Add Floor\s
                2. Get Floor By Floor Number\s
                3. Get All Floors  \s
                4. Update Floor Details By Floor Number \s
                5. Delete Floor  \s
                6. Go To Previous Menu \s
                7. Go To Main Menu\s
                """;
        System.out.println(operations);
    }


    public static void addFloor() {
        System.out.print("Enter Floor Number : ");
        int floorNumber = input.nextInt();

        System.out.print("Enter Two Wheeler Capacity  : ");
        int twoWheelerCapacity = input.nextInt();

        System.out.print("Enter Two Four Capacity  : ");
        int fourWheelerCapacity = input.nextInt();


        System.out.print("Enter Two Other Capacity  : ");
        int otherCapacity = input.nextInt();

        Floor floor = new Floor(floorNumber, twoWheelerCapacity, fourWheelerCapacity, otherCapacity);

        String message = parkingController.addFloor(floor);
        System.out.println(message);
    }

    public static void getFloor() {
        System.out.print("Enter Floor Number : ");
        int floorNumber = input.nextInt();
        String message = parkingController.getFloorById(floorNumber);
        System.out.println(message);
    }

    public static void getFloors() {
        String message = parkingController.getAllFloors();
        System.out.println(message);
    }

    public static void updateFloor() {
        System.out.print("Enter Floor Number : ");
        int floorNumber = input.nextInt();

        System.out.print("Enter Two Wheeler Capacity  : ");
        int twoWheelerCapacity = input.nextInt();

        System.out.print("Enter Two Four Capacity  : ");
        int fourWheelerCapacity = input.nextInt();


        System.out.print("Enter Two Other Capacity  : ");
        int otherCapacity = input.nextInt();

        Floor floor = new Floor(twoWheelerCapacity, fourWheelerCapacity, otherCapacity);

        String message = parkingController.updateFloors(floorNumber, floor);
        System.out.println(message);
    }

    public static void deleteFloor() {
        System.out.print("Enter Floor Number : ");
        int floorNumber = input.nextInt();

        String message = parkingController.deleteFloor(floorNumber);

        System.out.println(message);
    }

}
