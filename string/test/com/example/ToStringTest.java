package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToStringTest {
    @Test
    public void toStringTest() throws Exception {
        assertEquals("string1",ToString.toString(new String[]{"string1"}));
    }
    @Test
    public void toStringTest2() throws Exception {
        assertEquals("string1, string2",ToString.toString(new String[]{"string1","string2"}));
    }
    @Test
    public void toStringTest3() throws Exception {
        assertEquals("string1, string2 and string3",ToString.toString(new String[]{"string1","string2","string3"}));
    }

}

