package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;
import com.michaelszymczak.kata.snk.TimeProvider;
import com.michaelszymczak.kata.snk.WallLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 24/09/17.
 */
public class WallCommand implements Command {

  private final String input;
  private final WallLine wallLine;

  public WallCommand(WallLine wallLine, String input) {
    this.input = input;
    this.wallLine = wallLine;
  }

  @Override
  public boolean canHandle() {
    return input.endsWith(" wall");
  }

  @Override
  public String user() {
    return input.replaceFirst(" wall$", "");
  }

  @Override
  public String argument() {
    return "";
  }

  @Override
  public String process(List<Message> messages) {
    return messages.stream()
            .filter(message -> message.user().equals(user()))
            .map(wallLine::asString)
            .collect(Collectors.joining("\n"));
  }
}
