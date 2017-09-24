package com.michaelszymczak.kata.snk;

/**
 * Created 24/09/17.
 */
public class WallLine {

  private final TimeProvider timeProvider;

  public WallLine(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String asMessage(Message message) {
    return String.format("%s (%d minutes ago)", message.content(), timeProvider.minutesSince(message.sentTimeMs())); // TODO plural singular minutes formatting
  }

  public String asWallMessage(Message message) {
    return String.format("%s - %s (%d minutes ago)", message.user(), message.content(), timeProvider.minutesSince(message.sentTimeMs())); // TODO plural singular minutes formatting
  }
}
