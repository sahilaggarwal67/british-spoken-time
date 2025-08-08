package com.sahil.bst.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.sahil.bst.factory.SpokenTimeFormatterFactory;

class FormatterBehaviorTest {
    @Test
    void britishExamples() {
        Optional<SpokenTimeFormatter> f = SpokenTimeFormatterFactory.getFormatter(Locale.UK);
        assertTrue(f.isPresent());
        SpokenTimeFormatter fmt = f.get();
        assertEquals("half past seven", fmt.convert(LocalTime.of(7, 30)));
        assertEquals("quarter past four", fmt.convert(LocalTime.of(4, 15)));
        assertEquals("midnight", fmt.convert(LocalTime.of(0, 0)));
    }

}
