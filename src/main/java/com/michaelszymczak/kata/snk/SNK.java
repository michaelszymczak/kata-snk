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
      messages.add(new Message().sentTimeMs(timeProvider.nowMs()).content(chunks[1].trim()));
      return "\n";
    } else {
      final WallLine wallLine = new WallLine(timeProvider);

      return messages.stream()
              .map(wallLine::asString)
              .collect(Collectors.joining("\n"));
    }
  }
}
