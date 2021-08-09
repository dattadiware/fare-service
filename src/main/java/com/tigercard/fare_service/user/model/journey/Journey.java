package com.tigercard.fare_service.user.model.journey;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author datta
 *
 */
public class Journey implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private Zone source;

  private Zone destination;

  private LocalDateTime time;

  private Double fare;

  public Journey(Zone source, Zone destination, LocalDateTime time) {
    super();
    this.source = source;
    this.destination = destination;
    this.time = time;
  }

  public Double getFare() {
    return fare;
  }

  public void setFare(Double fare) {
    this.fare = fare;
  }

  public String getSource() {
    return source.name();
  }

  public void setSource(Zone source) {
    this.source = source;
  }

  public String getDestination() {
    return destination.name();
  }

  public void setDestination(Zone destination) {
    this.destination = destination;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public Journey longestJourny(Journey journey, Journey longestJourney) {

    if (null == longestJourney) {
      longestJourney = journey;
    }
    if (journey.getFare() > longestJourney.getFare()) {
      longestJourney = journey;
    }

    return longestJourney;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((destination == null) ? 0 : destination.hashCode());
    result = prime * result + ((fare == null) ? 0 : fare.hashCode());
    result = prime * result + ((source == null) ? 0 : source.hashCode());
    result = prime * result + ((time == null) ? 0 : time.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Journey other = (Journey) obj;
    if (destination != other.destination) return false;
    if (fare == null) {
      if (other.fare != null) return false;
    } else if (!fare.equals(other.fare)) return false;
    if (source != other.source) return false;
    if (time == null) {
      if (other.time != null) return false;
    } else if (!time.equals(other.time)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "Journey [source="
        + source
        + ", destination="
        + destination
        + ", time="
        + time
        + ", fare="
        + fare
        + "]";
  }
}
