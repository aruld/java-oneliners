package com.aruld.oneliners;


import java.util.stream.Streams;

import static java.util.stream.Streams.intRange;

/**
 * Sum a List of Numbers.
 */
public class Item2 {

  public static void main(String[] args) {
    // Range is half-open (exclusive) in Java, unlike Scala.
    intRange(1, 1000).sum();
    intRange(1, 1000).reduce(0, Integer::sum);
    Streams.iterateInt(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
  }

}
