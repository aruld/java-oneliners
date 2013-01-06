package com.aruld.oneliners;

import java.util.Arrays;
import java.util.stream.StreamOpFlag;
import java.util.stream.Streams;

/**
 * Find minimum (or maximum) in a List
 */
public class Item8 {

  public static void main(String[] args) {
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::min).get();
    min = Arrays.asList(14, 35, -7, 46, 98).stream().min(Integer::compare).get();
    min = Streams.intStream(Arrays.spliterator(new int[]{14, 35, -7, 46, 98}), StreamOpFlag.IS_SIZED).min().getAsInt();

    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::max).get();
    max = Arrays.asList(14, 35, -7, 46, 98).stream().max(Integer::compare).get();
    max = Streams.intStream(Arrays.spliterator(new int[]{14, 35, -7, 46, 98}), StreamOpFlag.IS_SIZED).max().getAsInt();
  }

}
