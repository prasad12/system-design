package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParkingSpot {
    Integer spotId;
    Boolean isAvailable;
    VehicleType allowedType;

    //park
    public void tryOccupy(){
        isAvailable = false;
    }
    //unpark
    public void vacant(){
        isAvailable = true;
    }

    public Boolean getIsAvailable(){
        return isAvailable;
    }
}
