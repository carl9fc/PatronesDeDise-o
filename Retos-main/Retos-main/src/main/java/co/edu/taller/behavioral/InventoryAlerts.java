package co.edu.taller.behavioral;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryAlerts {
    public interface Listener {
        void onLowStock(String sku, int quantity);
    }

    private final int threshold;
    private final List<Listener> listeners = new CopyOnWriteArrayList<>();

    public InventoryAlerts(int threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException("Threshold cannot be negative");
        }
        this.threshold = threshold;
    }

    public void subscribe(Listener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener is required");
        }
        listeners.add(listener);
    }

    public void update(String sku, int quantity) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is required");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (quantity <= threshold) {
            for (Listener listener : listeners) {
                listener.onLowStock(sku, quantity);
            }
        }
    }
}