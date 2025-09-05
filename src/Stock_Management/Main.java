package Stock_Management;
import java.util.Scanner;

public class Main {
    private static final Inventory inventory = new Inventory();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Inventory Management =====");
            System.out.println("1. Add New Product");
            System.out.println("2. Update Stock Quantity");
            System.out.println("3. Search Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    updateStock();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addNewProduct() {
        System.out.print("Enter Product Type (1. Normal  2. Perishable): ");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();

        if (inventory.searchById(productId) != null) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Price per Unit: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Supplier Name: ");
        String supplier = scanner.nextLine();

        Product product; // Parent reference

        if (type == 2) {
            System.out.print("Enter Expiry Date: ");
            String expiryDate = scanner.nextLine();
            product = new PerishableProduct(productId, productName, category, quantity, price, supplier, expiryDate);
        } else {
            product = new Product(productId, productName, category, quantity, price, supplier);
        }

        if (inventory.addProduct(product)) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Failed to add product.");
        }
    }


    private static void updateStock() {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();

        Product product = inventory.searchById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter Quantity to add/remove (use negative number to remove): ");
        int quantityChange = Integer.parseInt(scanner.nextLine());
        inventory.updateStock(productId, quantityChange);
    }

    private static void searchProduct() {
        System.out.println("Search by: 1. Product ID  2. Product Name  3. Category");
        int searchOption = Integer.parseInt(scanner.nextLine());

        switch (searchOption) {
            case 1:
                System.out.print("Enter Product ID: ");
                String id = scanner.nextLine();
                Product product = inventory.searchById(id);
                if (product != null) {
                    product.display();
                } else {
                    System.out.println("Product not found.");
                }
                break;
            case 2:
                System.out.print("Enter Product Name: ");
                String name = scanner.nextLine();
                inventory.searchByName(name);
                break;
            case 3:
                System.out.print("Enter Category: ");
                String category = scanner.nextLine();
                inventory.searchByCategory(category);
                break;
            default:
                System.out.println("Invalid search option.");
        }
    }
}
