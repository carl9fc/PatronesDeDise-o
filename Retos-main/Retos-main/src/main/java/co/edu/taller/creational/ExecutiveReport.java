package co.edu.taller.creational;

import java.util.*;

public class ExecutiveReport {
    private final String title, period;
    private final List<String> sections;

    private ExecutiveReport(Builder b) {
        title = b.title;
        period = b.period;
        sections = List.copyOf(b.sections);
    }

    public String title() {
        return title;
    }

    public String period() {
        return period;
    }

    public List<String> sections() {
        return sections;
    }

    public static class Builder {
        private String title, period;
        private final List<String> sections = new ArrayList<>();

        public Builder title(String v) {
            title = v;
            return this;
        }

        public Builder period(String v) {
            period = v;
            return this;
        }

        public Builder addSection(String v) {
            if (v == null || v.isBlank()) {
                throw new IllegalArgumentException("Section is required");
            }
            sections.add(v);
            return this;
        }

        public ExecutiveReport build() {
            if (title == null || title.isBlank()) {
                throw new IllegalStateException("Report title is required");
            }
            if (period == null || period.isBlank()) {
                throw new IllegalStateException("Report period is required");
            }
            return new ExecutiveReport(this);
        }
    }
}