package com.sd.parkinglot.pricing;

import com.sd.parkinglot.enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EventBasedPricing implements PricingStrategy{

    private static Map<VehicleType,Double> priceMap = null;

    static {
        Map<VehicleType, Double> temporaryMap = new HashMap<>();
        temporaryMap.put(VehicleType.CAR, 50.0);
        temporaryMap.put(VehicleType.BIKE, 20.0);
        temporaryMap.put(VehicleType.TRUCK, 70.0);

        priceMap = Collections.unmodifiableMap(temporaryMap);
    }

    @Override
    public double calculateFare(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        long durationMin = Duration.between(entryTime,exitTime).toMinutes();
        long hours = (long) Math.ceil(durationMin/60);

        double ratePerHour = priceMap.getOrDefault(vehicleType,0.0);
        return ratePerHour * hours;
    }
}
