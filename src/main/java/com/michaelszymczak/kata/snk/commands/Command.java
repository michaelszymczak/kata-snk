package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;
import com.michaelszymczak.kata.snk.TimeProvider;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created 24/09/17.
 */
public interface Command {

  static Command of(TimeProvider timeProvider, String input) {
    return Stream.of(new SendCommand(timeProvider, input), new WallCommand(input), new GetCommand(input))
            .filter(Command::canHandle)
            .findFirst()
            .orElseThrow(RuntimeException::new);
  }

  boolean canHandle();

  String user();

  String argument();

  String process(List<Message> messages);
}
