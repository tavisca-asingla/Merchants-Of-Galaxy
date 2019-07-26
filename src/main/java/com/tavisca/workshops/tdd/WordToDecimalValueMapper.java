package com.tavisca.workshops.tdd;

import java.util.HashMap;

public class WordToDecimalValueMapper {
    static private HashMap<String,String> hmap = new HashMap<>();


    public void map(String key, String value) {
        hmap.put(key,(value));
    }

    public String get(String key) {
        return  hmap.get(key);
    }
}
