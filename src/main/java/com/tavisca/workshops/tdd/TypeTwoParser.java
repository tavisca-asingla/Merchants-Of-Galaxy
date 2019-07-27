package com.tavisca.workshops.tdd;
import java.util.Arrays;
public class TypeTwoParser {

    public String[][] parse(String s) {
        String allInfo[] = s.split(" is ");
        String givenAndFind[] = allInfo[0].split(" ");
        String given[] = Arrays.copyOf(givenAndFind,givenAndFind.length-1);
        String find[] = new String[]{givenAndFind[givenAndFind.length-1]};
        String credits[] = new String[] {allInfo[1].split(" ")[0]};
        String toReturn[][] = new String[][]{given,find,credits};
        return toReturn;
    }
    public String[][][] parseMany(String[] statements){
        String[][][] parsedResults = new String[statements.length][][];
        for(int index = 0 ; index<statements.length;index++){
            parsedResults[index] = parse(statements[index]);
        }
        return parsedResults;
    }
}
