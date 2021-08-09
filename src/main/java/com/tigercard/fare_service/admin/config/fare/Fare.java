package com.tigercard.fare_service.admin.config.fare;

import java.util.ArrayList;
import java.util.List;

import com.tigercard.fare_service.user.model.journey.Zone;

public class Fare {

  private Zone from;

  private Zone to;

  private Double peakHourFare;

  private Double offPeakHourFare;

  private Double dailyCapValue;

  private Double weeklyCapValue;
  
  private List<Fare> fareList= new ArrayList<>();

  public Fare(
      Zone from,
      Zone to,
      Double peakHourFare,
      Double offPeakHourFare,
      Double dailyCapValue,
      Double weeklyCapValue) {
    super();
    this.from = from;
    this.to = to;
    this.peakHourFare = peakHourFare;
    this.offPeakHourFare = offPeakHourFare;
    this.dailyCapValue = dailyCapValue;
    this.weeklyCapValue = weeklyCapValue;
  }
  
  public void add(Fare fare) {
      this.fareList.add(fare);
  }

  public List<Fare> getFareList() {
return fareList;}

public void setFareList(List<Fare> fareList) {
this.fareList = fareList;}

public Zone getFrom() {
    return from;
  }

  public void setFrom(Zone from) {
    this.from = from;
  }

  public Zone getTo() {
    return to;
  }

  public void setTo(Zone to) {
    this.to = to;
  }

  public Double getPeakHourFare() {
    return peakHourFare;
  }

  public void setPeakHourFare(Double peakHourFare) {
    this.peakHourFare = peakHourFare;
  }

  public Double getOffPeakHourFare() {
    return offPeakHourFare;
  }

  public void setOffPeakHourFare(Double offPeakHourFare) {
    this.offPeakHourFare = offPeakHourFare;
  }

  public Double getDailyCapValue() {
    return dailyCapValue;
  }

  public void setDailyCapValue(Double dailyCapValue) {
    this.dailyCapValue = dailyCapValue;
  }

  public Double getWeeklyCapValue() {
    return weeklyCapValue;
  }

  
}
