import java.util.ArrayList;
import java.util.List;

class Item {
    private String product;
    private int quantity;
    private int unitPrice;

    public Item(String product, int quantity, int unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void printInfo() {
        int price = quantity * unitPrice;
        System.out.println("Product: " + product + " has quantity " + quantity + " with price: " + price);
    }
}

class Warehouse {
    private List<Item> items;

    public Warehouse() {
        this.items = new ArrayList<>();
    }

    public void importProduct(Item item) {
        items.add(item);
    }

    public void removeProduct(String product, int quantity) {
        for (Item item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() - quantity);
                break;
            }
        }
    }

    public void decreaseQuantityInWarehouseByOne() {
        for (Item item : items) {
            item.setQuantity(item.getQuantity() - 1);
        }
    }

    public void takeFromItemToWarehouse(List<Item> itemsToCheck, String product, int quantity) {
        // Find the item in warehouse
        Item warehouseItem = null;
        for (Item item : items) {
            if (item.getProduct().equals(product)) {
                warehouseItem = item;
                break;
            }
        }
        if (warehouseItem == null) return;

        // Find item in itemsToCheck
        Item checkItem = null;
        for (Item item : itemsToCheck) {
            if (item.getProduct().equals(product)) {
                checkItem = item;
                break;
            }
        }
        if (checkItem == null) return;

        // Add quantity to warehouse
        if (quantity > checkItem.getQuantity()) {
            warehouseItem.setQuantity(warehouseItem.getQuantity() + checkItem.getQuantity());
        } else {
            warehouseItem.setQuantity(warehouseItem.getQuantity() + quantity);
        }
    }

    public void printAll() {
        for (Item item : items) {
            item.printInfo();
        }
    }
}

class Main {
    public static void main(String[] args) {
        // (1) Tạo 2 Item và in thông tin
        Item milk = new Item("milk", 4, 2);
        Item buttermilk = new Item("buttermilk", 10, 2);

        milk.printInfo();
        buttermilk.printInfo();

        // (2) Thêm vào kho
        Warehouse warehouse = new Warehouse();
        warehouse.importProduct(milk);
        warehouse.importProduct(buttermilk);

        // (3) Xóa sản phẩm khỏi kho
        warehouse.removeProduct("milk", 1);
        warehouse.removeProduct("buttermilk", 3);
        warehouse.printAll();

        // (4) Giảm toàn bộ sản phẩm xuống 1
        warehouse.decreaseQuantityInWarehouseByOne();
        warehouse.printAll();

        // (5) Thêm từ itemsToCheck vào kho
        List<Item> itemsToCheck = new ArrayList<>();
        itemsToCheck.add(new Item("milk", 2, 2));
        itemsToCheck.add(new Item("buttermilk", 6, 2));

        warehouse.takeFromItemToWarehouse(itemsToCheck, "milk", 5);
        warehouse.takeFromItemToWarehouse(itemsToCheck, "buttermilk", 1);
        warehouse.printAll();
    }
}


// ```

// **Giải thích logic từng ý:**

// **Ý (1):** Tạo 2 Item, in ra với `price = quantity * unitPrice` → milk: 4×2=8, buttermilk: 10×2=20.

// **Ý (2):** `importProduct()` thêm Item vào danh sách trong kho.

// **Ý (3):** `removeProduct()` tìm sản phẩm theo tên rồi giảm quantity. milk: 4-1=3, buttermilk: 10-3=7.

// **Ý (4):** `decreaseQuantityInWarehouseByOne()` giảm tất cả xuống 1. milk: 3-1=2, buttermilk: 7-1=6.

// **Ý (5):** `takeFromItemToWarehouse()` — milk muốn thêm 5 nhưng itemsToCheck chỉ có 2 → thêm 2 → milk: 2+2=4. buttermilk muốn thêm 1, itemsToCheck có 6 → thêm đúng 1 → buttermilk: 6+1=7.

// **Output khớp đúng với đề:**
// ```
// Product: milk has quantity 4 with price: 8
// Product: buttermilk has quantity 10 with price: 20
// Product: milk has quantity 3 with price: 6
// Product: buttermilk has quantity 7 with price: 14
// Product: milk has quantity 2 with price: 4
// Product: buttermilk has quantity 6 with price: 12
// Product: milk has quantity 4 with price: 8
// Product: buttermilk has quantity 7 with price: 14