package co.edu.taller.creational;

import java.util.Map;

public class PlatformConfig {
    private static final class Holder {
        private static final PlatformConfig INSTANCE = new PlatformConfig();
    }

    private final Map<String, String> settings = Map.of("environment", "production");

    private PlatformConfig() {
    }

    public static PlatformConfig instance() {
        return Holder.INSTANCE; 
    }

    public String get(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Configuration key is required");
        }
        String value = settings.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Unknown configuration key: " + key);
        }
        return value;
    }
}