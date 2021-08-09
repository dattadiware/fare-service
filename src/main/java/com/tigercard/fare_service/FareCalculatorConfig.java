package com.tigercard.fare_service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import com.tigercard.fare_service.admin.config.Configuration;
import com.tigercard.fare_service.admin.config.fare.Fare;
import com.tigercard.fare_service.admin.config.fare.FareConfiguration;
import com.tigercard.fare_service.admin.config.timerange.DayOfWeekTimeRange;
import com.tigercard.fare_service.admin.config.timerange.TimeRangeConfiguration;
import com.tigercard.fare_service.admin.config.timerange.TimeRangeType;
import com.tigercard.fare_service.user.model.journey.Zone;

public class FareCalculatorConfig {

  public static void init() {

    Configuration<TimeRangeType, List<DayOfWeekTimeRange>> timeRangeConfiguration =
        TimeRangeConfiguration.createTimeRangeConfiguration();

    List<DayOfWeekTimeRange> peakHourTimeRanges = gePeakHourTimeRange();

    timeRangeConfiguration.config(TimeRangeType.PEAKHOUR, peakHourTimeRanges);

    List<DayOfWeekTimeRange> nonpeakHourTimeRanges = geNonPeakHourTimeRange();

    timeRangeConfiguration.config(TimeRangeType.NONPEAK, nonpeakHourTimeRanges);

    Configuration<String, Fare> fareConfiguration = FareConfiguration.createFareConfiguration();

    String fareConfigurationOne = Zone.ZONE1.toString() + Zone.ZONE1.toString();

    String fareConfigurationTwo = Zone.ZONE1.toString() + Zone.ZONE2.toString();

    String fareConfigurationThree = Zone.ZONE2.toString() + Zone.ZONE1.toString();

    String fareConfigurationFour = Zone.ZONE2.toString() + Zone.ZONE2.toString();

    fareConfiguration.config(
        fareConfigurationOne, new Fare(Zone.ZONE1, Zone.ZONE1, 30.0, 25.0, 100.0, 500.0));
    fareConfiguration.config(
        fareConfigurationTwo, new Fare(Zone.ZONE1, Zone.ZONE2, 35.0, 30.0, 120.0, 600.0));
    fareConfiguration.config(
        fareConfigurationThree, new Fare(Zone.ZONE2, Zone.ZONE1, 35.0, 30.0, 120.0, 600.0));
    fareConfiguration.config(
        fareConfigurationFour, new Fare(Zone.ZONE2, Zone.ZONE2, 25.0, 20.0, 80.0, 400.0));
  }

  private static List<DayOfWeekTimeRange> gePeakHourTimeRange() {

    List<DayOfWeekTimeRange> peakHourTimeRanges =
        Arrays.asList(
            new DayOfWeekTimeRange(
                DayOfWeek.MONDAY, LocalTime.of(7, 30), DayOfWeek.MONDAY, LocalTime.of(10, 30)),
            new DayOfWeekTimeRange(
                DayOfWeek.MONDAY, LocalTime.of(17, 00), DayOfWeek.MONDAY, LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.TUESDAY, LocalTime.of(7, 30), DayOfWeek.TUESDAY, LocalTime.of(10, 30)),
            new DayOfWeekTimeRange(
                DayOfWeek.TUESDAY, LocalTime.of(17, 00), DayOfWeek.TUESDAY, LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.WEDNESDAY,
                LocalTime.of(7, 30),
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30)),
            new DayOfWeekTimeRange(
                DayOfWeek.WEDNESDAY,
                LocalTime.of(17, 00),
                DayOfWeek.WEDNESDAY,
                LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.THURSDAY, LocalTime.of(7, 30), DayOfWeek.THURSDAY, LocalTime.of(10, 30)),
            new DayOfWeekTimeRange(
                DayOfWeek.THURSDAY, LocalTime.of(17, 00), DayOfWeek.THURSDAY, LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.FRIDAY, LocalTime.of(7, 30), DayOfWeek.FRIDAY, LocalTime.of(10, 30)),
            new DayOfWeekTimeRange(
                DayOfWeek.FRIDAY, LocalTime.of(17, 00), DayOfWeek.FRIDAY, LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.SATURDAY, LocalTime.of(9, 00), DayOfWeek.SATURDAY, LocalTime.of(11, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.SATURDAY, LocalTime.of(18, 00), DayOfWeek.SATURDAY, LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                    DayOfWeek.SUNDAY, LocalTime.of(9, 00), DayOfWeek.SUNDAY, LocalTime.of(11, 00)),
                new DayOfWeekTimeRange(
                    DayOfWeek.SUNDAY, LocalTime.of(18, 00), DayOfWeek.SUNDAY, LocalTime.of(22, 00)));

    return peakHourTimeRanges;
  }

  private static List<DayOfWeekTimeRange> geNonPeakHourTimeRange() {

    List<DayOfWeekTimeRange> nopeakHourTimeRanges =
        Arrays.asList(
            new DayOfWeekTimeRange(
                DayOfWeek.MONDAY, LocalTime.of(17, 00), DayOfWeek.FRIDAY, LocalTime.of(20, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.TUESDAY, LocalTime.of(17, 00), DayOfWeek.TUESDAY, LocalTime.of(20, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.WEDNESDAY,
                LocalTime.of(17, 00),
                DayOfWeek.WEDNESDAY,
                LocalTime.of(20, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.THURSDAY, LocalTime.of(17, 00), DayOfWeek.THURSDAY, LocalTime.of(20, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.FRIDAY, LocalTime.of(17, 00), DayOfWeek.FRIDAY, LocalTime.of(20, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.SATURDAY, LocalTime.of(18, 00), DayOfWeek.SATURDAY, LocalTime.of(22, 00)),
            new DayOfWeekTimeRange(
                DayOfWeek.SUNDAY, LocalTime.of(18, 00), DayOfWeek.SUNDAY, LocalTime.of(22, 00)));
    return nopeakHourTimeRanges;
  }
}
