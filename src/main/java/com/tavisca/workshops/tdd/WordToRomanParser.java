package com.tavisca.workshops.tdd;


public class WordToRomanParser {

    public String[] parse(String statement){
        String arr[] = statement.split(" ");
        return new String[]{arr[0],arr[2]};
    }




}
