package oneliners;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Mappers;
import java.util.function.Predicate;

/**
 * Filter list of numbers
 */
public class Item6 {

  public static void main(String[] args) {
    Map<String,Collection<Integer>> result = Arrays.asList(49, 58, 76, 82, 88, 90).stream().groupBy(Mappers.forPredicate((Predicate<Integer>) integer -> integer > 60, "passed", "failed"));
  }

}
