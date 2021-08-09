package com.tigercard.fare_service.user.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.tigercard.fare_service.FareCalculatorConfig;
import com.tigercard.fare_service.testutils.TestDateProvider;
import com.tigercard.fare_service.user.model.fare.FareReport;

public class WeeklyFareCalcServiceTest {

  private WeeklyFareCalcService fareCalculatorService = new WeeklyFareCalcService();

  @Before
  public void init() {}

  @Test
  public void shouldReturnWeeklyFare() {
    FareCalculatorConfig.init();
    FareReport fare = fareCalculatorService.calculate(TestDateProvider.mockUserListOfJourney());
    assertTrue(fare.getTotalFare() == 285.0);
    
  }
  
  @Test
  public void shouldReturn_weeklyFare_when_dailyCap_reached() {
    FareCalculatorConfig.init();
    FareReport fare = fareCalculatorService.calculate(TestDateProvider.mockUserWithListOfJourneyForDailyCap());
   
    assertTrue(fare.getTotalFare() == 240.0);
  }
}
