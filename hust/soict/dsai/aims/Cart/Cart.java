package hust.soict.dsai.aims.Cart;

import hust.soict.dsai.aims.Media.DigitalVideoDisc;
import hust.soict.dsai.aims.Media.Media;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Các phương thức thêm đĩa vẫn giữ nguyên...

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + disc.getTitle());
        } else {
            System.out.println("Giỏ hàng gần đầy!");
        }
    }

    // Sắp xếp giỏ hàng theo tiêu đề và giá trị
    public void sortByTitleAndCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Giỏ hàng đã được sắp xếp theo tiêu đề và giá trị.");
    }

    // Sắp xếp giỏ hàng theo giá trị và tiêu đề
    public void sortByCostAndTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Giỏ hàng đã được sắp xếp theo giá trị và tiêu đề.");
    }

    // Phương thức printCart đã có sẵn để in ra giỏ hàng...
    public void printCart() {
        System.out.println("Giỏ hàng hiện tại có " + qtyOrdered + " đĩa:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println("- " + itemsOrdered[i].getTitle() + ": " + itemsOrdered[i].getCost());
        }
        System.out.println("Tổng chi phí: " + totalCost());
    }

    // Phương thức sortMedia để sắp xếp giỏ hàng
    public void sortMedia() {
        // Bạn có thể gọi sortByTitleAndCost hoặc sortByCostAndTitle tùy theo yêu cầu
        sortByTitleAndCost(); // Hoặc sortByCostAndTitle();
    }
}
