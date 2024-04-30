package InventoryManagementSystem;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import InventoryManagementSystem.Model.Product;
import InventoryManagementSystem.CustomExceptions.InventoryExceptions.*;
import InventoryManagementSystem.CustomExceptions.ProductExceptions.*;

public class ProductManager {
    private ArrayList<Product> availableProducts = new ArrayList();

    public void add(Product product) throws InvalidProductStateException {
        try {
            product.validateData();
            if (productExists(product.getProductId())) {
                throw new ProductAlreadyExistsException("Product already exists");
            } else
                availableProducts.add(product);
        } catch (ProductAlreadyExistsException e) {
            Product existingProduct = availableProducts.get(availableProducts.indexOf(product));
            existingProduct.setQuantity(existingProduct.getQuantity() + 1);
            System.out.println(
                    "This product already exists in the inventory. Updated the quantity of already existing product.");
        } finally {
            System.out.println("product add operation successful");
        }
    }

    public void delete(Product product) throws InvalidProductStateException {
        try {
            product.validateData();
            if (productExists(product.getProductId())) {
                availableProducts.remove(product);
            } else
                throw new ProductNotFoundException("Product Not found in the Inventory");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("product delete operation successful");
        }
    }

    public void update(Product product) throws InvalidProductStateException {
        try {
            product.validateData();
            if (productExists(product.getProductId())) {
                availableProducts.set(availableProducts.indexOf(findProductById(product.getProductId())), product);
            } else
                throw new ProviderNotFoundException("Product Not found in the Inventory");

        } catch (ProductNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("product update operation successful");
        }
    }

    public ArrayList<Product> getProducts() throws DataAccessException {
        try {
            boolean isConnected = true;
            if (!isConnected)
                throw new ConnectionFailureException("Network Failure");
            if (availableProducts.isEmpty())
                throw new NegativeInventoryException("No products available");
            return availableProducts;
        } catch (NegativeInventoryException | ConnectionFailureException e) {
            System.err.println(e.getMessage());
            throw new DataAccessException("Unable to List available products");
        }
    }

    public void sell(Product product, int quantity) throws InvalidProductStateException {
        try {
            product.validateData();
            if (quantity <= 0)
                throw new InsufficientProductQuantityException("required quantity must be a positive number.");
            if (productExists(product.getProductId())) {
                Product productToSell = findProductById(product.getProductId());
                if (productToSell.getQuantity() > quantity) {
                    productToSell.setQuantity(productToSell.getQuantity() - quantity);
                    update(productToSell);
                } else if (productToSell.getQuantity() == quantity) {
                    delete(productToSell);
                } else {
                    throw new ProductOutOfStockException("Insufficient quantity of product available in the inventory");
                }
            } else {
                throw new ProductNotFoundException("Product does not exist in the invertory.");
            }
        } catch (InsufficientProductQuantityException e) {
            System.out.println(e.getMessage());
        } catch (ProductOutOfStockException e) {
            System.err.println(e.getMessage());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("product sell operation successful");
        }
    }

    private Product findProductById(int productId) throws ProductNotFoundException {
        return availableProducts.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product Not found in the Inventory"));
    }

    private boolean productExists(int productId) {
        return availableProducts.stream()
                .anyMatch(product -> product.getProductId() == productId);
    }
}