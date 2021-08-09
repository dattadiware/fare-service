package com.tigercard.fare_service;

import java.util.UUID;

import com.tigercard.fare_service.user.model.User;
import com.tigercard.fare_service.user.model.fare.FareCalculatorType;
import com.tigercard.fare_service.user.model.fare.FareReport;
import com.tigercard.fare_service.user.service.FareCalculator;
import com.tigercard.fare_service.user.service.FareCalculatorFactory;
import com.tigercard.fare_service.util.Utils;

/**
 * 
 * @author datta
 *
 */

public class FareCalculatorApp {

  public static void main(String args[]) {

    FareCalculatorConfig.init();

    User user = new User();
    user.setId(UUID.randomUUID());
    user.setJourneys(Utils.journeys());

    FareCalculatorFactory factory = new FareCalculatorFactory();

    FareCalculator fareCalculator = factory.getFareCalculator(FareCalculatorType.WEEKLY);
    FareReport fareReport = fareCalculator.calculate(user);

    System.out.println(fareReport);
  }
}
