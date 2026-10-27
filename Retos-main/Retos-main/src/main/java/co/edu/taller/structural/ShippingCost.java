package co.edu.taller.structural;

public interface ShippingCost {
    long cost();

    final class Standard implements ShippingCost {
        private static final long COST = 12_000;

        @Override
        public long cost() {
            return COST;
        }
    }

    abstract class AddOn implements ShippingCost {
        private final ShippingCost delegate;
        private final long surcharge;

        private AddOn(ShippingCost delegate, long surcharge) {
            if (delegate == null) {
                throw new IllegalArgumentException("Shipping cost delegate is required");
            }
            this.delegate = delegate;
            this.surcharge = surcharge;
        }

        @Override
        public long cost() {
            return Math.addExact(delegate.cost(), surcharge);
        }
    }

    final class Insurance extends AddOn {
        public Insurance(ShippingCost delegate) {
            super(delegate, 5_000);
        }
    }

    final class Priority extends AddOn {
        public Priority(ShippingCost delegate) {
            super(delegate, 4_500);
        }
    }
}
