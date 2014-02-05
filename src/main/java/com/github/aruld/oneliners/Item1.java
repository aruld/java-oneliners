package com.github.aruld.oneliners;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * Multiple Each Item in a List by 2.
 */
public class Item1 {

  public static void main(String[] args) {
    // Range is half-open (exclusive) in Java, unlike Scala.
    int[] ia = range(1, 10).map(i -> i * 2).toArray();
    List<Integer> result = range(1, 10).map(i -> i * 2).boxed().collect(toList());
  }

}
