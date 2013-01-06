package com.aruld.oneliners;

import java.util.Arrays;
import java.util.List;

/**
 * Verify if Exists in a String
 */
public class Item3 {

  public static void main(String[] args) {

    final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
    final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

    keywords.stream().anyMatch(tweet::contains);
    keywords.stream().reduce(false, (Boolean b, String keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
  }

}
