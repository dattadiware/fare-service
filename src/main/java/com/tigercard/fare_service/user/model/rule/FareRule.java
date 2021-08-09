package com.tigercard.fare_service.user.model.rule;

import com.tigercard.fare_service.user.model.journey.Journey;

public interface FareRule {
    
    public boolean shouldRun(Journey trip);
    
    public double process(Journey trip);
    
}
