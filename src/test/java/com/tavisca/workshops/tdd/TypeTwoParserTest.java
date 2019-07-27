package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTwoParserTest {

    @Test
    public void canConvertFromSentenceToStringsJaggedArray(){
        TypeTwoParser s = new TypeTwoParser();
        String arr[][] = s.parse("glob glob Silver is 34 credits");
        String given[] = arr[0];
        String find = arr[1][0];
        int credits = Integer.parseInt(arr[2][0]);
        assertArrayEquals(new String[]{"glob","glob"},given);
        assertEquals("Silver",find);
        assertEquals(34, credits);
    }

}