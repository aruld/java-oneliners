package oneliners;

import java.util.ArrayList;

import static java.util.stream.primitive.Primitives.range;

/**
 * Multiple Each Item in a List by 2
 */
public class Item1 {

  public static void main(String[] args) {
    range(1, 11).map(i -> i * 2).toArray();
    range(1, 11).map(i -> i * 2).boxed().into(new ArrayList<>());
  }

}
