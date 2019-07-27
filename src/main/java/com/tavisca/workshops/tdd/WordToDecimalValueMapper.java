package com.tavisca.workshops.tdd;

import java.util.HashMap;

public class WordToDecimalValueMapper {
    private HashMap<String,String> hmap = new HashMap<>();
    public static WordToDecimalValueMapper wordToDecimalValueMapper = new WordToDecimalValueMapper();
    private WordToDecimalValueMapper(){}
    public static WordToDecimalValueMapper getInstance(){
        return wordToDecimalValueMapper;
    }

    public void map(String key, String value) {
        hmap.put(key,(value));
    }

    public void mapMany(String[][] keyAndValues) {
        for (String[] keyAndValue:
             keyAndValues) {
            map(keyAndValue[0],keyAndValue[1]);
        }
    }

    public String get(String key) {
            return  hmap.get(key);
    }
}
