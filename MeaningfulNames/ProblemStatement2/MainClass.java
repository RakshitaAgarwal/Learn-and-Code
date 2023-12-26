package ProblemStatement2;

import java.util.List;
import java.util.Scanner;
import ProblemStatement2.Model.Inventory;
import ProblemStatement2.Model.Product;

public class MainClass {
    public static void main(String[] p) {
        Inventory inventoryObj = new Inventory();
        Scanner scannerObj = new Scanner(System.in);

        while (true) {
            System.out.println("\nInv Mgmt System");
            System.out.println("1. Add Prod");
            System.out.println("2. Display Inv");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scannerObj.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter prod name: ");
                    String productName = scannerObj.next();
                    System.out.print("Enter prod price: ");
                    double productPrice = scannerObj.nextDouble();
                    System.out.print("Enter prod qty: ");
                    int productQuantity = scannerObj.nextInt();

                    Product product = new Product(productName, productPrice, productQuantity);
                    inventoryObj.addProduct(product);

                    System.out.println("Prod added successfully!");
                    break;

                case 2:
                    System.out.println("\nCurrent Inv:");
                    List<Product> inventoryProductList = inventoryObj.getProductList();
                    for (Product inventoryProduct : inventoryProductList) {
                        System.out.println("Name: " + inventoryProduct.getProductName() +
                                ", Price: $" + inventoryProduct.getProductPrice() +
                                ", Quantity: " + inventoryProduct.getProductQuantity());
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    scannerObj.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}