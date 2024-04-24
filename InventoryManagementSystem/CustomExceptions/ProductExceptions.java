package InventoryManagementSystem.CustomExceptions;

public class ProductExceptions {
    public static class InvalidProductStateException extends RuntimeException {
        public InvalidProductStateException(String message) {
            super(message);
        }
    }

    public static class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public static class ProductOutOfStockException extends Exception {
        public ProductOutOfStockException(String message) {
            super(message);
        }
    }

    public static class ProductAlreadyExistsException extends Exception {
        public ProductAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class InsufficientProductQuantityException extends Exception {
        public InsufficientProductQuantityException(String message) {
            super(message);
        }
    }
}