package com.tavisca.workshops.tdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterGalacticUnitsComputerTest {
    private InterGalacticUnitsComputer iGUC ;
    private WordToValueMapper wordToValueMapper;
    private TypeOneParser typeOneParser;
    private RomanToNumeral romanToNumeral;
    private TypeTwoParser typeTwoParser;

    @BeforeEach
    public void init(){
        iGUC = new InterGalacticUnitsComputer();
        romanToNumeral = new RomanToNumeral();
        typeOneParser = new TypeOneParser();
        typeTwoParser = new TypeTwoParser();
        wordToValueMapper = WordToValueMapper.getInstance();

    }

    @Test
    public void computeInterGalacticUnitsTest(){
        String[] Sentences = new String[] {"glob is I",
                "prok is V",
                "pish is X",
                "tegj is L"};
        String[][] words;
        for(String line : Sentences){
            String[] wordAndValues  = typeOneParser.parse(line);
            wordToValueMapper.map(wordAndValues[0],wordAndValues[1]);
        }
        String[] sentences2 = new String[] {
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits"
        };
        String[][] wordAndValue = new String[sentences2.length][2];
        for (int index = 0; index<sentences2.length;index++ ) {
            String[][] gotFromSentence =  typeTwoParser.parse(sentences2[index]);
            wordAndValue[index] = iGUC.compute(gotFromSentence);

        }
        assertEquals("17.0",wordAndValue[0][1]);
        assertEquals("14450.0",wordAndValue[1][1]);
        assertEquals("195.5",wordAndValue[2][1]);

    }
}
