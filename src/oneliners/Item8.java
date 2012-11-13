package oneliners;

import java.util.Arrays;

/**
 * Find minimum (or maximum) in a List
 */
public class Item8 {

  public static void main(String[] args) {
    int min = Arrays.asList(14, 35, -7, 46, 98).stream().reduce((a, b) -> (a <= b) ? a : b).get();
    int max = Arrays.asList(14, 35, -7, 46, 98).stream().reduce((a, b) -> (a >= b) ? a : b).get();
  }

}
