package com.tavisca.workshops.tdd;

public class ParsedQuestionSolver {
//    ResultsCalculator resultsCalculator;
    private RomanToNumeral romanToNumeral;
//    WordToRomanValueMapper wordToRomanValueMapper;
    private WordToValueMapper wordToValueMapper;
    public String solve(String[][] parsedQuestion) {
//            wordToRomanValueMapper = WordToRomanValueMapper.getInstance();
            wordToValueMapper = WordToValueMapper.getInstance();
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
    private int multiply(float[] operands) {
        float result = 1.0f;
        for (float operand:
                operands) {
            result *= operand;
        }
        return (int)result;
    }

    private String solveQuestionContainingMuch(String[] toComputeRoman){
        String result = "";
        String finalRoman = "";
        for (int index = 0; index < toComputeRoman.length; index++) {
            finalRoman += ((wordToValueMapper.get(toComputeRoman[index])));
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
            toCompute += (wordToValueMapper.get(toMultiply[index]));
            result += toMultiply[index] + " ";
        }
        floats[0] = romanToNumeral.convert(toCompute);
        floats[1] = Float.parseFloat(wordToValueMapper.get(toMultiply[toMultiply.length-1]));
        result += toMultiply[toMultiply.length-1] + " is ";
        result += multiply(floats)+ " Credits";
        return result;
    }

//    private String getValue(String key){
//        if(wordToRomanValueMapper.get(key)!=null)
//            return wordToRomanValueMapper.get(key);
//        else if(wordToValueMapper.get(key)!=null)
//            return wordToValueMapper.get(key);
//        else
//            throw new IllegalArgumentException("Invalid Argument");
//
//    }
}
