package com.sahil.bst.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.sahil.bst.formatter.SpokenTimeFormatter;

class SpokenTimeFormatterFactoryTest {
    @Test
    void discoverBritishByLocale() {
        Optional<SpokenTimeFormatter> f = SpokenTimeFormatterFactory.getFormatter(Locale.UK);
        assertTrue(f.isPresent());
        assertEquals(Locale.UK.getLanguage(), f.get().getSupportedLocale().getLanguage());
    }

}
