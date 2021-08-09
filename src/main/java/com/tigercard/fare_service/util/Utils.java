package com.tigercard.fare_service.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.tigercard.fare_service.user.model.journey.Journey;
import com.tigercard.fare_service.user.model.journey.Zone;

public class Utils {

  public static List<Journey> journeys() {

    return Arrays.asList(
        new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 7, 23, 30))
        );
        
  }
}
