9 Java One Liners to Impress Your Friends
=========================================

Here is my take using Java 8: http://mkaz.com/solog/scala/10-scala-one-liners-to-impress-your-friends.html.


## 1. Multiple Each Item in a List by 2

```java
    countTo(10).stream().map(integer -> integer * 2).into(new ArrayList<Integer>());
```

## 2. Sum a List of Numbers

```java
    countTo(1000).stream().reduce(0, (x, y) -> x + y);
```

## 3. Verify if Exists in a String

```java
    final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
    final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

    keywords.stream().anyMatch(tweet::contains);
    keywords.stream().fold(() -> false, (Boolean b, String keyword) -> b || tweet.contains(keyword), (l, r) -> l || r);
```

## 4. Read in a File

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
Map<String,Collection<Integer>> result = Arrays.asList(49, 58, 76, 82, 88, 90).stream().groupBy(Mappers.forPredicate((Predicate<Integer>) integer -> integer > 60, "passed", "failed"));
```

## 7. Fetch and Parse an XML web service

```java
    FeedType feed = JAXB.unmarshal(new URL("http://search.twitter.com/search.atom?&q=java8"), FeedType.class);
    JAXB.marshal(feed, System.out);
```

## 8. Find minimum (or maximum) in a List

```java
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce((a, b) -> (a <= b) ? a : b).get();
    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce((a, b) -> (a >= b) ? a : b).get();
```

## 9. Parallel Processing

```java
long result = dataList.parallel().map(line -> processItem(line)).reduce(0L, (a, b) -> a + b);
```