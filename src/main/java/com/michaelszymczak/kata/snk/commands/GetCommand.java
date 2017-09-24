package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;

import java.util.List;

/**
 * Created 24/09/17.
 */
public class GetCommand implements Command {

  private final String input;

  public GetCommand(String input) {
    this.input = input;
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
  public String process(List<Message> messages) {
    return "";
  }
}
