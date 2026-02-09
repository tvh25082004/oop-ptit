import java.util.Scanner;

class Product {
    String productId;
    String name;
    double price;

    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Sản phẩm: " + name + " (Mã: " + productId + ")");
        System.out.printf("Giá: %.1f%n", price);
    }
}

class Order {
    String orderId;
    Product product;
    int quantity;

    Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    double calculateTotal() {
        return quantity * product.price;
    }

    void display() {
        System.out.println("--- Thông tin đơn hàng ---");
        System.out.println("Đơn hàng: " + orderId);
        product.display();
        System.out.println("Số lượng: " + quantity);
        System.out.printf("Tổng tiền: %.1f%n", calculateTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productId = sc.nextLine();
        String name = sc.nextLine();
        double price = Double.parseDouble(sc.nextLine());

        String orderId = sc.nextLine();
        int quantity = Integer.parseInt(sc.nextLine());

        Product product = new Product(productId, name, price);
        Order order = new Order(orderId, product, quantity);

        order.display();
    }
}
