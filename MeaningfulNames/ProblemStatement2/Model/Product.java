package ProblemStatement2.Model;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return name;
    }

    public double getProductPrice() {
        return price;
    }

    public int getProductQuantity() {
        return quantity;
    }

    public void setProductQuantity(int quantity) {
        this.quantity = quantity;
    }
}