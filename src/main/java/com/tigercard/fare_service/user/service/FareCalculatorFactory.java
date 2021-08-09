package com.tigercard.fare_service.user.service;

import com.tigercard.fare_service.user.model.fare.FareCalculatorType;

public class FareCalculatorFactory {

  public FareCalculator getFareCalculator(FareCalculatorType type) {
    FareCalculator fareCalculator = null;
    switch (type) {
      case MONTHLY:
        throw new UnsupportedOperationException();
      case WEEKLY:
        fareCalculator = new WeeklyFareCalcService();
        break;

      default:
        fareCalculator = new WeeklyFareCalcService();
        break;
    }
    return fareCalculator;
  }
}
