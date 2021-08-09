package com.tigercard.fare_service.user.model.fare;

import java.util.List;

import com.tigercard.fare_service.user.model.journey.Journey;
import com.tigercard.fare_service.user.model.rule.FareRuleValidator;

public abstract class BaseFare implements Fare {

  private FareRuleValidator ruleEngine = new FareRuleValidator();

  public double calculate(Journey journey) {

    return ruleEngine
        .getFareRules()
        .stream()
        .filter(r -> r.shouldRun(journey))
        .map(r -> r.process(journey))
        .findFirst()
        .get();
  }

  public abstract double calculate(List<Journey> journeys);

  abstract boolean isCapReached(double capValue);
}
