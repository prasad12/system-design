package com.sd.parkinglot.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Ticket {
    Integer ticketId;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    String paymentStatus;
}
