package com.tavisca.workshops.tdd;

public class ParsedQuestionSolver {
//    ResultsCalculator resultsCalculator;
    RomanToNumeral romanToNumeral;
    WordToRomanValueMapper wordToRomanValueMapper;
    WordToDecimalValueMapper wordToDecimalValueMapper;
    public String solve(String[][] parsedQuestion) {
            wordToRomanValueMapper = WordToRomanValueMapper.getInstance();
            wordToDecimalValueMapper = WordToDecimalValueMapper.getInstance();
            String result = "";
            try{
            romanToNumeral = new RomanToNumeral();
            if (parsedQuestion[0][0].equals("much")) {
                result = solveQuestionContainingMuch(parsedQuestion[1]);
            }
            else if(parsedQuestion[0][0].equals("many")){
                result = solveQuestionContainingMany(parsedQuestion[1]);
            }
        }
        catch (IllegalArgumentException e){
            result = "I have no idea what you are talking about";
        }

        return result;
    }


    public String[] solveMany(String[][][] parsedQuestions){
        String[] results = new String[parsedQuestions.length];
        for(int index = 0; index<parsedQuestions.length;index++){
            results[index] = solve(parsedQuestions[index]);
        }
        return results;
    }
    int multiply(float[] operands) {
        float result = 1.0f;
        for (var operand:
                operands) {
            result *= operand;
        }
        return (int)result;
    }

    private String solveQuestionContainingMuch(String[] toComputeRoman){
        String result = "";
        String finalRoman = "";
        for (int index = 0; index < toComputeRoman.length; index++) {
            finalRoman += ((getValue(toComputeRoman[index])));
            result += toComputeRoman[index] + " ";
        }
//            resultsCalculator = new ResultsCalculator();
        result += "is " + romanToNumeral.convert(finalRoman);
        return result;
    }

    private String solveQuestionContainingMany(String[] toMultiply) {
        String result = "" ;
        String toCompute = "";
        float[] floats = new float[2];
        for(int index = 0; index < toMultiply.length-1; index++){
            toCompute += (getValue(toMultiply[index]));
            result += toMultiply[index] + " ";
        }
        floats[0] = romanToNumeral.convert(toCompute);
        floats[1] = Float.parseFloat(getValue(toMultiply[toMultiply.length-1]));
        result += toMultiply[toMultiply.length-1] + " is ";
        result += multiply(floats)+ " Credits";
        return result;
    }

    private String getValue(String key){
        if(wordToRomanValueMapper.get(key)!=null)
            return wordToRomanValueMapper.get(key);
        else if(wordToDecimalValueMapper.get(key)!=null)
            return wordToDecimalValueMapper.get(key);
        else
            throw new IllegalArgumentException("Invalid Argument");

    }
}
