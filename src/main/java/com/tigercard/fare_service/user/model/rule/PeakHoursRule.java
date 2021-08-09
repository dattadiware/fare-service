package com.tigercard.fare_service.user.model.rule;

import java.util.List;

import org.apache.log4j.LogManager;

import com.tigercard.fare_service.admin.config.Configuration;
import com.tigercard.fare_service.admin.config.fare.Fare;
import com.tigercard.fare_service.admin.config.fare.FareConfiguration;
import com.tigercard.fare_service.admin.config.timerange.DayOfWeekTimeRange;
import com.tigercard.fare_service.admin.config.timerange.TimeRangeConfiguration;
import com.tigercard.fare_service.admin.config.timerange.TimeRangeType;
import com.tigercard.fare_service.user.model.journey.Journey;

public class PeakHoursRule implements FareRule {

  private static final org.apache.log4j.Logger log = LogManager.getLogger(PeakHoursRule.class);

  private Configuration<TimeRangeType, List<DayOfWeekTimeRange>> timeConfiguration =
      TimeRangeConfiguration.createTimeRangeConfiguration();

  private Configuration<String, Fare> fareConfiguration =
      FareConfiguration.createFareConfiguration();

  private boolean criteria;

  public PeakHoursRule() {}

  public boolean isPeakHour(Journey journey) {

    for (DayOfWeekTimeRange range : timeConfiguration.getConfig(TimeRangeType.PEAKHOUR)) {

      if (range.inRange(journey.getTime())) {
        log.info("Peak hour rule applied");
        this.setCriteria(true);
        System.out.println("Peak hour rule applied");

        return true;
      }
    }

    return false;
  }

  public boolean isCriteria() {
    return criteria;
  }

  public void setCriteria(boolean criteria) {
    this.criteria = criteria;
  }

  @Override
  public boolean shouldRun(Journey journey) {
    return isPeakHour(journey);
  }

  @Override
  public double process(Journey journey) {

    String key = journey.getSource() + journey.getDestination();
    double fare = fareConfiguration.getConfig(key).getPeakHourFare();
    System.out.println("Time : " + journey.getTime());
    System.out.println(
        "Travelling from "
            + journey.getSource()
            + " to "
            + journey.getDestination()
            + "Peak hour Fare: "
            + fare);
    return fare;
  }
}
