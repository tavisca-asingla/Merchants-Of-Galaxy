package com.tavisca.workshops.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class InputParserTest {

    @Test
    public void canCreateRomanNumber(){
        WordToRomanParser w = new WordToRomanParser();
        assertArrayEquals(new String[] {"glob","I"},w.parse("glob is I"));

        assertArrayEquals(new String[] {"prok","V"},w.parse("prok is V"));
    }



}