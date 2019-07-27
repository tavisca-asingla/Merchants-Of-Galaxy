package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {
    Merchant merchant;
    TypeOneParser typeOneParser ;
    TypeTwoParser typeTwoParser;
    QuestionParser questionParser;
    WordToRomanValueMapper wordToRomanValueMapper;
    WordToDecimalValueMapper wordToDecimalValueMapper;
    RomanToNumeral romanToNumeral;
    ResultsCalculator resultsCalculator;

    @BeforeEach
    public void setUp(){
        merchant  = new Merchant();
        typeOneParser = new TypeOneParser();
        typeTwoParser = new TypeTwoParser();
        questionParser = new QuestionParser();
        wordToDecimalValueMapper = WordToDecimalValueMapper.getInstance();
        wordToRomanValueMapper = WordToRomanValueMapper.getInstance();
        romanToNumeral = new RomanToNumeral();
        resultsCalculator = new ResultsCalculator();
    }

    @Test
    public void canSolveAnExample(){
        String[] typeOneentences = new String[] {
                "glob is I",
                "prok is V",
                "pish is X",
                "tegj is L"};
        String[] typeTwoSentences = new String[] {
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits"
        };
        String[] questions = new String[] {
                "how much is pish tegj glob glob ?",
                "how many Credits is glob prok Silver ?",
                "how many Credits is glob prok Gold ?",
                "how many Credits is glob prok Iron ?",
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
        };
        String[] expectedAnswers = new String[] {
                "pish tegj glob glob is 42",
                "glob prok Silver is 68 Credits",
                "glob prok Gold is 57800 Credits",
                "glob prok Iron is 782 Credits",
                "I have no idea what you are talking about"
        };
        String[] computedAnswers = merchant.solveManyQuestions(typeOneentences,typeTwoSentences,questions);
        assertArrayEquals(expectedAnswers,computedAnswers);

    }
}