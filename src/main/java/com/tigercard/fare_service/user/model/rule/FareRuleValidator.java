package com.tigercard.fare_service.user.model.rule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FareRuleValidator {

  private List<FareRule> fareRules;

  public FareRuleValidator() {
    this.fareRules =
        Collections.unmodifiableList(Arrays.asList(new PeakHoursRule(), new NonPeakHourRule()));
  }

  public FareRuleValidator(List<FareRule> fareRules) {
    this.fareRules = fareRules;
  }

  public List<FareRule> getFareRules() {
    return fareRules;
  }

  public void add(FareRule fareRule) {
    fareRules.add(fareRule);
  }

  public void remove(FareRule fareRule) {
    fareRules.remove(fareRule);
  }

  public void setFareRules(List<FareRule> fareRules) {
    this.fareRules = fareRules;
  }
}
