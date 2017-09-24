package com.michaelszymczak.kata.snk;

import com.michaelszymczak.kata.snk.commands.SendCommand;

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

  public String run(String input) {

    SendCommand command = new SendCommand(timeProvider, input);

    if (command.canHandle()) {

      return command.process(messages);
    } else {
      final WallLine wallLine = new WallLine(timeProvider);
      String user = input.endsWith(" wall") ? input.replace(" wall", "").trim() : input.trim();

      return messages.stream()
              .filter(message -> message.user().equals(user))
              .map(wallLine::asString)
              .collect(Collectors.joining("\n"));
    }
  }
}
