package com.sahil.bst.formatter;

import org.junit.jupiter.api.Test;

import com.sahil.bst.AppMain;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppMainTest {

    @Test
    public void testWithArgsBritish() throws Exception {
        String[] args = { "6:15", "british" };
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        AppMain.main(args);

        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("quarter past six"),
                "Output should contain 'quarter past six'");
    }

}
