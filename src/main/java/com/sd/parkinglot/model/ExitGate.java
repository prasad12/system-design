package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.GateType;
import com.sd.parkinglot.ParkingLot;
import com.sd.parkinglot.enums.PaymentType;

import java.time.LocalDateTime;

public class ExitGate extends Gate {
    public ExitGate(Integer id) {
        super(id);
    }

    @Override
    public GateType getType() {
        return GateType.EXIT;
    }

    public void unParkVehicle(Ticket ticket, LocalDateTime exitTime, PaymentType paymentType){
        ParkingLot.getInstance().unParkVehicle(ticket,exitTime, paymentType);
    }
}
