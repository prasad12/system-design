package com.sd.parkinglot.payment;


import com.sd.parkinglot.model.Ticket;

public class PaymentProcessor {

    private final ProcessPaymentStrategy processPaymentStrategy;

    public PaymentProcessor(ProcessPaymentStrategy processPaymentStrategy){
        this.processPaymentStrategy = processPaymentStrategy;
    }

    public Boolean processPayment(Ticket ticket, Double amount){
        Boolean status = processPaymentStrategy.process(ticket,amount);
        if (status) {
            ticket.setPaymentStatus("SUCCESS");
        } else {
            ticket.setPaymentStatus("FAILED");
            System.out.println("Payment failed for ticket: " + ticket.getTicketId());
        }
        return status;
    }
}
