package com.sahil.bst.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * ResourceBundle backed provider for number words and basic phrases.
 */
public final class NumberWordProvider {
    private final ResourceBundle bundle;

    public NumberWordProvider(Locale locale) {
        this.bundle = ResourceBundle.getBundle("messages", locale);
    }

    public String toWords(int n) {
        if (n < 0 || n >= 60)
            throw new IllegalArgumentException("Number out of range 0..59: " + n);
        if (n <= 19)
            return get("digit." + n);
        if (n < 30) {
            if (n == 20)
                return get("tens.20");
            return get("tens.20") + " " + get("digit." + (n - 20));
        }
        if (n < 40) {
            if (n == 30)
                return get("tens.30");
            return get("tens.30") + " " + get("digit." + (n - 30));
        }
        if (n < 50) {
            if (n == 40)
                return get("tens.40");
            return get("tens.40") + " " + get("digit." + (n - 40));
        }
        if (n < 60) {
            if (n == 50)
                return get("tens.50");
            return get("tens.50") + " " + get("digit." + (n - 50));
        }
        throw new IllegalStateException("Unhandled number: " + n);
    }

    public String getPhrase(String key) {
        return get(key);
    }

    private String get(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException ex) {
            throw new IllegalStateException("Missing resource key: " + key + " in bundle " + bundle.getBaseBundleName(), ex);
        }
    }
}
