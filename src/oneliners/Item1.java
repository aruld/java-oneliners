package oneliners;

import java.util.ArrayList;
import java.util.function.IntFunction;

import static oneliners.Util.countTo;

/**
 * Multiple Each Item in a List by 2
 */
public class Item1 {

  public static void main(String[] args) {
    countTo(10).stream().map((IntFunction<Integer>) i -> i * 2).toArray();
    countTo(10).stream().map((IntFunction<Integer>) i -> i * 2).boxed().into(new ArrayList<Integer>());
  }

}
