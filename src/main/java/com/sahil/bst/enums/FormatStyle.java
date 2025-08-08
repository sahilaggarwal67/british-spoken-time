package com.sahil.bst.enums;

import java.util.Arrays;
import java.util.Locale;

/**
 * This enum list which all spoken format style are supported, and then bind it to a Locale,
 * then that Locale is used to find the spoken formatter to format input time
 */
public enum FormatStyle {
    BRITISH("british", Locale.UK);

    private final String style;

    private final Locale locale;

    FormatStyle(String style, Locale locale) {
        this.style = style;
        this.locale = locale;
    }

    public String getStyle() {
        return style;
    }

    public Locale getLocale() {
        return locale;
    }

    public static FormatStyle fromString(String style) {
        return Arrays.stream(values())
                .filter(s -> s.style.equalsIgnoreCase(style))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown style: " + style));
    }

    public static String availableStyles() {
        StringBuilder sb = new StringBuilder();
        for (FormatStyle s : values()) {
            sb.append(s.style).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
