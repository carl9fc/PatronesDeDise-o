package co.edu.taller.behavioral;

public class ShippingRateStrategy {
    public interface Rate {
        long calculate(long base);
    }

    public enum Mode {STANDARD, EXPRESS, NIGHT}

    private static final long RATE_SCALE = 10_000;

    public long quote(Mode mode, long base) {
        if (mode == null) {
            throw new IllegalArgumentException("Shipping rate mode is required");
        }
        if (base <= 0) {
            throw new IllegalArgumentException("Base amount must be positive");
        }

        Rate strategy = switch (mode) {
            case STANDARD -> amount -> amount;
            case EXPRESS -> amount -> scaled(amount, 18_000);
            case NIGHT -> amount -> scaled(amount, 20_000);
        };
        return strategy.calculate(base);
    }

    private static long scaled(long amount, long rate) {
        return Math.multiplyExact(amount, rate) / RATE_SCALE;
    }
}