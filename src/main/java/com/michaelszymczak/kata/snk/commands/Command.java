package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;
import com.michaelszymczak.kata.snk.TimeProvider;
import com.michaelszymczak.kata.snk.WallLine;

import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created 24/09/17.
 */
public interface Command {

  static Command of(TimeProvider timeProvider, String input) {
    final WallLine wallLine = new WallLine(timeProvider);
    return Stream.of(new SendCommand(timeProvider, input), new WallCommand(wallLine, input), new FollowCommand(input), new GetCommand(wallLine, input))
            .filter(Command::canHandle)
            .findFirst()
            .orElseThrow(RuntimeException::new);
  }

  boolean canHandle();

  String user();

  String argument();

  String process(Map<String,Set<String>> follows, Deque<Message> messages);
}
