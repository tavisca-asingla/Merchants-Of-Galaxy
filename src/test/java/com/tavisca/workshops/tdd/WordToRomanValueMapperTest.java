package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordToRomanValueMapperTest {
    WordToRomanValueMapper w ;
    TypeOneParser w2R;
    @BeforeEach
    public void initialize(){
        w = WordToRomanValueMapper.getInstance();
        w2R = new TypeOneParser();
    }

    @Test
    public void MapStatementsTest(){
        String toMap[] = w2R.parse("glob is I");
        w.map(toMap[0],toMap[1]);
        String value = w.get("glob");
        assertEquals("I",value);

    }
}
