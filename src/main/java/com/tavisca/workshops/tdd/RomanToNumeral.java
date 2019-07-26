package com.tavisca.workshops.tdd;

public class RomanToNumeral {

    public int convert(String romalValue) {
        int numeralValue = 0;
        if(isValid(romalValue)==false){
            throw new IllegalArgumentException("Roman Number is Not Valid");
        }
        for(int index=0;index<romalValue.length();index++){
            if(index<romalValue.length()-1 && valueOfRomanLiteral(romalValue.charAt(index))< valueOfRomanLiteral(romalValue.charAt(index+1)))
                numeralValue += valueOfRomanLiteral(romalValue.charAt(index+1))- valueOfRomanLiteral(romalValue.charAt(index++));
            else
                numeralValue += valueOfRomanLiteral(romalValue.charAt(index));
        }
        return numeralValue;
    }

    private int valueOfRomanLiteral(char c){
        int value = 0;
        switch (c){
            case 'I':
                value = 1;
                break;
            case  'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }

    public boolean isValid(String roman) {
        if(roman.contains("MMMM") || roman.contains("XXXX") || roman.contains("IIII") || roman.contains("CCCC"))
            return false;
        else if(charRepeats(roman,'D') || charRepeats(roman,'L')|| charRepeats(roman,'V'))
            return false;
        else if(subtractionCheckBreaks(roman))
            return false;
        else
            return true;

    }

    private boolean subtractionCheckBreaks(String roman) {
        boolean subtractionRuleBreaks = false;
        for(int index=0;index<roman.length()-1;index++){
            char num1 = roman.charAt(index);
            char num2 = roman.charAt(index+1);

            if(valueOfRomanLiteral(num1)<valueOfRomanLiteral(num2)){
                switch (num1){
                    case 'I':
                        if(num2 != 'V' && num2 != 'X')
                            subtractionRuleBreaks = true;
                        break;
                    case 'X':
                        if(num2 != 'L' && num2 != 'C')
                            subtractionRuleBreaks = true;
                        break;
                    case 'C':
                        if(num2 != 'D' && num2 != 'M')
                            subtractionRuleBreaks = true;
                        break;
                    default:
                        // for V, L , D, and M
                        subtractionRuleBreaks = true;
                        break;
                }
            }
            else if(subtractionRuleBreaks == true)
                break;
            else
                subtractionRuleBreaks =  false;



        }
        return  subtractionRuleBreaks;
    }

    private boolean charRepeats(String roman, char charToCheckRepetition) {
        if(roman.indexOf(charToCheckRepetition)!= roman.lastIndexOf(charToCheckRepetition))
            return true;
        return false;
    }
}
