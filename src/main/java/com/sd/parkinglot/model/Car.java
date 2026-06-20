package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
