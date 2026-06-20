package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.GateType;
import com.sd.parkinglot.ParkingLot;

import java.time.LocalDateTime;

public class EntryGate extends Gate{
    public EntryGate(Integer id) {
        super(id);
    }

    @Override
    public GateType getType() {
        return GateType.ENTRY;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return ParkingLot.getInstance().parkVehicle(vehicle, entryTime);
    }
}
