package com.sd.parkinglot.factory;

import com.sd.parkinglot.enums.PricingStrategyType;
import com.sd.parkinglot.pricing.EventBasedPricing;
import com.sd.parkinglot.pricing.PricingStrategy;
import com.sd.parkinglot.pricing.TimeBasedPricing;

public class PricingStrategyFactory {

    public static PricingStrategy get(PricingStrategyType pricingStrategyType){
        switch (pricingStrategyType){
            case TIME_BASED:
                return new TimeBasedPricing();
            case EVENT_BASED:
                return new EventBasedPricing();
        }
        return null;
    }
}
