package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParsedQuestionSolverTest {
    ParsedQuestionSolver parsedQuestionSolver;

    @BeforeEach
    public void init(){
        parsedQuestionSolver = new ParsedQuestionSolver();
    }

    @Test
    public void solveMuchArray(){
        String[][] parsedQuestion = new String[][]{{"much"},{"pish","tegj","glob","glob"}};
        WordToRomanValueMapper.getInstance().mapMany(new String[][]{{"pish","X"},{"glob","I"},{"tegj","L"},{"prok","V"}});
        String computedResult = parsedQuestionSolver.solve(parsedQuestion);
        String expectedResult = "pish tegj glob glob is 42";
        assertEquals(expectedResult,computedResult);

        expectedResult = "I have no idea what you are talking about";
        computedResult = parsedQuestionSolver.solve(new String[][]{{"much"},{"wood", "could", "a",
                "woodchuck", "chuck", "if", "a","woodchuck","could","chuck", "wood" }});
        assertEquals(expectedResult,computedResult);
    }


}