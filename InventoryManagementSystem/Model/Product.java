package InventoryManagementSystem.Model;

import InventoryManagementSystem.CustomExceptions.ProductExceptions.InvalidProductStateException;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void validateData() throws InvalidProductStateException {
        if (this.productId <= 0) {
            throw new InvalidProductStateException("Invalid Product Id");
        } else if (this.name == null || this.name.isEmpty()) {
            throw new InvalidProductStateException("Product name is required");
        } else if (this.price <= 0) {
            throw new InvalidProductStateException("Product price is required");
        } else if (this.quantity <= 0) {
            throw new InvalidProductStateException("Product quantity is required");
        }
    }
}