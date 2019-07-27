package com.tavisca.workshops.tdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterGalacticUnitsComputerTest {
    InterGalacticUnitsComputer iGUC ;
    WordToRomanValueMapper w2RVM;
//    WordToDecimalValueMapper w2NVM;
    TypeOneParser w2R ;
    RomanToNumeral r2N;
    TypeTwoParser s2A;

    @BeforeEach
    public void init(){
        iGUC = new InterGalacticUnitsComputer();
        r2N = new RomanToNumeral();
        w2RVM = WordToRomanValueMapper.getInstance();
//        w2NVM = new WordToDecimalValueMapper();
        w2R = new TypeOneParser();
        s2A = new TypeTwoParser();

    }

    @Test
    public void computeInterGalacticUnitsTest(){
        String[] Sentences = new String[] {"glob is I",
                "prok is V",
                "pish is X",
                "tegj is L"};
        String words[][];
        for(var line : Sentences){
            String[] wordAndValues  = w2R.parse(line);
            w2RVM.map(wordAndValues[0],wordAndValues[1]);
        }
        String sentences2[] = new String[] {
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits"
        };
        String wordAndValue[][] = new String[sentences2.length][2];
        for (int index = 0; index<sentences2.length;index++ ) {
            String gotFromSentence[][] =  s2A.parse(sentences2[index]);
            wordAndValue[index] = iGUC.compute(gotFromSentence);

        }
        assertEquals("17.0",wordAndValue[0][1]);
        assertEquals("14450.0",wordAndValue[1][1]);
        assertEquals("195.5",wordAndValue[2][1]);

    }
}
