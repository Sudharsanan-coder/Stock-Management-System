// PerishableProduct.java
package Stock_Management;

public class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(String productId, String productName, String category,
                             int quantity, double pricePerUnit, String supplierName, String expiryDate) {
        super(productId, productName, category, quantity, pricePerUnit, supplierName); // call parent constructor
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


    public void display() {
        super.display(); // call parent method
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("------------------------------------");
    }
}
