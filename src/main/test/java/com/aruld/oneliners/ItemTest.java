package com.aruld.oneliners;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.function.Multifunction;
import java.util.stream.Collectors;
import java.util.stream.StreamOpFlag;
import java.util.stream.Streams;

import static java.util.function.Functions.forPredicate;
import static java.util.Comparators.comparing;
import static java.util.stream.Collectors.groupBy;
import static java.util.stream.Streams.intRange;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import static com.aruld.oneliners.Item10.Album;
import static com.aruld.oneliners.Item10.Track;

public class ItemTest {

  @Test
  public void item1() {
    int[] actual = intRange(1, 10).map(i -> i * 2).toArray();
    int[] expected = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18};
    assertArrayEquals(actual, expected);
    List<Integer> actualList = intRange(1, 10).map(i -> i * 2).boxed().collect(Collectors.<Integer>toList());
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
      List<String> fileLines = reader.lines().collect(Collectors.toCollection(() -> new LinkedList<String>()));
      assertEquals(fileLines, expected);
    }
  }

  @Test
  public void item6() {
    Map<String, Collection<Integer>> result = Arrays.asList(49, 58, 76, 82, 88, 90).stream().collect(groupBy(forPredicate((Integer i) -> i > 60, "passed", "failed")));

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

  @Test
  public void item10() {
    Album tailgates = new Album("Tailgates & Tanlines", "Luke Bryan");
    tailgates.tracks.add(new Track("Country Girl (Shake It for Me)", 5));
    tailgates.tracks.add(new Track("Kiss Tomorrow Goodbye", 5));
    tailgates.tracks.add(new Track("Drunk On You", 4));
    tailgates.tracks.add(new Track("Too Damn Young", 4));
    tailgates.tracks.add(new Track("I Don't Want This Night to End", 4));
    tailgates.tracks.add(new Track("You Don't Know Jack", 4));
    tailgates.tracks.add(new Track("Harvest Time", 3));
    tailgates.tracks.add(new Track("I Know You're Gonna Be There", 3));
    tailgates.tracks.add(new Track("Muckalee Creek Water", 3));
    tailgates.tracks.add(new Track("Tailgate Blues", 3));
    tailgates.tracks.add(new Track("Been There, Done That", 3));
    tailgates.tracks.add(new Track("Faded Away", 3));
    tailgates.tracks.add(new Track("I Knew You That Way", 3));

    Album unapologetic = new Album("Unapologetic", "Rihanna");
    unapologetic.tracks.add(new Track("Phresh Out the Runway", 5));
    unapologetic.tracks.add(new Track("Diamonds", 3));
    unapologetic.tracks.add(new Track("Numb", 3));
    unapologetic.tracks.add(new Track("Pour It Up", 3));
    unapologetic.tracks.add(new Track("Loveeeeeee Song", 4));
    unapologetic.tracks.add(new Track("Jump", 4));
    unapologetic.tracks.add(new Track("Right Now", 4));
    unapologetic.tracks.add(new Track("What Now", 4));
    unapologetic.tracks.add(new Track("Stay", 4));
    unapologetic.tracks.add(new Track("Nobody's Business", 5));
    unapologetic.tracks.add(new Track("Love Without Tragedy", 5));
    unapologetic.tracks.add(new Track("Get It Over With", 5));
    unapologetic.tracks.add(new Track("No Love Allowed", 3));
    unapologetic.tracks.add(new Track("Lost In Paradise", 5));

    Album red = new Album("Red", "Taylor Swift");
    red.tracks.add(new Track("State of Grace", 4));
    red.tracks.add(new Track("Red", 4));
    red.tracks.add(new Track("Treacherous", 4));
    red.tracks.add(new Track("I Knew You Were Trouble", 5));
    red.tracks.add(new Track("All Too Well", 3));
    red.tracks.add(new Track("22", 3));
    red.tracks.add(new Track("I Almost Do", 3));
    red.tracks.add(new Track("We Are Never Ever Getting Back", 3));
    red.tracks.add(new Track("Stay Stay Stay", 5));
    red.tracks.add(new Track("The Last Time", 5));
    red.tracks.add(new Track("Holy Ground", 3));
    red.tracks.add(new Track("Sad Beautiful Tragic", 3));
    red.tracks.add(new Track("The Lucky One", 4));
    red.tracks.add(new Track("Everything Has Changed", 3));
    red.tracks.add(new Track("Starlight", 4));
    red.tracks.add(new Track("Begin Again", 3));

    List<Album> albums = Arrays.asList(unapologetic, tailgates, red);

    // Print the names of albums that have at least one track rated four or higher, sorted by name.
    Assert.assertEquals(albums.stream()
      .filter(a -> a.tracks.stream().anyMatch(t -> (t.rating >= 4)))
      .sorted(comparing((Album album) -> album.name))
      .map(a -> a.name).collect(Collectors.<String>toList()), Arrays.asList("Red", "Tailgates & Tanlines", "Unapologetic"));

    // Merge tracks from all albums
    List<Track> allTracks = albums.stream()
      .mapMulti((Multifunction.Downstream<Track> downstream, Album element) -> downstream.yield(element.tracks))
      .collect(Collectors.<Track>toList());
    Assert.assertEquals(allTracks.size(), 43);

    // Group album tracks by rating
    Map<Integer, Collection<Track>> tracksByRating = allTracks.stream()
      .collect(Collectors.<Track, Integer>groupBy(Track::getRating));
    Assert.assertEquals(tracksByRating.get(3).size(), 19);
    Assert.assertEquals(tracksByRating.get(4).size(), 14);
    Assert.assertEquals(tracksByRating.get(5).size(), 10);
  }

}
