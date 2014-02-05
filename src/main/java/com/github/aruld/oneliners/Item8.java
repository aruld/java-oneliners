package com.github.aruld.oneliners;

import java.util.stream.Stream;

/**
 * Find minimum (or maximum) in a List
 */
public class Item8 {

  public static void main(String[] args) {
    int min = Stream.of(14, 35, -7, 46, 98).reduce(Integer::min).get();
    min = Stream.of(14, 35, -7, 46, 98).min(Integer::compare).get();

    int max = Stream.of(14, 35, -7, 46, 98).reduce(Integer::max).get();
    max = Stream.of(14, 35, -7, 46, 98).max(Integer::compare).get();
  }

}
