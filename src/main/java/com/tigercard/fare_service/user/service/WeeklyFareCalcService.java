package com.tigercard.fare_service.user.service;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.tigercard.fare_service.user.model.User;
import com.tigercard.fare_service.user.model.fare.WeeklyFare;
import com.tigercard.fare_service.user.model.fare.FareReport;

/** @author datta */

public class WeeklyFareCalcService implements FareCalculator {

  private Logger log = Logger.getLogger(WeeklyFareCalcService.class);

  private WeeklyFare weeklyFare = new WeeklyFare();

  private FareReport fareReport;

  /** return weekly {@link FareReport} for the given user's jo */
  
  @Override
  public FareReport calculate(User user) {
    Objects.nonNull(user);
    Objects.nonNull(user.getjourneys());

    fareReport = new FareReport();

    double totolFare = this.weeklyFare.calculate(user.getjourneys());
    fareReport.setUser(user);
    fareReport.setTotalFare(totolFare);

    log.info(fareReport.getTotalFare());
    return fareReport;
  }
}
