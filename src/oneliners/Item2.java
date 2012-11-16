package oneliners;

import java.util.function.IntMapper;

import static oneliners.Util.countTo;

/**
 * Sum a List of Numbers
 */
public class Item2 {

  public static void main(String[] args) {
    countTo(1000).stream().reduce(0, (x, y) -> x + y);
    countTo(1000).stream().map((IntMapper<Integer>) i -> i).sum();
  }

}
