package com.sd.parkinglot.model;


import com.sd.parkinglot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
}
