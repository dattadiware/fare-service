package com.tigercard.fare_service.admin.config.timerange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tigercard.fare_service.admin.config.Configuration;



public class TimeRangeConfiguration
    implements Configuration<TimeRangeType, List<DayOfWeekTimeRange>> {

  Map<String, List<DayOfWeekTimeRange>> timeRangesMap = new HashMap<>();

  private static TimeRangeConfiguration timeRangeConfiguration;

  public static TimeRangeConfiguration createTimeRangeConfiguration() {

    if (null == timeRangeConfiguration) {
      timeRangeConfiguration = new TimeRangeConfiguration();
    }

    return timeRangeConfiguration;
  }

  private TimeRangeConfiguration() {}

  @Override
  public void config(TimeRangeType k, List<DayOfWeekTimeRange> v) {

    timeRangesMap.put(k.toString(), v);
  }

  @Override
  public List<DayOfWeekTimeRange> getConfig(TimeRangeType k) {
    return this.timeRangesMap.get(k.name());
  }
}
