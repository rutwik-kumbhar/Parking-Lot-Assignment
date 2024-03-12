package com.parking.utility;

import com.parking.controller.ParkingController;

public class SingltonObject {

    private static ParkingController parkingController  = null;

    public  static ParkingController getParkingControllerObject(){
        if (parkingController ==  null){
            parkingController = new ParkingController();
        }

        return  parkingController;
    }
}
