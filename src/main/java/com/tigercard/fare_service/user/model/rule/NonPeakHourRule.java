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
import com.tigercard.fare_service.user.model.journey.Zone;

public class NonPeakHourRule implements FareRule {

  private static final org.apache.log4j.Logger log = LogManager.getLogger(NonPeakHourRule.class);

  private Configuration<TimeRangeType, List<DayOfWeekTimeRange>> timeConfiguration =
      TimeRangeConfiguration.createTimeRangeConfiguration();

  private Configuration<String, Fare> fareConfiguration =
      FareConfiguration.createFareConfiguration();

  private PeakHoursRule peakHourRule = new PeakHoursRule();
  private List<DayOfWeekTimeRange> nonpeakHourRanges =
      timeConfiguration.getConfig(TimeRangeType.NONPEAK);

  public boolean isNonPeakHour(Journey journey) {

    if (!peakHourRule.isCriteria() || inNonPeakHourRange(journey)) {

      log.info("Non peak hour rule applied");
      System.out.println("Non peak hour rule applied");
      return true;
    }

    return false;
  }

  private boolean inNonPeakHourRange(Journey journey) {
    boolean inRange = false;
    if (journey.getSource().equals(Zone.ZONE1.name())
        || journey.getDestination().equals(Zone.ZONE1.name())) {
      for (DayOfWeekTimeRange range : nonpeakHourRanges) {
        if (range.inRange(journey.getTime())) {
          inRange = true;
        }
      }
    }

    return inRange;
  }

  @Override
  public boolean shouldRun(Journey journey) {

    return isNonPeakHour(journey);
  }

  @Override
  public double process(Journey journey) {
    String key = journey.getSource() + journey.getDestination();
    double fare = fareConfiguration.getConfig(key).getOffPeakHourFare();
    System.out.println("Time : " + journey.getTime());
    System.out.println(
        "Travelling from "
            + journey.getSource()
            + " to "
            + journey.getDestination()
            + "Peak hour Fare: "
            + fare);
    return fare;
  };
}
