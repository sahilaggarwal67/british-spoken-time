package com.sahil.bst.factory;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.sahil.bst.formatter.BritishSpokenTimeFormatter;
import com.sahil.bst.formatter.SpokenTimeFormatter;

/**
 * This is the single entry point to retrieve spoken time formatter based on locale
 */
public final class SpokenTimeFormatterFactory {
    private static final List<SpokenTimeFormatter> formatters;

    static {
        // While using spring boot, this we can achieve by constructor autowiring of list of SpokenTimeFormatter beans
        formatters = Collections.unmodifiableList(List.of(new BritishSpokenTimeFormatter()));
    }

    private SpokenTimeFormatterFactory() {
    }

    public static Optional<SpokenTimeFormatter> getFormatter(Locale locale) {
        for (SpokenTimeFormatter formatter : formatters) {
            if (formatter.getSupportedLocale().equals(locale)) {
                return Optional.of(formatter);
            }
        }
        return Optional.empty();
    }

}
