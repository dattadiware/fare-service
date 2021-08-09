package com.tigercard.fare_service.user.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.tigercard.fare_service.user.model.journey.Journey;

public class User implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private UUID id;

  private List<Journey> journeys;

  public User() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Journey> getjourneys() {
    return journeys;
  }

  public void setJourneys(List<Journey> journeys) {
    this.journeys = journeys;
  }
}
