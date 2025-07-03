package Stock_Management;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public boolean addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            return false;
        }
        inventory.put(product.getProductId(), product);
        return true;
    }

    public boolean updateStock(String productId, int quantityChange) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.updateQuantity(quantityChange);
            return true;
        }
        return false;
    }


    public Product searchById(String productId) {
        return inventory.get(productId);
    }



    public void searchByName(String name) {
        boolean found = false;
        for (Product product : inventory.values()) {
            if (product.getProductName().equals(name)) {
                product.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with that name.");
        }
    }

    public void searchByCategory(String category) {
        boolean found = false;
        for (Product product : inventory.values()) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                product.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found in that category.");
        }
    }
}
