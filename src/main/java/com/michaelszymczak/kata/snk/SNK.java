package com.michaelszymczak.kata.snk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 24/09/17.
 */
public class SNK {

  private final List<Message> messages = new ArrayList<>();
  private final TimeProvider timeProvider;

  public SNK(TimeProvider timeProvider) {
    this.timeProvider = timeProvider;
  }

  public String run(String command) {

    if (command.contains("->")) {
      String[] chunks = command.split("->");

      messages.add(new Message()
              .user(chunks[0].trim())
              .content(chunks[1].trim())
              .sentTimeMs(timeProvider.nowMs()));

      return "\n";
    } else {
      final WallLine wallLine = new WallLine(timeProvider);
      String user = command.endsWith(" wall") ? command.replace(" wall", "").trim() : command.trim();

      return messages.stream()
              .filter(message -> message.user().equals(user))
              .map(wallLine::asString)
              .collect(Collectors.joining("\n"));
    }
  }
}
