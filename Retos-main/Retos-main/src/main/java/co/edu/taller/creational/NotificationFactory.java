package co.edu.taller.creational;

public class NotificationFactory {
    public interface Notifier {
        String send(String recipient, String message);
    }

    public enum Channel {EMAIL, SMS}

    public Notifier create(Channel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Notification channel is required");
        }

        return switch (channel) {
            case EMAIL -> (recipient, message) -> format("EMAIL", recipient, message);
            case SMS -> (recipient, message) -> format("SMS", recipient, message);
        };
    }

    private static String format(String channel, String recipient, String message) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Recipient is required");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message is required");
        }
        return channel + ":" + recipient + ":" + message;
    }
}