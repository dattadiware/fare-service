package com.tigercard.fare_service.user.model.fare;

import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.tigercard.fare_service.admin.config.fare.FareConfiguration;
import com.tigercard.fare_service.user.model.journey.Journey;

/**
 * 
 * @author datta
 *
 */

public class WeeklyFare extends BaseFare {
    
    Logger log = Logger.getLogger(WeeklyFare.class);

  private DailyFare dailyFare = new DailyFare();

  private double weeklyFare;

  private double weeklyCapValue;

  @Override
  public double calculate(List<Journey> journeys) {

    WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 7);

    Map<Integer, List<Journey>> datesGroupedByWeekNumber =
        journeys
            .stream()
            .collect(Collectors.groupingBy(trip -> trip.getTime().get(weekFields.weekOfMonth())));

    datesGroupedByWeekNumber.forEach(
        (k, v) -> {
          this.weeklyFare = 0.0;
          Map<Object, List<Journey>> jouneyByDayMap =
              v.stream().collect(Collectors.groupingBy(d -> d.getTime().getDayOfWeek()));

          jouneyByDayMap.forEach(
              (day, dailyjourneys) -> {
                
                  weeklyFare += this.dailyFare.calculate(dailyjourneys);
                
                  
                 
                  Journey weeklyLongestJourney = dailyFare.getWeeeklyLongestJourney();
                  
                  weeklyCapValue =
                      FareConfiguration.createFareConfiguration()
                          .getConfig(
                              weeklyLongestJourney.getSource()
                                  + weeklyLongestJourney.getDestination())
                          .getWeeklyCapValue();
                  
                  
                  if(weeklyFare > weeklyCapValue) {
                      this.weeklyFare = weeklyCapValue ;
                     
                  }
                  
                
              });
        });
    log.debug("Weekly fare : " + weeklyFare);
    return weeklyFare;
  }

  @Override
  boolean isCapReached(double capValue) { // TODO Auto-generated method stub
    return weeklyFare > capValue;
  }
}
