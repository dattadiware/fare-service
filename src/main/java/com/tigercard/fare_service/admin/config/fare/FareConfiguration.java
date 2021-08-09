package com.tigercard.fare_service.admin.config.fare;

import java.util.HashMap;
import java.util.Map;

import com.tigercard.fare_service.admin.config.Configuration;

public class FareConfiguration implements Configuration<String, Fare> {

  private static FareConfiguration fareConfiguration;

  public static FareConfiguration createFareConfiguration() {

    if (null == fareConfiguration) {
      fareConfiguration = new FareConfiguration();
    }

    return fareConfiguration;
  }

  Map<String, Fare> fareConfigMap = new HashMap<>();

  @Override
  public void config(String k, Fare v) {

    fareConfigMap.put(k, v);
  }

  @Override
  public Fare getConfig(String k) { // TODO Auto-generated method stub
    return this.fareConfigMap.get(k);
  }
}
