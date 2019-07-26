package com.tavisca.workshops.tdd;
import java.util.Arrays;
public class SentenceToArrayParser {

    public String[][] parse(String s) {
        String allInfo[] = s.split(" is ");
        String givenAndFind[] = allInfo[0].split(" ");
        String given[] = Arrays.copyOf(givenAndFind,givenAndFind.length-1);
        String find[] = new String[]{givenAndFind[givenAndFind.length-1]};
        String credits[] = new String[] {allInfo[1].split(" ")[0]};
        String toReturn[][] = new String[][]{given,find,credits};
        return toReturn;
    }
}
