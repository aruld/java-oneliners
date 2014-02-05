package com.github.aruld.oneliners;

import java.util.stream.Stream;

/**
 * Verify if Exists in a String
 */
public class Item3 {

  public static void main(String[] args) {

    final Stream<String> keywords = Stream.of("brown", "fox", "dog", "pangram");
    final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

    keywords.anyMatch(tweet::contains);
    keywords.reduce(false, (b, keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
  }

}
