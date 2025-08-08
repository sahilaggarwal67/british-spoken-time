package com.sahil.bst.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FormatStyleTest {
    @Test
    void fromString() {
        assertEquals(FormatStyle.BRITISH, FormatStyle.fromString("british"));
    }
}
