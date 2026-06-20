package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String vehicleNumber) {
        super(vehicleNumber, VehicleType.TRUCK);
    }
}
