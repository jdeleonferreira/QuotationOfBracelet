package com.example.quotationofbracelet;

import org.junit.Test;
import junit.framework.TestCase;

public class MainActivityTest extends TestCase {
    private int material = 0, pendant = 0, metalType = 0;
    @Test
    public void testCalculate() {
        assertTrue("100",(material == 0 && pendant == 0 && (metalType == 0 || metalType == 1)));
    }

}