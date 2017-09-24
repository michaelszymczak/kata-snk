package com.michaelszymczak.kata.snk.commands

import com.michaelszymczak.kata.snk.TimeProvider
import spock.lang.Specification

import java.time.Instant

/**
 * Created 24/09/17.
 */
public class CommandTest extends Specification {

  private final TimeProvider timeProvider = new TimeProvider.FakeTimeProvider(Instant.now())

  def "should pick the appropriate command"() {
    when:
    Command cmd = Command.of(timeProvider, input)

    then:
    cmd.canHandle()
    cmd.getClass() == expectedInstance
    cmd.user() == expectedUser
    cmd.argument() == expectedArgument

    where:
    input              | expectedInstance | expectedUser | expectedArgument
    "Alice -> foo bar" | SendCommand      | "Alice"      | "foo bar"
    "Bob -> Baz"       | SendCommand      | "Bob"        | "Baz"
    "Alice"            | GetCommand       | "Alice"      | ""
    "Bob"              | GetCommand       | "Bob"        | ""
    "Alice wall"       | WallCommand      | "Alice"      | ""
    "Bob wall"         | WallCommand      | "Bob"        | ""
  }
}
