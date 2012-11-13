package oneliners;

import static oneliners.Util.countTo;

/**
 * Happy Birthday to You!
 */
public class Item5 {

  public static void main(String[] args) {
    countTo(4).stream().map(i -> { System.out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(System.out::println);
  }
}
