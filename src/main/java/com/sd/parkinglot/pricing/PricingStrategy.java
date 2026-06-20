package com.sd.parkinglot.pricing;

import com.sd.parkinglot.enums.VehicleType;

import java.time.LocalDateTime;

public interface PricingStrategy {

    double calculateFare(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
