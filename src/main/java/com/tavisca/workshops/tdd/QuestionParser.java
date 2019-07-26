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
}
