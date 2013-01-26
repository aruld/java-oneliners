package com.aruld.oneliners;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static java.util.function.Functions.forPredicate;
import static java.util.stream.Collectors.groupingBy;

/**
 * Filter list of numbers
 */
public class Item6 {

  public static void main(String[] args) {
    Map<String, Collection<Integer>> result =  Arrays.asList(49, 58, 76, 82, 88, 90).stream().collect(groupingBy(forPredicate((Integer i) -> i > 60, "passed", "failed")));
  }

}
