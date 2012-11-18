package oneliners;

import java.util.Arrays;

/**
 * Find minimum (or maximum) in a List
 */
public class Item8 {

  public static void main(String[] args) {
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::min).get();
    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce(Integer::max).get();
  }

}
