package com.tigercard.fare_service.user.model.fare;

import java.util.List;

import com.tigercard.fare_service.admin.config.fare.FareConfiguration;
import com.tigercard.fare_service.user.model.journey.Journey;

public class DailyFare extends BaseFare {

  private double dailyFare;

  private double dailyCapValue;

  private Journey dailyLongestJourney;

  private Journey weeeklyLongestJourney;

  @Override
  public double calculate(List<Journey> journeys) {

    this.dailyFare = 0.0;

    for (Journey journey : journeys) {

      double fare = super.calculate(journey);

      journey.setFare(fare);

      dailyLongestJourney = journey.longestJourny(journey, dailyLongestJourney);

      weeeklyLongestJourney = dailyLongestJourney;

      this.dailyCapValue =
          FareConfiguration.createFareConfiguration()
              .getConfig(dailyLongestJourney.getSource() + dailyLongestJourney.getDestination())
              .getDailyCapValue();

      if ((this.dailyFare + fare) >= this.dailyCapValue) {
        System.out.println("***** Daily cap reached **** " + this.dailyCapValue);
        this.dailyFare = dailyCapValue;
        break;
      } else {

        this.dailyFare += fare;
      }

      journey.setFare(fare);
    }

    return dailyFare;
  }

  @Override
  public boolean isCapReached(double dailyFareValue) {
    return dailyCapValue > dailyFareValue;
  }

  public double getDailyFare() {
    return dailyFare;
  }

  public void setDailyFare(double dailyFare) {
    this.dailyFare = dailyFare;
  }

  public double getDailyCapValue() {
    return dailyCapValue;
  }

  public void setDailyCapValue(double dailyCapValue) {
    this.dailyCapValue = dailyCapValue;
  }

  public Journey getWeeeklyLongestJourney() {
    return weeeklyLongestJourney;
  }

  public void setWeeeklyLongestJourney(Journey weeeklyLongestJourney) {
    this.weeeklyLongestJourney = weeeklyLongestJourney;
  }
}
