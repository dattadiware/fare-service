package com.tigercard.fare_service.user.service;

import com.tigercard.fare_service.user.model.User;
import com.tigercard.fare_service.user.model.fare.FareReport;

public interface FareCalculator {
    
   public FareReport calculate(User user) ;
    
}
