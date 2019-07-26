package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToNumeralTest {

    RomanToNumeral r ;
    @BeforeEach
    public  void initialize(){
        r  = new RomanToNumeral();
    }

    @Test
    public void canConvertRomanToNumeral(){

        int numeral = r.convert("II");
        assertEquals(2,numeral);
        assertEquals(2006, r.convert("MMVI"));
        assertEquals(1944, r.convert("MCMXLIV"));
    }


    @Test
    public void FourRepeatingRomanLiteralsValidationTest(){

        assertEquals(false,r.isValid("MMMM"));
        assertEquals(false,r.isValid("XXXX"));
        assertEquals(false,r.isValid("DDDD"));
        assertEquals(true,r.isValid("XXXIX"));
        assertEquals(true,r.isValid("MMMCM"));
        assertEquals(true,r.isValid("CCCXC"));
    }

    @Test void subtractionRuleTest(){

        assertEquals(false,r.isValid("MMID"));
        assertEquals(false,r.isValid("MMXM"));
        assertEquals(false,r.isValid("DDM"));
    }

    @Test
    public void invalidRomanToNumeralThrowsException(){
        assertThrows(IllegalArgumentException.class,()->{
            r.convert("MMMMM");
        });

        assertThrows(IllegalArgumentException.class,()->{
            r.convert("XXXX");
        });

        assertThrows(IllegalArgumentException.class,()->{
            r.convert("VD");
        });
        assertThrows(IllegalArgumentException.class,()->{
            r.convert("MDM");
        });
    }
}