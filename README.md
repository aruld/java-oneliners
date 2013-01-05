10 Java One Liners to Impress Your Friends
==========================================

Here is my take using Java 8: http://mkaz.com/solog/scala/10-scala-one-liners-to-impress-your-friends.html.

I am replacing Sieve of Eratosthenes with LINQ style builder as the former is technically not a one-liner in Scala.


## 1. Multiple Each Item in a List by 2

```java
    intRange(1, 10).map(i -> i * 2).toArray();
    intRange(1, 10).map(i -> i * 2).boxed().into(new ArrayList<>());
```

## 2. Sum a List of Numbers

```java
    intRange(1, 1000).sum();
    intRange(1, 1000).reduce(0, Integer::sum);
    Streams.iterateInt(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
```

## 3. Verify if Exists in a String

```java
    final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
    final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

    keywords.stream().anyMatch(tweet::contains);
    keywords.stream().reduce(false, (Boolean b, String keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
```

## 4. Read in a File^

```java
    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      String fileText = reader.lines().reduce("", String::concat);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      List<String> fileLines = reader.lines().into(new LinkedList<String>());
    }
```

## 5. Happy Birthday to You!

```java
    intRange(1, 5).boxed().map(i -> { out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(out::println);
```

## 6. Filter list of numbers

```java
    Map<String, Collection<Integer>> result =  Arrays.asList(49, 58, 76, 82, 88, 90).stream().accumulate(groupBy(forPredicate((Integer i) -> i > 60, "passed", "failed")));
```

## 7. Fetch and Parse an XML web service^^

```java
    FeedType feed = JAXB.unmarshal(new URL("http://search.twitter.com/search.atom?&q=java8"), FeedType.class);
    JAXB.marshal(feed, System.out);
```

## 8. Find minimum (or maximum) in a List

```java
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::min).get();
    min = Arrays.asList(14, 35, -7, 46, 98).stream().min(Integer::compare).get();
    min = Streams.intStream(Arrays.spliterator(new int[]{14, 35, -7, 46, 98}), StreamOpFlag.IS_SIZED).min().getAsInt();

    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::max).get();
    max = Arrays.asList(14, 35, -7, 46, 98).stream().max(Integer::compare).get();
    max = Streams.intStream(Arrays.spliterator(new int[]{14, 35, -7, 46, 98}), StreamOpFlag.IS_SIZED).max().getAsInt();
```

## 9. Parallel Processing

```java
    int result = dataList.parallelStream().map(line -> processItem(line)).sum();
```

## 10. Ad-hoc queries over collections (LINQ in Java)

```java
    List<Album> albums = Arrays.asList(unapologetic, tailgates, red);

    // Print the names of albums that have at least one track rated four or higher, sorted by name.
    albums.stream()
      .filter(a -> a.tracks.stream().anyMatch(t -> (t.rating >= 4)))
      .sorted(comparing((Album album) -> album.name))
      .forEach(album -> System.out.println(album.name));

    // Merge tracks from all albums
    List<Track> allTracks = albums.stream()
      .mapMulti((Collector<Track> collector, Album element) -> collector.yield(element.tracks))
      .into(new ArrayList<Track>());

    // Group album tracks by rating
    Map<Integer, Collection<Track>> tracksByRating = allTracks.stream()
      .accumulate(Accumulators.<Track, Integer>groupBy(Track::getRating));
```


###Note:
^ I would still consider Try With Resources construct a one-liner.

^^ This is the odd man out that does not use Java 8 construct, although it is super simple with Java for years with the help of JAXB.