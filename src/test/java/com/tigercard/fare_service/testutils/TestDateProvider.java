package com.tigercard.fare_service.testutils;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.tigercard.fare_service.user.model.User;
import com.tigercard.fare_service.user.model.journey.Journey;
import com.tigercard.fare_service.user.model.journey.Zone;

public class TestDateProvider {

  public static User mockUserListOfJourney() {
    User user = new User();
    user.setJourneys(
        Arrays.asList(
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 7, 7, 35)),
            new Journey(Zone.ZONE1, Zone.ZONE2, LocalDateTime.of(2021, 06, 8, 23, 30)),
            new Journey(Zone.ZONE2, Zone.ZONE1, LocalDateTime.of(2021, 06, 8, 20, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 9, 21, 30)),
            new Journey(Zone.ZONE2, Zone.ZONE2, LocalDateTime.of(2021, 06, 10, 3, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 10, 5, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE2, LocalDateTime.of(2021, 06, 10, 11, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 11, 12, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE2, LocalDateTime.of(2021, 06, 12, 13, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 12, 21, 30))));
    return user;
  }

  public static User mockUserWithListOfJourneyForDailyCap() {
    User user = new User();
    user.setJourneys(
        Arrays.asList(
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 7, 7, 35)),
            new Journey(Zone.ZONE1, Zone.ZONE2, LocalDateTime.of(2021, 06, 7, 23, 30)),
            new Journey(Zone.ZONE2, Zone.ZONE1, LocalDateTime.of(2021, 06, 7, 20, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 7, 21, 30)),
            new Journey(Zone.ZONE2, Zone.ZONE2, LocalDateTime.of(2021, 06, 7, 3, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 8, 7, 35)),
            new Journey(Zone.ZONE1, Zone.ZONE2, LocalDateTime.of(2021, 06, 8, 23, 30)),
            new Journey(Zone.ZONE2, Zone.ZONE1, LocalDateTime.of(2021, 06, 8, 20, 30)),
            new Journey(Zone.ZONE1, Zone.ZONE1, LocalDateTime.of(2021, 06, 8, 21, 30)),
            new Journey(Zone.ZONE2, Zone.ZONE2, LocalDateTime.of(2021, 06, 8, 3, 30))));
    return user;
  }
}
