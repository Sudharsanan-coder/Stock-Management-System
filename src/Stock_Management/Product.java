// Product.java
package Stock_Management;
public class Product {
    private String productId;
    private String productName;
    private String category;
    private int quantity;
    private double pricePerUnit;
    private String supplierName;

    //Product

    public Product(String productId, String productName, String category, int quantity, double pricePerUnit, String supplierName) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.supplierName = supplierName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantityChange) {
        int newQuantity = this.quantity + quantityChange;
        if (newQuantity < 0) {
            System.out.println("Error: Quantity cannot be negative.");
        } else {
            this.quantity = newQuantity;
            System.out.println("Quantity updated successfully.");
        }
    }

    public void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per Unit: " + pricePerUnit);
        System.out.println("Supplier Name: " + supplierName);
        System.out.println("------------------------------------");
    }
}
