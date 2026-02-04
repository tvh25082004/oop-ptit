import java.util.HashMap;
import java.util.Map;

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

        int currentStock = stocks.get(product);
        if (currentStock <= 0) {
            return false;
        }

        stocks.put(product, currentStock - 1);
        return true;
    }
}

class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        warehouse.addProduct("coffee", 5, 1);

        System.out.println("stock:");
        System.out.println("coffee:  " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));

        System.out.println("taking coffee " + warehouse.take("coffee"));
        System.out.println("taking coffee " + warehouse.take("coffee"));
        System.out.println("taking sugar " + warehouse.take("sugar"));

        System.out.println("stock:");
        System.out.println("coffee:  " + warehouse.stock("coffee"));
        System.out.println("sugar: " + warehouse.stock("sugar"));
    }
}
