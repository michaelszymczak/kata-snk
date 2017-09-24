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
  public String process(Map<String,Set<String>> follows, Deque<Message> messages) {
    return messages.stream()
            .filter(message -> sameUser(message) || followedUser(follows, message))
            .map(wallLine::asWallMessage)
            .collect(Collectors.joining("\n"));
  }

  private boolean sameUser(Message message) {
    return message.user().equals(user());
  }

  private boolean followedUser(Map<String, Set<String>> follows, Message message) {
    return follows.get(user()) != null && follows.get(user()).contains(message.user());
  }
}
