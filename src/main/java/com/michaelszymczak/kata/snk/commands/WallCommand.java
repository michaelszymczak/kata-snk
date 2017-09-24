package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;

import java.util.List;

/**
 * Created 24/09/17.
 */
public class WallCommand implements Command {

  private final String input;

  public WallCommand(String input) {
    this.input = input;
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
    return "";
  }
}
