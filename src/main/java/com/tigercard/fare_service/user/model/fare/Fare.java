package com.tigercard.fare_service.user.model.fare;

import java.util.List;

import com.tigercard.fare_service.user.model.journey.Journey;

public interface Fare {

  double calculate(List<Journey> trips);
}
