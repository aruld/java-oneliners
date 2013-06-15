package com.aruld.oneliners;


import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

/**
 * Sum a List of Numbers.
 */
public class Item2 {

  public static void main(String[] args) {
    // Range is half-open (exclusive) as in Python, unlike Scala.
    range(1, 1000).sum();
    range(1, 1000).reduce(0, Integer::sum);
    Stream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
    IntStream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
  }

}
