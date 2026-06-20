package com.sd.parkinglot;

import com.sd.parkinglot.enums.PaymentType;
import com.sd.parkinglot.factory.PaymentStrategyFactory;
import com.sd.parkinglot.model.ParkingSpot;
import com.sd.parkinglot.model.Ticket;
import com.sd.parkinglot.model.Vehicle;
import com.sd.parkinglot.payment.PaymentProcessor;
import com.sd.parkinglot.payment.ProcessPaymentStrategy;
import com.sd.parkinglot.pricing.PricingStrategy;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLot {

    private static final ParkingLot INSTANCE = new ParkingLot();

    private final Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
    private final Map<Integer, Ticket> activeTickets = new HashMap<>();

    @Setter
    private PricingStrategy pricingStrategy;

    public static ParkingLot getInstance(){
        return INSTANCE;
    }

    public void addSpots(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getSpotId(),parkingSpot);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        Optional<ParkingSpot> spot = parkingSpotMap.values().stream().filter(sp -> sp.getAllowedType().name().equalsIgnoreCase(vehicle.getVehicleType().name()))
                            .filter(sp -> sp.getIsAvailable().equals(true)).findFirst();
        if(spot.get() != null){
            spot.get().tryOccupy();
            Ticket ticket = Ticket.builder().ticketId(101).parkingSpot(spot.get()).vehicle(vehicle).entryTime(entryTime).build();
            activeTickets.put(ticket.getTicketId(),ticket);
            return ticket;
        }
        return null;
    }

    public Long getAvailableCount(){
        return parkingSpotMap.values().stream().filter(sp -> sp.getIsAvailable().equals(true)).count();
    }

    public void unParkVehicle(Ticket ticket, LocalDateTime exitTime, PaymentType paymentType){
        double fee = pricingStrategy.calculateFare(ticket.getVehicle().getVehicleType(), ticket.getEntryTime(),exitTime);

        System.out.println("==>Parking Fee: "+fee+"<==");

        ProcessPaymentStrategy paymentStrategy = PaymentStrategyFactory.process(paymentType);
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
        paymentProcessor.processPayment(ticket,fee);

        Optional<ParkingSpot> spot =  parkingSpotMap.values().stream().filter(sp -> sp.getSpotId().equals(ticket.getParkingSpot().getSpotId())).findFirst();
        if(spot.get() != null){
            spot.get().vacant();
            activeTickets.remove(ticket.getTicketId());
        }
    }
}
