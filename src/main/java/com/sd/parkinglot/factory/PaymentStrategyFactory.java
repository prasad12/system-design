package com.sd.parkinglot.factory;

import com.sd.parkinglot.enums.PaymentType;
import com.sd.parkinglot.payment.CreditCardPaymentStrategy;
import com.sd.parkinglot.payment.DebitCardPaymentStrategy;
import com.sd.parkinglot.payment.ProcessPaymentStrategy;
import com.sd.parkinglot.payment.UPIPaymentStrategy;

public class PaymentStrategyFactory {

    public static ProcessPaymentStrategy process(PaymentType paymentType){
        switch (paymentType){
            case UPI:
                return new UPIPaymentStrategy();
            case CREDIT:
                return new CreditCardPaymentStrategy();
            case DEBIT:
                return new DebitCardPaymentStrategy();
        }
        return null;
    }
}
