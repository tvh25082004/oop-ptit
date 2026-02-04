import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Lớp Warehouse
class Warehouse {

    // Lưu số lượng tồn kho (theo yêu cầu đề bài)
    private Map<String, Integer> stocks = new HashMap<>();

    // Lưu giá (không lưu trong HashMap chính)
    private Map<String, Integer> prices = new HashMap<>();

    // Thêm sản phẩm
    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }

    // Lấy giá sản phẩm
    public int price(String product) {
        if (!prices.containsKey(product)) {
            return -99;
        }
        return prices.get(product);
    }

    // Lấy số lượng tồn kho
    public int stock(String product) {
        if (!stocks.containsKey(product)) {
            return 0;
        }
        return stocks.get(product);
    }

    // Lấy 1 sản phẩm ra khỏi kho
    public boolean take(String product) {
        if (!stocks.containsKey(product)) {
            return false;
        }

        int currentStock = stocks.get(product) - 1;
        if (currentStock < 0) {
            currentStock = 0;
        }

        stocks.put(product, currentStock);
        return true;
    }

    // Lấy danh sách sản phẩm
    public Set<String> products() {
        return stocks.keySet();
    }
}

// Main
class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        // Thêm sản phẩm
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 6);
        warehouse.addProduct("buttermilk", 2, 2);
        warehouse.addProduct("yogurt", 2, 20);

        // Lấy sản phẩm ra khỏi kho
        warehouse.take("buttermilk");
        warehouse.take("milk");
        warehouse.take("buttermilk");

        // In danh sách sản phẩm còn lại (stock > 0)
        for (String product : warehouse.products()) {
            if (warehouse.stock(product) > 0) {
                System.out.println(product);
            }
        }
    }
}
