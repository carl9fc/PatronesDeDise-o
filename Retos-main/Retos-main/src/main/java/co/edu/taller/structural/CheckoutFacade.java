package co.edu.taller.structural;

public class CheckoutFacade {
    public interface Inventory {
        boolean reserve(String sku, int quantity);
    }

    public interface Payment {
        boolean charge(String orderId, long amount);
    }

    private final Inventory inventory;
    private final Payment payment;

    public CheckoutFacade(Inventory i, Payment p) {
        if (i == null || p == null) {
            throw new IllegalArgumentException("Inventory and payment services are required");
        }
        inventory = i;
        payment = p;
    }

    public String checkout(String orderId, String sku, int quantity, long amount) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID is required");
        }
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is required");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (!inventory.reserve(sku, quantity)) {
            throw new IllegalStateException("Inventory reservation failed for SKU: " + sku);
        }
        if (!payment.charge(orderId, amount)) {
            throw new IllegalStateException("Payment was declined for order: " + orderId);
        }
        return "CONFIRMED:" + orderId; 
    }
}

