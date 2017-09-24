package com.michaelszymczak.kata.snk;

import com.michaelszymczak.kata.snk.commands.Command;

import java.util.*;

/**
 * Created 24/09/17.
 */
public class SNK {

  private final Deque<Message> messages = new ArrayDeque<>();
  private final TimeProvider timeProvider;
  private Map<String,Set<String>> follows = new HashMap<>();

  public SNK(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String run(String input) {
    return Command.of(timeProvider, input)
            .process(follows, messages);
  }
}
