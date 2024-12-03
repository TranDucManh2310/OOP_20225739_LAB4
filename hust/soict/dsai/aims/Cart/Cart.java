package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media; // Đảm bảo import Media class
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); // Sử dụng ArrayList thay vì mảng
    private int qtyOrdered = 0; // Không cần thiết nữa, có thể xóa nếu muốn

    // Thêm phương thức để thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            qtyOrdered++;
            System.out.println("Mục đã được thêm: " + media.getTitle());
        } else {
            System.out.println("Giỏ hàng gần đầy!");
        }
    }

    // Thêm phương thức để thêm nhiều Media vào giỏ hàng
    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                qtyOrdered++;
                System.out.println("Mục đã được thêm: " + media.getTitle());
            } else {
                System.out.println("Giỏ hàng gần đầy! Không thể thêm: " + media.getTitle());
                break;
            }
        }
    }

    // Thêm phương thức để xóa Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered.get(i).equals(media)) {
                found = true;
                itemsOrdered.remove(i);
                qtyOrdered--;
                System.out.println("Mục đã được xóa: " + media.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy mục trong giỏ hàng.");
        }
    }

    // Tính tổng chi phí của các mục trong giỏ hàng
    public double totalCost() {
        double totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // In thông tin giỏ hàng
    public void printCart() {
        System.out.println("Giỏ hàng hiện tại có " + qtyOrdered + " mục:");
        for (Media media : itemsOrdered) {
            System.out.println("- " + media.getTitle() + ": " + media.getCost());
        }
        System.out.println("Tổng chi phí: " + totalCost());
    }

    // Tìm kiếm mục trong giỏ hàng theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Tìm kiếm mục trong giỏ hàng theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
}
