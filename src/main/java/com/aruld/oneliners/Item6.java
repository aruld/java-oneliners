package com.aruld.oneliners;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

/**
 * Filter list of numbers
 */
public class Item6 {

  public static void main(String[] args) {
    Map<String, List<Integer>> result = Arrays.asList(49, 58, 76, 82, 88, 90).stream().collect(groupingBy(forPredicate((Integer i) -> i > 60, "passed", "failed")));
  }

  /**
   * Map according to the provided predicate. Two output values are provided
   * {@code forTrue} is returned if the predicate returns {@code true}
   * otherwise the {@code forFalse} value is returned.
   *
   * @param <T>       input type to mapping function
   * @param <R>       output type from mapping function
   * @param predicate decides which value {@code apply} method should return
   * @param forTrue   value to be returned for {@code true} predicate results
   * @param forFalse  value to be returned for {@code false} predicate results
   * @return a Function whose {@code apply} method provides results according to
   *         the provided predicate.
   * @throws NullPointerException if predicate is null
   */
  public static <T, R> Function<T, R> forPredicate(Predicate<? super T> predicate, R forTrue, R forFalse) {
    Objects.requireNonNull(predicate);
    return t -> predicate.test(t) ? forTrue : forFalse;
  }

}
