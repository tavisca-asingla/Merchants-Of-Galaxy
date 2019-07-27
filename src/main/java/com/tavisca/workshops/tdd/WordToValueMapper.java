package com.tavisca.workshops.tdd;

import java.util.HashMap;
import  java.util.regex.*;
public class WordToValueMapper {
    private HashMap<String,String> romanToValueMap = new HashMap<>();
    private HashMap<String,String> iGUnitToValueMap = new HashMap<>();
    public static WordToValueMapper wordToValueMapper = new WordToValueMapper();
    private WordToValueMapper(){}
    public static WordToValueMapper getInstance(){
        return wordToValueMapper;
    }

    public void map(String key, String value) {
        if(value.matches("^[A-Z]*$"))
            romanToValueMap.put(key,(value));
        else if(value.matches("\\d+(\\.\\d+)?"))
            iGUnitToValueMap.put(key,value);
        else
            throw new IllegalArgumentException("This Value is not accepted");

    }

    public void mapMany(String[][] keyAndValues) {
        for (String[] keyAndValue:
             keyAndValues) {
            map(keyAndValue[0],keyAndValue[1]);
        }
    }

    public String get(String key) {
        if(romanToValueMap.containsKey(key))
            return  romanToValueMap.get(key);
        else if(iGUnitToValueMap.containsKey(key))
            return iGUnitToValueMap.get(key);
        else
            throw new IllegalArgumentException("No Such Key Found");
    }
}
