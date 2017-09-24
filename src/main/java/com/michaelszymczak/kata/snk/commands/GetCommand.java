package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;
import com.michaelszymczak.kata.snk.WallLine;

import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created 24/09/17.
 */
public class GetCommand implements Command {

  private final String input;
  private final WallLine wallLine;

  public GetCommand(WallLine wallLine, String input) {
    this.input = input;
    this.wallLine = wallLine;
  }

  @Override
  public boolean canHandle() {
    return true;
  }

  @Override
  public String user() {
    return input.trim();
  }

  @Override
  public String argument() {
    return "";
  }

  @Override
  public String process(Map<String,Set<String>> follows, Deque<Message> messages) {
    return messages.stream()
            .filter(message -> message.user().equals(user()))
            .map(wallLine::asMessage)
            .collect(Collectors.joining("\n"));
  }
}
