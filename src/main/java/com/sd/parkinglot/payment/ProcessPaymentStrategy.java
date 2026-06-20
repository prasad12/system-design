package com.sd.parkinglot.payment;


import com.sd.parkinglot.model.Ticket;

public interface ProcessPaymentStrategy {

    Boolean process(Ticket ticket, Double amount);
}
