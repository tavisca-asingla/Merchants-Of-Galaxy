package com.tavisca.workshops.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TypeOneParserTest {

    @Test
    public void canCreateRomanNumber(){
        TypeOneParser w = new TypeOneParser();
        assertArrayEquals(new String[] {"glob","I"},w.parse("glob is I"));

        assertArrayEquals(new String[] {"prok","V"},w.parse("prok is V"));
    }



}