package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber, VehicleType.BIKE);
    }
}
