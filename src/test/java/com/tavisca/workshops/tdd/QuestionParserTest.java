package com.tavisca.workshops.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionParserTest {

    @Test
    public void canParseQuestionContainingMuch(){
        QuestionParser q = new QuestionParser();
        String parsed[][] = q.parse("how much is pish tegj glob glob ?");
        String quest = parsed[0][0];
        String toCompute[] = parsed[1];

        assertArrayEquals(new String[]{"pish","tegj","glob","glob"},toCompute);
        assertEquals("much",quest);
    }

    @Test
    public void canParseQuestionContainingMany(){
        QuestionParser q = new QuestionParser();
        String parsed[][] = q.parse("how many Credits is glob prok Silver ?");
        String quest = parsed[0][0];
        String toCompute[] = parsed[1];

        assertArrayEquals(new String[]{"glob","prok","Silver"},toCompute);
        assertEquals("many",quest);
    }


}