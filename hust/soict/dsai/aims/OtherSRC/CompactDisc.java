public class CompactDisc extends Disc implements Playable  {
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }
    public String toString() {
        return "CD [Title: " + title + ", Artist: " + artist + ", Category: " + category +
               ", Cost: " + cost + ", Length: " + getLength() + "]";
    }

    // Add track method
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Remove track method
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Get total length of the CD
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        for (Track track : tracks) {
            track.play();
        }
    }
}
