package hust.soict.dsai.aims.Cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + disc.getTitle());
        } else {
            System.out.println("Giỏ hàng gần đầy!");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Đĩa đã được thêm: " + disc.getTitle());
            } else {
                System.out.println("Giỏ hàng gần đầy! Không thể thêm đĩa: " + disc.getTitle());
                break; 
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED - 1) { 
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + dvd1.getTitle());
            
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + dvd2.getTitle());
        } else if (qtyOrdered < MAX_NUMBERS_ORDERED) { 
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + dvd1.getTitle());
            System.out.println("Giỏ hàng gần đầy! Không thể thêm đĩa: " + dvd2.getTitle());
        } else { 
            System.out.println("Giỏ hàng đã đầy! Không thể thêm đĩa: " + dvd1.getTitle() + " và " + dvd2.getTitle());
        }
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Đĩa đã được xóa: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa trong giỏ hàng.");
        }
    }

    public double totalCost() {
        double totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("Giỏ hàng hiện tại có " + qtyOrdered + " đĩa:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println("- " + itemsOrdered[i].getTitle() + ": " + itemsOrdered[i].getCost());
        }
        System.out.println("Tổng chi phí: " + totalCost());
    }
    public void printCart2() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        
        double totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            totalCost += itemsOrdered[i].getCost();
        }
        
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
    public void searchById(int id) {
        boolean found = false;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null && dvd.getId() == id) {
                System.out.println("Found: " + dvd.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null && dvd.isMatch(title)) {
                System.out.println("Found: " + dvd.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }



}
