package com.sd.parkinglot;


import com.sd.parkinglot.enums.PaymentType;
import com.sd.parkinglot.enums.PricingStrategyType;
import com.sd.parkinglot.enums.VehicleType;
import com.sd.parkinglot.factory.PricingStrategyFactory;
import com.sd.parkinglot.factory.VehicleFactory;
import com.sd.parkinglot.model.*;

import java.time.LocalDateTime;

public class ParkingClient {

    public static void main(String[] args) throws Exception{
        EntryGate entryGate = new EntryGate(1);
        ExitGate exitGate = new ExitGate(1);
        /*Map<String,ParkingSpot> parkingSpotMap = createParkingSpots();
        Map<Integer, Ticket> activeTickets = new HashMap<>();*/
        // Parkinglot setup
        ParkingLot parkingLot = ParkingLot.getInstance();
        createParkingSpots(parkingLot);
        parkingLot.setPricingStrategy(PricingStrategyFactory.get(PricingStrategyType.EVENT_BASED));

        //Vehicle and trying to park;
        //Vehicle vehicle = new Car("TS09FB4695");
        Vehicle vehicle = VehicleFactory.create("TS09FB4695", VehicleType.CAR);

        System.out.println(parkingLot.getAvailableCount());

        LocalDateTime entryTime = LocalDateTime.of(2026,6,20,16,15);
        Ticket ticket = entryGate.parkVehicle(vehicle, entryTime);
        //Ticket ticket = parkingLot.parkVehicle(vehicle, LocalDateTime.now());

        System.out.println(ticket);

        System.out.println(parkingLot.getAvailableCount());

        exitGate.unParkVehicle(ticket,LocalDateTime.now(), PaymentType.UPI);
        //parkingLot.unParkVehicle(ticket,LocalDateTime.now());

        System.out.println(ticket);

        System.out.println(parkingLot.getAvailableCount());
    }

    private static void createParkingSpots(ParkingLot parkingLot){
        for(int i=1; i<= 5; i++){
            parkingLot.addSpots(new ParkingSpot(i,true, VehicleType.BIKE));
        }
        for(int i=6; i<= 10; i++){
            parkingLot.addSpots(new ParkingSpot(i,true, VehicleType.CAR));
        }
        for(int i=11; i<= 15; i++){
            parkingLot.addSpots(new ParkingSpot(i,true, VehicleType.TRUCK));
        }
    }
}
