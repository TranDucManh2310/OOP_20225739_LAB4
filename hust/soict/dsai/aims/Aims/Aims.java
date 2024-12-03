import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.Cart.Cart;
import hust.soict.dsai.aims.Media.Media;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store(); // Tạo cửa hàng
        Cart cart = new Cart(); // Tạo giỏ hàng
        Scanner scanner = new Scanner(System.in);

        // Hiển thị menu chính
        while (true) {
            showMenu();
            int choice = getInput(scanner); // Lấy nhập từ người dùng

            switch (choice) {
                case 1:
                    storeMenu(store, cart, scanner); // Xem cửa hàng
                    break;
                case 2:
                    updateStore(store, scanner); // Cập nhật cửa hàng
                    break;
                case 3:
                    cartMenu(cart, scanner); // Xem giỏ hàng hiện tại
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem cửa hàng");
        System.out.println("2. Cập nhật cửa hàng");
        System.out.println("3. Xem giỏ hàng hiện tại");
        System.out.println("0. Thoát");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng chọn một số: 0-1-2-3");
    }
    
    public static void storeMenu(Store store, Cart cart, Scanner scanner) {
        System.out.println("Tùy chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem chi tiết của một media");
        System.out.println("2. Thêm media vào giỏ hàng");
        System.out.println("3. Chạy media");
        System.out.println("4. Xem giỏ hàng hiện tại");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng chọn một số: 0-1-2-3-4");
        
        int choice = getInput(scanner);
        switch (choice) {
            case 1:
                viewMediaDetails(store, scanner);
                break;
            case 2:
                addMediaToCart(store, cart, scanner);
                break;
            case 3:
                playMedia(store, scanner);
                break;
            case 4:
                cart.printCart();
                break;
            case 0:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        // Cập nhật cửa hàng (thêm hoặc xóa media)
        System.out.println("Cập nhật cửa hàng: ");
        System.out.println("1. Thêm media vào cửa hàng");
        System.out.println("2. Xóa media khỏi cửa hàng");
        int choice = getInput(scanner);
        switch (choice) {
            case 1:
                // Thêm media vào cửa hàng (Giả sử bạn có phương thức addMedia)
                break;
            case 2:
                // Xóa media khỏi cửa hàng (Giả sử bạn có phương thức removeMedia)
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void cartMenu(Cart cart, Scanner scanner) {
        System.out.println("Tùy chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Lọc media trong giỏ hàng");
        System.out.println("2. Sắp xếp media trong giỏ hàng");
        System.out.println("3. Xóa media khỏi giỏ hàng");
        System.out.println("4. Chạy media");
        System.out.println("5. Đặt hàng");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng chọn một số: 0-1-2-3-4-5");
        
        int choice = getInput(scanner);
        switch (choice) {
            case 1:
                // Lọc media trong giỏ hàng
                break;
            case 2:
                // Sắp xếp media trong giỏ hàng
                break;
            case 3:
                // Xóa media khỏi giỏ hàng
                break;
            case 4:
                // Chạy media
                break;
            case 5:
                // Đặt hàng
                cart.clearCart();
                System.out.println("Đặt hàng thành công.");
                break;
            case 0:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void viewMediaDetails(Store store, Scanner scanner) {
        System.out.println("Nhập tiêu đề của media:");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title); // Lấy media từ cửa hàng
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(store, media, scanner);
        } else {
            System.out.println("Không tìm thấy media có tiêu đề này.");
        }
    }

    public static void mediaDetailsMenu(Store store, Media media, Scanner scanner) {
        System.out.println("Tùy chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Thêm vào giỏ hàng");
        System.out.println("2. Chạy");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        
        int choice = getInput(scanner);
        switch (choice) {
            case 1:
                addMediaToCart(store, cart, scanner);
                break;
            case 2:
                playMedia(store, scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.println("Nhập tiêu đề của media bạn muốn thêm vào giỏ hàng:");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title); // Lấy media từ cửa hàng
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Đã thêm " + media.getTitle() + " vào giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy media với tiêu đề này.");
        }
    }

    public static void playMedia(Store store, Scanner scanner) {
        // Giả sử phương thức này xử lý việc phát media
        System.out.println("Phát media...");
    }

    public static int getInput(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
