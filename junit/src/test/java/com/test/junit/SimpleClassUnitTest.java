package com.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleClassUnitTest {

    @Test
    void testGet() {
        assertEquals("Test", SimpleClass.get());
    }

}
