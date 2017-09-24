package com.michaelszymczak.kata.snk;

import java.time.Instant;

/**
 * Created 24/09/17.
 */
@FunctionalInterface
public interface TimeProvider {

  Instant now();

  default long nowMs() {
    return now().toEpochMilli();
  }

  default long minutesSince(long otherTimeMs) {
    return (nowMs() - otherTimeMs) / 60000;
  }

  class SystemTimeProvider implements TimeProvider {

    @Override
    public Instant now() {
      return Instant.now();
    }
  }

  class FakeTimeProvider implements TimeProvider {

    public FakeTimeProvider(Instant now) {
      this.now = now;
    }

    private Instant now;

    public void setNow(Instant now) {
      this.now = now;
    }

    @Override
    public Instant now() {
      return now;
    }
  }
}
