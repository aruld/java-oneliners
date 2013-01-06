package com.aruld.oneliners;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.stream.StreamOpFlag;
import java.util.stream.Streams;

import static java.util.function.Functions.forPredicate;
import static java.util.stream.Accumulators.groupBy;
import static java.util.stream.Streams.intRange;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ItemTest {

  @Test
  public void item1() {
    int[] actual = intRange(1, 10).map(i -> i * 2).toArray();
    int[] expected = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18};
    assertArrayEquals(actual, expected);
    List<Integer> actualList = intRange(1, 10).map(i -> i * 2).boxed().into(new ArrayList<Integer>());
    List<Integer> expectedList = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18);
    Assert.assertEquals(actualList, expectedList);
  }

  @Test
  public void item2() {
    int expected = 499500;
    assertEquals(intRange(1, 1000).sum(), expected);
    assertEquals(intRange(1, 1000).reduce(0, Integer::sum), expected);
    assertEquals(Streams.iterateInt(0, i -> i + 1).limit(1000).reduce(0, Integer::sum), expected);
  }

  @Test
  public void item3() {

    final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
    final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

    assertTrue(keywords.stream().anyMatch(tweet::contains));
    assertTrue(keywords.stream().reduce(false, (Boolean b, String keyword) -> b || tweet.contains(keyword), (l, r) -> l || r));

  }

  @Test
  public void item4() throws Exception {
    URL url = this.getClass().getResource("/data.txt");
    File data = new File(url.getFile());
    List<String> expected = Arrays.asList("banana", "pineapple", "guava", "papaya");

    try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
      String fileText = reader.lines().reduce("", String::concat);
      assertEquals(fileText, "bananapineappleguavapapaya");
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
      List<String> fileLines = reader.lines().into(new LinkedList<String>());
      assertEquals(fileLines, expected);
    }
  }

  @Test
  public void item6() {
    Map<String, Collection<Integer>> result = Arrays.asList(49, 58, 76, 82, 88, 90).stream().accumulate(groupBy(forPredicate((Integer i) -> i > 60, "passed", "failed")));

    Collection<Integer> expected = Arrays.asList(76, 82, 88, 90);
    assertEquals(result.get("passed"), expected);
    assertEquals(result.get("failed"), Arrays.asList(49, 58));
  }

  @Test
  public void item8() {
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::min).get();
    assertEquals(min, -7);
    min = Arrays.asList(14, 35, -7, 46, 98).stream().min(Integer::compare).get();
    assertEquals(min, -7);
    min = Streams.intStream(Arrays.spliterator(new int[]{14, 35, -7, 46, 98}), StreamOpFlag.IS_SIZED).min().getAsInt();
    assertEquals(min, -7);

    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::max).get();
    assertEquals(max, 98);
    max = Arrays.asList(14, 35, -7, 46, 98).stream().max(Integer::compare).get();
    assertEquals(max, 98);
    max = Streams.intStream(Arrays.spliterator(new int[]{14, 35, -7, 46, 98}), StreamOpFlag.IS_SIZED).max().getAsInt();
    assertEquals(max, 98);
  }

}
