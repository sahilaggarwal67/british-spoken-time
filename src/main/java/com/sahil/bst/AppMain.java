package com.sahil.bst;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import com.sahil.bst.enums.FormatStyle;
import com.sahil.bst.factory.SpokenTimeFormatterFactory;
import com.sahil.bst.formatter.SpokenTimeFormatter;
import com.sahil.bst.parser.TimeParser;

/**
 * This is the entry point for the application, input to this program will be give by command line.
 * First it will ask for spoken style and then time and then will provide the formatted output.
 */
public final class AppMain {
    public static void main(String[] args) {
        String timeArg = args.length > 0 ? args[0] : null;
        String styleArg = args.length > 1 ? args[1] : null;

        if (timeArg == null || styleArg == null) {
            // Presenting available spoken styles
            System.out.println("Available styles:");
            System.out.print(FormatStyle.availableStyles());
        }

        String styleInput = styleArg;
        if (styleInput == null) {
            // Taking input as style
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter style: ");
            styleInput = sc.nextLine().trim();
        }

        FormatStyle style;
        try {
            // Converting style string to format style enum
            style = FormatStyle.fromString(styleInput);
        } catch (IllegalArgumentException ex) {
            System.err.println("Unknown style: " + styleInput);
            System.exit(2);
            return;
        }

        Locale locale = style.getLocale();
        // finding the spoken time formatter based on format style
        Optional<SpokenTimeFormatter> formatterOpt = SpokenTimeFormatterFactory.getFormatter(locale);
        if (formatterOpt.isEmpty()) {
            System.err.println("No formatter available for locale: " + locale);
            System.exit(3);
        }
        SpokenTimeFormatter formatter = formatterOpt.get();

        String input = timeArg;
        if (input == null) {
            // Taking the time input from the user
            System.out.print("Enter time (H:mm or HH:mm): ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
        }

        try {
            // converting the time input to Local date time
            LocalTime time = TimeParser.parse(input);
            // Finding the spoken form of the input time
            String spoken = formatter.convert(time);
            System.out.println(spoken);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            System.exit(4);
        }
    }
}
