package com.sahil.bst.formatter;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Objects;

import com.sahil.bst.i18n.NumberWordProvider;

/**
 * British spoken time implementation for Spoken time formatter
 */
public class BritishSpokenTimeFormatter implements SpokenTimeFormatter {
    private final NumberWordProvider words;

    public BritishSpokenTimeFormatter() {
        this.words = new NumberWordProvider(getSupportedLocale());
    }

    @Override
    public Locale getSupportedLocale() {
        return Locale.UK;
    }

    @Override
    public String convert(LocalTime time) {
        Objects.requireNonNull(time);
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour == 0 && minute == 0)
            return words.getPhrase("special.midnight");
        if (hour == 12 && minute == 0)
            return words.getPhrase("special.noon");

        int hour12 = hour % 12 == 0 ? 12 : hour % 12;
        int nextHour12 = (hour + 1) % 12 == 0 ? 12 : (hour + 1) % 12;

        if (minute == 0) {
            return words.toWords(hour12) + " " + words.getPhrase("phrase.oclock");
        }

        if (minute == 15) {
            return words.getPhrase("phrase.quarter") + " " + words.getPhrase("phrase.past") + " " + words.toWords(hour12);
        }

        if (minute == 30) {
            return words.getPhrase("phrase.half") + " " + words.getPhrase("phrase.past") + " " + words.toWords(hour12);
        }

        if (minute < 30) {
            return words.toWords(minute) + " " + words.getPhrase("phrase.past") + " " + words.toWords(hour12);
        }

        // In requirement there is confusion about minutes like 32,33. It is not properly mentioned which times need to be directly called 
        // like Six thirty two. So for now skipping that use case. If we have to implement it we can return words.toWords(hour12) + " " + words.toWords(minute);

        int minutesTo = 60 - minute;
        if (minutesTo == 15) {
            return words.getPhrase("phrase.quarter") + " " + words.getPhrase("phrase.to") + " " + words.toWords(nextHour12);
        }
        return words.toWords(minutesTo) + " " + words.getPhrase("phrase.to") + " " + words.toWords(nextHour12);
    }
}
