package oneliners;

import java.util.*;
import java.util.stream.Accumulators;

import static java.util.Comparators.comparing;
import static java.util.function.MultiFunction.Collector;

/**
 * Find the names of albums that have at least one track rated four or higher, sorted by name.
 * <p/>
 * Reference: http://cr.openjdk.java.net/~briangoetz/lambda/sotc3.html
 */
public class Item10 {

  public static class Album implements Comparable<Album> {

    public final String name;
    public final String artist;

    public Album(String name, String artist) {
      this.name = name;
      this.artist = artist;
    }

    @Override
    public int compareTo(Album album) {
      return this.name.compareTo(album.name);
    }

    public List<Track> tracks = new ArrayList<>();

  }

  public static class Track implements Comparable<Track> {
    public final String name;
    public final int rating;

    public Track(String name, int rating) {
      this.name = name;
      this.rating = rating;
    }

    @Override
    public int compareTo(Track track) {
      return this.name.compareTo(track.name);
    }

    public int getRating() {
      return rating;
    }
  }

  public static void main(String[] args) {
    Album tailgates = new Album("Tailgates & Tanlines", "Luke Bryan");
    tailgates.tracks.add(new Track("Country Girl (Shake It for Me)", 5));
    tailgates.tracks.add(new Track("Kiss Tomorrow Goodbye", 5));
    tailgates.tracks.add(new Track("Drunk On You", 4));
    tailgates.tracks.add(new Track("Too Damn Young", 4));
    tailgates.tracks.add(new Track("I Don't Want This Night to End", 4));
    tailgates.tracks.add(new Track("You Don't Know Jack", 4));
    tailgates.tracks.add(new Track("Harvest Time", 3));
    tailgates.tracks.add(new Track("I Know You're Gonna Be There", 3));
    tailgates.tracks.add(new Track("Muckalee Creek Water", 3));
    tailgates.tracks.add(new Track("Tailgate Blues", 3));
    tailgates.tracks.add(new Track("Been There, Done That", 3));
    tailgates.tracks.add(new Track("Faded Away", 3));
    tailgates.tracks.add(new Track("I Knew You That Way", 3));

    Album unapologetic = new Album("Unapologetic", "Rihanna");
    unapologetic.tracks.add(new Track("Phresh Out the Runway", 5));
    unapologetic.tracks.add(new Track("Diamonds", 3));
    unapologetic.tracks.add(new Track("Numb", 3));
    unapologetic.tracks.add(new Track("Pour It Up", 3));
    unapologetic.tracks.add(new Track("Loveeeeeee Song", 4));
    unapologetic.tracks.add(new Track("Jump", 4));
    unapologetic.tracks.add(new Track("Right Now", 4));
    unapologetic.tracks.add(new Track("What Now", 4));
    unapologetic.tracks.add(new Track("Stay", 4));
    unapologetic.tracks.add(new Track("Nobody's Business", 5));
    unapologetic.tracks.add(new Track("Love Without Tragedy", 5));
    unapologetic.tracks.add(new Track("Get It Over With", 5));
    unapologetic.tracks.add(new Track("No Love Allowed", 3));
    unapologetic.tracks.add(new Track("Lost In Paradise", 5));

    Album red = new Album("Red", "Taylor Swift");
    red.tracks.add(new Track("State of Grace", 4));
    red.tracks.add(new Track("Red", 4));
    red.tracks.add(new Track("Treacherous", 4));
    red.tracks.add(new Track("I Knew You Were Trouble", 5));
    red.tracks.add(new Track("All Too Well", 3));
    red.tracks.add(new Track("22", 3));
    red.tracks.add(new Track("I Almost Do", 3));
    red.tracks.add(new Track("We Are Never Ever Getting Back", 3));
    red.tracks.add(new Track("Stay Stay Stay", 5));
    red.tracks.add(new Track("The Last Time", 5));
    red.tracks.add(new Track("Holy Ground", 3));
    red.tracks.add(new Track("Sad Beautiful Tragic", 3));
    red.tracks.add(new Track("The Lucky One", 4));
    red.tracks.add(new Track("Everything Has Changed", 3));
    red.tracks.add(new Track("Starlight", 4));
    red.tracks.add(new Track("Begin Again", 3));

    List<Album> albums = Arrays.asList(unapologetic, tailgates, red);

    // Print the names of albums that have at least one track rated four or higher, sorted by name.
    albums.stream()
      .filter(a -> a.tracks.stream().anyMatch(t -> (t.rating >= 4)))
      .sorted(comparing((Album album) -> album.name))
      .forEach(album -> System.out.println(album.name));

    // Merge tracks from all albums
    List<Track> allTracks = albums.stream()
      .mapMulti((Collector<Track> collector, Album element) -> collector.yield(element.tracks))
      .into(new ArrayList<Track>());

    // Group album tracks by rating
    Map<Integer, Collection<Track>> tracksByRating = allTracks.stream()
      .accumulate(Accumulators.<Track, Integer>groupBy(Track::getRating));
  }

}
