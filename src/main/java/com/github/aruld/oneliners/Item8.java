package com.github.aruld.oneliners;

import java.util.Arrays;

/**
 * Find minimum (or maximum) in a List
 */
public class Item8 {

  public static void main(String[] args) {
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::min).get();
    min = Arrays.asList(14, 35, -7, 46, 98).stream().min(Integer::compare).get();

    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::max).get();
    max = Arrays.asList(14, 35, -7, 46, 98).stream().max(Integer::compare).get();
  }

}
