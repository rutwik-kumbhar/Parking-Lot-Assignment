# Parking-Lot-Assignment

A Parking Management System efficiently organizes and monitors parking spaces, providing users with real-time availability information. It optimizes parking utilization, streamlines entry and exit processes, and enhances overall security through surveillance and automated payment systems.

## Key Features:

Space Tracking: Real-time monitoring for available parking spots, minimizing search time.
Payment Automation: Integration of mobile apps or kiosks for streamlined payments.
Entry/Exit Automation: Automated gates or plate recognition for smoother traffic flow.

## Project Type
Java Console Based Project 

## Tech-Stacks:
    - Java (8 or Above Version )

## Implementation Methods 

### Floor 
      -String addFloor(Floor floor) throws AlreadyExistException;
      -String getFloor(int floorNumber) throws ResourcesNotFoundException;
      -String getAllFloor();
      -String updateFloor(int floorNumber, Floor floor) throws ResourcesNotFoundException;
      -String deleteFloor(int floorNumber) throws ResourcesNotFoundException;
      
### Parking 
      -Slot getSlot(int floorNumber) throws ResourcesNotFoundException;
      -String addVehicle(Vehicle vehicle, Customer customer);
      -String removeVehicle(String vehicleNumber);
      -String checkParkingSlot();
      -String checkParkingSlotByVehicleType(String vehicleType);
    
## Directory Structure
<pre> 
parking_Managment_System/ 
   ├─ src/
       ├─ com.parking/ 
          ├─ models  
          ├─ controller 
          ├─ service (interface) 
                    ├─ impl (implemented classes)
          ├─ controller
          ├─ exceptions
          ├─ dao
          ├─ types
          ├─ utility
      ├─ Main.java 
</pre>

## Main File

- **Main.java**: This is the main entry point of the application.

## Setup
- Install Java Development Kit (JDK):
- Set up an Integrated Development Environment (IDE)

    
