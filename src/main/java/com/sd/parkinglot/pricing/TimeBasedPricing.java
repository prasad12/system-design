package com.sd.parkinglot.pricing;

import com.sd.parkinglot.enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeBasedPricing implements PricingStrategy{

    private static final LocalTime PEAK_HOUR_START = LocalTime.of(8,0);
    private static final LocalTime PEAK_HOUR_END = LocalTime.of(17, 0);

    private Boolean isPeakHour(LocalTime localTime){
        return localTime.isAfter(PEAK_HOUR_START) && localTime.isBefore(PEAK_HOUR_END);
    }

    @Override
    public double calculateFare(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        if(exitTime.isBefore(entryTime)){
            throw new IllegalArgumentException("Exit time is before entry time");
        }

        long durationInMinutes = Duration.between(entryTime,entryTime).toMinutes();
        long durationInHours = (long) Math.ceil(durationInMinutes/60);

        int peakHour = 0;
        int nonPeakHour = 0;

        //LocalDateTime localDateTime = entryTime.;
        for(int i=0;i<durationInHours;i++){
            LocalTime localTime = entryTime.toLocalTime();
            if(isPeakHour(localTime))
                peakHour++;
            else
                nonPeakHour++;
        }

        double peakHourRate = fetchPeakHourRate(vehicleType);
        double nonPeakHourRate = fetchNonPeakHourRate(vehicleType);

        return peakHour * peakHourRate + nonPeakHourRate * nonPeakHour;
    }


    private double fetchPeakHourRate(VehicleType vehicleType){
        switch (vehicleType){
            case CAR:
                return 50.0;
            case BIKE:
                return 20.0;
            case TRUCK:
                return 70.0;
        }
        return 0.0;
    }

    private double fetchNonPeakHourRate(VehicleType vehicleType){
        switch (vehicleType){
            case CAR:
                return 40.0;
            case BIKE:
                return 10.0;
            case TRUCK:
                return 60.0;
        }
        return 0.0;
    }
}
