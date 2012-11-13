package oneliners;

import org.w3._2005.atom.FeedType;

import javax.xml.bind.JAXB;
import java.net.URL;

/**
 * Fetch and Parse an XML web service
 */
public class Item7 {

  public static void main(String[] args) throws Exception {
    FeedType feed = JAXB.unmarshal(new URL("http://search.twitter.com/search.atom?&q=java8"), FeedType.class);
    JAXB.marshal(feed, System.out);
  }

}
