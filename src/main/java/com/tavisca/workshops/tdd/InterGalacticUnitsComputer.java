package com.tavisca.workshops.tdd;
import java.util.Arrays;
public class InterGalacticUnitsComputer {
    public String[] compute(String[][] gotFromSentence) {
        RomanToNumeral romanToNumeral = new RomanToNumeral();
        WordToRomanValueMapper wordToValueMapper = new WordToRomanValueMapper();
        String roman = "";
        for (var word: gotFromSentence[0]) {
            roman += wordToValueMapper.get(word);
        }
        int A = romanToNumeral.convert(roman);
        int C = Integer.parseInt(gotFromSentence[2][0]);
        String toFind = gotFromSentence[1][0];
        Float value = (float)C/A;
        return new String[]{toFind,value.toString()};

    }
}
