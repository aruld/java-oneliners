package oneliners;

import java.util.ArrayList;
import java.util.List;

public class Util {
  public static List<Integer> countTo(int n) {
    return range(1, n);
  }

  public static List<Integer> range(int l, int u) {
    ArrayList<Integer> list = new ArrayList<>(u - l + 1);
    for (int i = l; i <= u; i++) {
      list.add(i);
    }
    return list;
  }

}
