package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;
import com.michaelszymczak.kata.snk.TimeProvider;

import java.util.Deque;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created 24/09/17.
 */
public class FollowCommand implements Command {

  private final String input;

  public FollowCommand(String input) {
    this.input = input;
  }

  @Override
  public boolean canHandle() {
    return input.contains(" follows ");
  }

  @Override
  public String user() {
    String[] chunks = input.split("follows");
    return chunks[0].trim();
  }

  @Override
  public String argument() {
    String[] chunks = input.split("follows");
    return chunks[1].trim();
  }

  @Override
  public String process(Map<String,Set<String>> follows, Deque<Message> messages) {
    if (!follows.containsKey(user())) {
      follows.put(user(), new HashSet<>());
    }
    follows.get(user()).add(argument());

    return "\n";
  }
}
