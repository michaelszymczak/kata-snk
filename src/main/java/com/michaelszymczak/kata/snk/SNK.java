package com.michaelszymczak.kata.snk;

import com.michaelszymczak.kata.snk.commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 24/09/17.
 */
public class SNK {

  private final List<Message> messages = new ArrayList<>();
  private final TimeProvider timeProvider;

  public SNK(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String run(String input) {
    return Command.of(timeProvider, input)
            .process(messages);
  }
}
