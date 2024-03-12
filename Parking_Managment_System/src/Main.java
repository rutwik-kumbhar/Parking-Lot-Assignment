import com.parking.controller.ParkingController;
import com.parking.utility.FloorUserInput;
import com.parking.utility.MainAppInput;
import com.parking.utility.ParkingUserInput;

import java.util.Scanner;


public class Main {




    public static String greeting() {
        return "\n ****** Welcome To Parking Management System ****** \n";
    }

    public static String closeApp() {
        return "\n ****** Thank Your Out Service ****** \n";
    }

    public static void init() {

    }

    public static void main(String[] args) {

        Scanner input = MainAppInput.getScannerClass();

        System.out.println(Main.greeting());


        while (true) {

            MainAppInput.appMenu();

            System.out.print("Enter You Choice : ");
            int choice = input.nextInt();


            switch (choice) {
                case 1:
                    FloorUserInput.floorOperationsMenu();
                    System.out.print("Perform Action Press Above Option  : ");
                    int option = input.nextInt();
                    switch (option) {
                        case 1:
                            FloorUserInput.addFloor();
                            break;
                        case 2:
                            FloorUserInput.getFloor();
                            break;
                        case 3:
                            FloorUserInput.getFloors();
                            break;
                        case 4:
                            FloorUserInput.updateFloor();
                            break;
                        case 5:
                            FloorUserInput.deleteFloor();
                            break;
                        case 6:
                            FloorUserInput.floorOperationsMenu();
                            break;
                        case 7:
                            MainAppInput.appMenu();
                            break;
                        default:
                            System.out.println("Invalid Input...! Please Restart Application And Enter Valid Input");
                            break;
                    }
                    break;
                case 2:
                    ParkingUserInput.parkingOperationMenu();
                    System.out.print("Perform Action Press Above Option  : ");
                    int parkingUserOption = input.nextInt();
                    switch (parkingUserOption){
                        case 1:
                            ParkingUserInput.addVehicle();
                            break;
                        case 2:
                            ParkingUserInput.removeVehicle();
                            break;
                        case 3:
                            ParkingUserInput.checkParkingSlot();
                            break;
                        case 4:
                            ParkingUserInput.checkParkingSlotByVehicleType();
                            break;
                        default:
                            System.out.println("Invalid Input...! Please Restart Application And Enter Valid Input");
                            break;
                    }
                    break;
                case 3:
                    System.out.println(Main.closeApp());
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input...! Please Restart Application And Enter Valid Input");
                    break;
            }


        }
    }
}