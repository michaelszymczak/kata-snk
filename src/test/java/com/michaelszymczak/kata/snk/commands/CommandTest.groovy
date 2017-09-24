package com.michaelszymczak.kata.snk.commands

import spock.lang.Specification

/**
 * Created 24/09/17.
 */
class CommandTest extends Specification {

  def "should pick the appropriate command"() {
    when:
    Command cmd = Command.of(input)

    then:
    cmd.canHandle()
    cmd.getClass() == expectedInstance
    cmd.user() == expectedUser
    cmd.argument() == expectedArgument

    where:
    input              | expectedInstance | expectedUser | expectedArgument
    "Alice -> foo bar" | SendCommand      | "Alice"      | "foo bar"
    "Bob -> Baz"       | SendCommand      | "Bob"        | "Baz"
  }
}
