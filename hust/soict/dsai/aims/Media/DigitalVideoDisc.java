package hust.soict.dsai.aims.Media;

public class DigitalVideoDisc extends Media implements Comparable<DigitalVideoDisc> {
    private int length;
    private String director;

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Ghi đè phương thức compareTo để sắp xếp theo tiêu đề, độ dài (giảm dần) và giá
    @Override
    public int compareTo(DigitalVideoDisc other) {
        // So sánh theo tiêu đề
        int titleCompare = this.getTitle().compareTo(other.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }

        // Nếu tiêu đề giống nhau, so sánh theo độ dài (giảm dần)
        int lengthCompare = Integer.compare(other.getLength(), this.getLength());
        if (lengthCompare != 0) {
            return lengthCompare;
        }

        // Nếu độ dài giống nhau, so sánh theo giá
        return Float.compare(this.getCost(), other.getCost());
    }
}
