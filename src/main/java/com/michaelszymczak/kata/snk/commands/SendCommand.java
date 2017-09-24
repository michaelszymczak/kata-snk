package com.michaelszymczak.kata.snk.commands;

/**
 * Created 24/09/17.
 */
public class SendCommand implements Command {

  private final String input;

  public SendCommand(String input) {
    this.input = input;
  }

  @Override
  public boolean canHandle() {
    return input.contains("->");
  }

  @Override
  public String user() {
    String[] chunks = input.split("->");
    return chunks[0].trim();
  }

  @Override
  public String argument() {
    String[] chunks = input.split("->");
    return chunks[1].trim();
  }
}
