package com.tavisca.workshops.tdd;


public class TypeOneParser {

    public String[] parse(String statement){
        String[] arr = statement.split(" ");
        return new String[]{arr[0],arr[2]};
    }

    public String[][] parseMany(String[] statements){
        String[][] parsedResults = new String[statements.length][2];
        for(int index = 0 ; index<statements.length;index++){
            parsedResults[index] = parse(statements[index]);
        }
        return parsedResults;
    }




}
