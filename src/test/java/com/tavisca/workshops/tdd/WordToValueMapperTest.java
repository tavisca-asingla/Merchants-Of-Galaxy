package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordToValueMapperTest {
    private WordToValueMapper wordToValueMapper;

    @BeforeEach
    public void init(){
        wordToValueMapper = WordToValueMapper.getInstance();
    }

    @Test
    void mapTest() {
        wordToValueMapper.map("glob","I");
        wordToValueMapper.map("Silver","17.0");
    }

    @Test
    void mapManyTest() {
        String[][] toMap = new String[][]{{"glob","I"},{"prok","V"},{"Silver","17.0"},
                {"Gold","14450.0"},{"Iron","195.5"}};
        wordToValueMapper.mapMany(toMap);

    }

    @Test
    void getTest() {
        String[][] toMap = new String[][]{{"glob","I"},{"prok","V"},{"Silver","17.0"},
                {"Gold","14450.0"},{"Iron","195.5"}};
        wordToValueMapper.mapMany(toMap);
        assertEquals("I", wordToValueMapper.get("glob"));
        assertEquals("V", wordToValueMapper.get("prok"));
        assertEquals("17.0", wordToValueMapper.get("Silver"));
        assertEquals("14450.0", wordToValueMapper.get("Gold"));
        assertEquals("195.5", wordToValueMapper.get("Iron"));
    }
}