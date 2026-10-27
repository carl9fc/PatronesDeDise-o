package co.edu.taller.behavioral;

public class RequestLifecycle {
    public enum Status {RECEIVED, IN_REVIEW, APPROVED, REJECTED}

    private interface State {
        Status status();

        default State review() {
            throw invalidTransition("review");
        }

        default State approve() {
            throw invalidTransition("approve");
        }

        default State reject() {
            throw invalidTransition("reject");
        }

        private IllegalStateException invalidTransition(String action) {
            return new IllegalStateException("Cannot " + action + " a request in status " + status());
        }
    }

    private static final State RECEIVED = new State() {
        @Override
        public Status status() {
            return Status.RECEIVED;
        }

        @Override
        public State review() {
            return IN_REVIEW;
        }
    };

    private static final State IN_REVIEW = new State() {
        @Override
        public Status status() {
            return Status.IN_REVIEW;
        }

        @Override
        public State approve() {
            return APPROVED;
        }

        @Override
        public State reject() {
            return REJECTED;
        }
    };

    private static final State APPROVED = () -> Status.APPROVED;
    private static final State REJECTED = () -> Status.REJECTED;

    private State state = RECEIVED;

    public Status status() {
        return state.status();
    }

    public void review() {
        state = state.review();
    }

    public void approve() {
        state = state.approve();
    }

    public void reject() {
        state = state.reject();
    }
}