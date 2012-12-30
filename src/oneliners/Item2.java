package oneliners;

import static java.util.stream.primitive.PrimitiveStreams.range;

/**
 * Sum a List of Numbers
 */
public class Item2 {

  public static void main(String[] args) {
    range(1, 1001).sum();
    range(1, 1001).reduce(0, Integer::sum);
  }

}
