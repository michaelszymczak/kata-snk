package com.michaelszymczak.kata.snk.commands;

import com.michaelszymczak.kata.snk.Message;
import com.michaelszymczak.kata.snk.TimeProvider;

import java.util.Deque;

/**
 * Created 24/09/17.
 */
public class SendCommand implements Command {

  private final String input;
  private final TimeProvider timeProvider;

  public SendCommand(TimeProvider timeProvider, String input) {
    this.timeProvider = timeProvider;
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

  @Override
  public String process(Deque<Message> messages) {
    messages.addFirst(new Message()
            .user(user())
            .content(argument())
            .sentTimeMs(timeProvider.nowMs()));

    return "\n";
  }
}
