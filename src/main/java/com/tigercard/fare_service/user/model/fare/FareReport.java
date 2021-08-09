package com.tigercard.fare_service.user.model.fare;

import com.tigercard.fare_service.user.model.User;

public class FareReport {

  private User user;

  private double totalFare;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public double getTotalFare() {
    return totalFare;
  }

  public void setTotalFare(double totalFare) {
    this.totalFare = totalFare;
  }
}
