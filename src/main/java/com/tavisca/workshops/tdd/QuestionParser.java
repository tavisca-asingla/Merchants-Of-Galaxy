package com.tavisca.workshops.tdd;
import java.util.Arrays;
public class QuestionParser {

    public String[][] parse(String question) {
        String words[] = question.split(" ");
        String quest = words[1];
        int startingIndex = 3;
        if(quest.equals("many")){
            startingIndex = 4;
        }
        String wordsToCompute[] = Arrays.copyOfRange(words,startingIndex,words.length-1);
        return new String[][]{{quest},wordsToCompute};
    }
    public String[][][] parseMany(String[] statements){
        String[][][] parsedResults = new String[statements.length][][];
        for(int index = 0 ; index<statements.length;index++){
            parsedResults[index] = parse(statements[index]);
        }
        return parsedResults;
    }
}
