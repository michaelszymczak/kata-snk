package com.michaelszymczak.kata.snk;

/**
 * Created 24/09/17.
 */
import java.util.Scanner;

class Application  {
  public static void main (String[] args) {
    final Scanner scan = new Scanner( System.in );
    String in;

    for (;;) {
      System.out.print("> "); in = scan.nextLine();
      if ("exit".equals(in)) { break; } else {
        System.out.println("You entered:" + in );
      }
    }
  }
}