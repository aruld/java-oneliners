package oneliners;

import static oneliners.Util.countTo;

/**
 * Sum a List of Numbers
 */
public class Item2 {

  public static void main(String[] args) {
    countTo(1000).stream().reduce(Integer::sum).get();
    countTo(1000).stream().map(i -> (int) i).sum();
  }

}
