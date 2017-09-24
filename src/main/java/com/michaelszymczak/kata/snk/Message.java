package com.michaelszymczak.kata.snk;

/**
 * Created 24/09/17.
 */
public class Message {

  private String content;
  private long sentTimeMs;

  public String content() {
    return content;
  }

  public Message content(String content) {
    this.content = content; return this;
  }

  public long sentTimeMs() {
    return sentTimeMs;
  }

  public Message sentTimeMs(long sentTimeMs) {
    this.sentTimeMs = sentTimeMs; return this;
  }
}
