package hust.soict.dsai.aims.Media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructors
    public Media() {}

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Media [Title: " + title + ", Category: " + category + ", Cost: " + cost + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // So sánh tham chiếu
        if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra null và cùng kiểu

        Media media = (Media) obj; // Ép kiểu
        return title != null && title.equals(media.title); // So sánh thuộc tính title
    }

    // Comparator để sắp xếp theo Tiêu đề rồi tới Giá trị
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            // So sánh theo tiêu đề
            int titleCompare = m1.getTitle().compareTo(m2.getTitle());
            if (titleCompare != 0) {
                return titleCompare;
            }
            // Nếu tiêu đề giống nhau, so sánh theo giá trị
            return Float.compare(m1.getCost(), m2.getCost());
        }
    };

    // Comparator để sắp xếp theo Giá trị rồi tới Tiêu đề
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            // So sánh theo giá trị
            int costCompare = Float.compare(m1.getCost(), m2.getCost());
            if (costCompare != 0) {
                return costCompare;
            }
            // Nếu giá trị giống nhau, so sánh theo tiêu đề
            return m1.getTitle().compareTo(m2.getTitle());
        }
    };
}
