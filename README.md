10 Java One Liners to Impress Your Friends
==========================================

Here is my take using Java 8: http://mkaz.com/solog/scala/10-scala-one-liners-to-impress-your-friends.html.

I am replacing Sieve of Eratosthenes with LINQ style builder as the former is technically not a one-liner in Scala.


## 1. Multiple Each Item in a List by 2

```java
    countTo(10).stream().map((IntFunction<Integer>) i -> i * 2).toArray();
    countTo(10).stream().map((IntFunction<Integer>) i -> i * 2).boxed().into(new ArrayList<Integer>());
```

## 2. Sum a List of Numbers

```java
    countTo(1000).stream().reduce(Integer::sum).get();
    countTo(1000).stream().map((IntFunction<Integer>) i -> i).sum();
```

## 3. Verify if Exists in a String

```java
    final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
    final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

    keywords.stream().anyMatch(tweet::contains);
    keywords.stream().fold(() -> false, (Boolean b, String keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
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
    countTo(4).stream().map(i -> { System.out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(System.out::println);
```

## 6. Filter list of numbers

```java
    Map<String, Collection<Integer>> result = Arrays.asList(49, 58, 76, 82, 88, 90).stream().groupBy(Functions.forPredicate((Predicate<Integer>) i -> i > 60, "passed", "failed"));
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

    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::max).get();
    max = Arrays.asList(14, 35, -7, 46, 98).stream().max(Integer::compare).get();
```

## 9. Parallel Processing

```java
    int result = dataList.parallel().map(line -> processItem(line)).sum();
```

## 10. Ad-hoc queries over collections (LINQ in Java)

```java
    List<Album> sortedFavs = albums.stream()
      .filter(a -> a.tracks.stream().anyMatch(t -> (t.rating >= 4)))
      .sorted(comparing((Function<Album, String>) album -> album.name))
      .into(new ArrayList<Album>());
```


###Note:
^ I would still consider Try With Resources construct a one-liner.

^^ This is the odd man out that does not use Java 8 construct, although it is super simple with Java for years with the help of JAXB.