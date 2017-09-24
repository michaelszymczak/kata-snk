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

  def "a user has an empty wall and no messages initially"() {
    expect:
    snk.run("Alice") == ""
    snk.run("Alice wall") == ""
  }

  def "a user can see messages with sending time"() {
    given:
    setTimeToMinutesAgo(6); snk.run("Alice -> I love the weather today")
    setTimeToMinutesAgo(5); snk.run("Alice -> I repeat, I love the weather today")
    resetTime();

    when:
    String output = snk.run("Alice")

    then:
    output == "I love the weather today (6 minutes ago)\n" +
              "I repeat, I love the weather today (5 minutes ago)"
  }

  def "each user can see their own messages"() {
    given:
    snk.run("Alice -> I love the weather today")
    snk.run("Bob -> Damn! We lost!")

    expect:
    snk.run("Alice") == "I love the weather today (0 minutes ago)";
    snk.run("Bob") == "Damn! We lost! (0 minutes ago)";
  }


  def "each user can see their own messages on their wall"() {
    given:
    snk.run("Alice -> foo")
    snk.run("Alice -> bar")
    snk.run("Bob -> baz")
    snk.run("Bob -> qux")

    expect:
    snk.run("Alice wall") == "foo (0 minutes ago)\n" +
                             "bar (0 minutes ago)";
    snk.run("Bob wall") == "baz (0 minutes ago)\n" +
                             "qux (0 minutes ago)";
  }

  private void setTimeToMinutesAgo(int minutes) {
    timeProvider.setNow(now.minusSeconds(minutes * 60))
  }

  private void resetTime() {
    timeProvider.setNow(now);
  }
}
