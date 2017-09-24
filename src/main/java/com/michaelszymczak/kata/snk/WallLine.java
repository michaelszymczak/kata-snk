package com.michaelszymczak.kata.snk;

/**
 * Created 24/09/17.
 */
public class WallLine {

  private final TimeProvider timeProvider;

  public WallLine(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  String asString(Message message) {
    return String.format("%s (%d minutes ago)", message.content(), timeProvider.minutesSince(message.sentTimeMs()));
  }
}
