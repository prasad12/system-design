package com.sd.parkinglot.payment;


import com.sd.parkinglot.model.Ticket;

public class UPIPaymentStrategy implements ProcessPaymentStrategy {
    @Override
    public Boolean process(Ticket ticket, Double amount) {
        System.out.println("Paid ₹" + amount + " for ticket " + ticket.getTicketId() + " via UPI.");
        return true;
    }
}
