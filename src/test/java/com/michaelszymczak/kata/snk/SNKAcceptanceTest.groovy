package com.michaelszymczak.kata.snk

import com.michaelszymczak.kata.snk.TimeProvider.FakeTimeProvider
import spock.lang.Specification

import java.time.Instant

/**
 * Created 24/09/17.
 */
class SNKAcceptanceTest extends Specification {

  private final Instant now = Instant.parse("2017-05-10T10:00:00.000Z");
  private final FakeTimeProvider timeProvider = new FakeTimeProvider(now);
  private final SNK snk = new SNK(timeProvider);

  def "a user has an empty wall initially"() {
    expect:
    snk.run("Alice") == ""
  }

  def "a user's wall contains a messages send to them"() {
    given:
    timeProvider.setNow(now.minusSeconds(6 * 60));
    snk.run("Alice -> I love the weather today")
    timeProvider.setNow(now.minusSeconds(5 * 60));
    snk.run("Alice -> I repeat, I love the weather today")
    timeProvider.setNow(now);

    when:
    String output = snk.run("Alice")

    then:
    output == "I love the weather today (6 minutes ago)\n" +
              "I repeat, I love the weather today (5 minutes ago)"
  }


}
