import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Warehouse {

    private Map<String, Integer> stocks = new HashMap<>();

    private Map<String, Integer> prices = new HashMap<>();

    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }

    public int price(String product) {
        if (!prices.containsKey(product)) {
            return -99;
        }
        return prices.get(product);
    }

    public int stock(String product) {
        if (!stocks.containsKey(product)) {
            return 0;
        }
        return stocks.get(product);
    }

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

    public Set<String> products() {
        return stocks.keySet();
    }
}

class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 6);
        warehouse.addProduct("buttermilk", 2, 2);
        warehouse.addProduct("yogurt", 2, 20);

        warehouse.take("buttermilk");
        warehouse.take("milk");
        warehouse.take("buttermilk");

        for (String product : warehouse.products()) {
            if (warehouse.stock(product) > 0) {
                System.out.println(product);
            }
        }
    }
}
