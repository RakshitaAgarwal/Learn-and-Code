package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;
import InventoryManagementSystem.CustomExceptions.InventoryExceptions.DataAccessException;
import InventoryManagementSystem.CustomExceptions.ProductExceptions.InvalidProductStateException;
import InventoryManagementSystem.Model.Product;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Sell Product");
            System.out.println("5. List Products");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        updateProduct();
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        sellProduct();
                        break;
                    case 5:
                        displayProducts(getProducts());
                        break;
                    case 6:
                        System.out.println("Exiting Inventory Management System.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please Make a valid choice.");
                }
            } catch (InvalidProductStateException e) {
                System.err.println(e.getMessage());
            } catch (DataAccessException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void addProduct() {
        Product product = takeProductInput();
        productManager.add(product);
    }

    private static void updateProduct() {
        Product product = takeProductInput();
        productManager.update(product);
    }

    private static void deleteProduct() {
        Product product = takeProductInput();
        productManager.delete(product);
    }

    private static void sellProduct() {
        Product product = takeProductInput();
        System.out.println("Enter Quantity to Sell: ");
        productManager.sell(product, sc.nextInt());
    }

    private static ArrayList<Product> getProducts() throws DataAccessException {
        return productManager.getProducts();
    }

    private static void displayProducts(ArrayList<Product> products) {
        for (int index = 0; index < products.size(); index++) {
            Product product = products.get(index);
            System.out.format("\nProduct %d -> ID: %d, Name: %s, Price: %.2f, Quantity: %d\n",
                    index + 1, product.getProductId(), product.getName(), product.getPrice(), product.getQuantity());
        }
    }

    private static Product takeProductInput() {
        System.out.println("Enter Product Details: ");
        System.out.println("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Product Price: ");
        double price = sc.nextDouble();
        System.out.println("Enter Product Quantity: ");
        int quantity = sc.nextInt();
        return new Product(id, name, price, quantity);
    }
}