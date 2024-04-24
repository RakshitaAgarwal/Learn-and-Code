package InventoryManagementSystem.CustomExceptions;

public class InventoryExceptions extends Exception{
    public static class DataAccessException extends Exception {
        public DataAccessException(String message) {
            super(message);
        }
    }

    public static class ConnectionFailureException extends Exception {
        public ConnectionFailureException(String message) {
            super(message);
        }
    }

    public static class NegativeInventoryException extends Exception {
        public NegativeInventoryException(String message) {
            super(message);
        }
    }
}