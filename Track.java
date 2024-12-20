public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object obj) {
        if (this == obj) return true; // So sánh tham chiếu
        if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra null và cùng kiểu

        Track track = (Track) obj; // Ép kiểu
        return title != null && title.equals(track.title) && length == track.length; // So sánh title và length
    }

}
