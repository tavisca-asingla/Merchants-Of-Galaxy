package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultsCalculatorTest {

    ResultsCalculator resultsCalculator;
    QuestionParser questionParser;
    @BeforeEach
    void setUp() {
        questionParser  = new QuestionParser();
        resultsCalculator = new ResultsCalculator();
    }

//    @Test
//    void canSolveMuchQuestion(){
//        // how much is pish tegj glob glob ?=
//
////        String[][] toCalculate = questionParser.parse("how much is pish tegj glob glob ?");
//        int credits = resultsCalculator.add(new float[]{1.0f,5.0f,17.0f});
//        assertEquals(23,credits);
//    }
//
//    @Test
//    public void canSolveManyQuestion(){
//        int credits = resultsCalculator.multiply(new float[]{1.0f,5.0f,17.0f});
//        assertEquals(85,credits);
//    }

}