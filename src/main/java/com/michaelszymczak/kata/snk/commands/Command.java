package com.michaelszymczak.kata.snk.commands;

import java.util.stream.Stream;

/**
 * Created 24/09/17.
 */
public interface Command {

  static Command of(String input) {
    return Stream.of(new SendCommand(input))
            .filter(SendCommand::canHandle)
            .findFirst()
            .orElseThrow(RuntimeException::new);
  }

  boolean canHandle();

  String user();

  String argument();
}
