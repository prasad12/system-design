package com.sd.parkinglot.factory;


import com.sd.parkinglot.enums.VehicleType;
import com.sd.parkinglot.model.Bike;
import com.sd.parkinglot.model.Car;
import com.sd.parkinglot.model.Truck;
import com.sd.parkinglot.model.Vehicle;

public class VehicleFactory {

    public static Vehicle create(String number, VehicleType vehicleType){
         switch (vehicleType){
            case CAR:
                return new Car(number);
             case BIKE:
                return new Bike(number);
             case TRUCK:
                return new Truck(number);
         }
        return null;
    }
}
