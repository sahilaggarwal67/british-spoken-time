package com.sahil.bst.formatter;

import java.time.LocalTime;
import java.util.Locale;

/**
 * Strategy interface for spoken time formatting.
 */
public interface SpokenTimeFormatter {
    String convert(LocalTime time);

    Locale getSupportedLocale();
}
