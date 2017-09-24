package com.michaelszymczak.kata.snk;

import com.michaelszymczak.kata.snk.commands.Command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created 24/09/17.
 */
public class SNK {

  private final Deque<Message> messages = new ArrayDeque<>();
  private final TimeProvider timeProvider;

  public SNK(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String run(String input) {
    return Command.of(timeProvider, input)
            .process(messages);
  }
}
