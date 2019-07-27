package com.tavisca.workshops.tdd;

import java.util.HashMap;

public class WordToRomanValueMapper {
    private HashMap<String,String> hmap = new HashMap<>();
    static private WordToRomanValueMapper wordToRomanValueMapper= new WordToRomanValueMapper();

    private WordToRomanValueMapper(){}

    public static WordToRomanValueMapper getInstance(){
        return wordToRomanValueMapper;
    }

    public void map(String key, String value) {
        hmap.put(key,(value));
    }

    public String get(String key) {
        return  hmap.get(key);

    }

    public void mapMany(String[][] typeOneParsed) {
        for (String[] keyAndValue:
             typeOneParsed) {
            map(keyAndValue[0],keyAndValue[1]);
        }
    }
}
