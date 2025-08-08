package com.sahil.bst.parser;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * TimeParser: parse H:mm or HH:mm (24-hour) into LocalTime.
 */
public final class TimeParser {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("H:mm");

    private TimeParser() {
    }

    public static LocalTime parse(String input) {
        Objects.requireNonNull(input, "input cannot be null");
        String trimmed = input.trim();
        try {
            LocalTime t = LocalTime.parse(trimmed, FORMAT);
            return t;
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Invalid time format. Expected H:mm or HH:mm (24-hour), e.g. 07:30", ex);
        }
    }
}
