package com.aruld.oneliners;

import static java.lang.System.out;
import static java.util.stream.Streams.intRange;

/**
 * Happy Birthday to You!
 */
public class Item5 {

  public static void main(String[] args) {
    // Range is half-open (exclusive) in Java, unlike Scala.
    intRange(1, 5).boxed().map(i -> { out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(out::println);
  }
}
