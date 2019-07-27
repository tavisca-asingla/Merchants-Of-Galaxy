package com.tavisca.workshops.tdd;

public class Merchant {
    TypeOneParser typeOneParser ;
    TypeTwoParser typeTwoParser ;
    QuestionParser questionParser ;
    ParsedQuestionSolver parsedQuestionSolver;
    InterGalacticUnitsComputer interGalacticUnitsComputer;
    WordToRomanValueMapper wordToRomanValueMapper ;
    WordToDecimalValueMapper wordToDecimalValueMapper ;
    RomanToNumeral romanToNumeral;
    ResultsCalculator resultsCalculator;

    public String[] solveManyQuestions(String[] typeOneSentences, String[] typeTwoSentences, String[] questions) {
        typeOneParser = new TypeOneParser();
        typeTwoParser = new TypeTwoParser();
        questionParser = new QuestionParser();
        interGalacticUnitsComputer = new InterGalacticUnitsComputer();
        wordToDecimalValueMapper = WordToDecimalValueMapper.getInstance();
        wordToRomanValueMapper = WordToRomanValueMapper.getInstance();
        parsedQuestionSolver = new ParsedQuestionSolver();
        //code for parsers
        String[][] typeOneParsed = typeOneParser.parseMany(typeOneSentences);
        String[][][] typeTwoParsed = typeTwoParser.parseMany(typeTwoSentences);
        String[][][] questionsParsed = questionParser.parseMany(questions);

        //computation begins here

        String[] resultsArray = new String[questions.length];
        wordToRomanValueMapper.mapMany(typeOneParsed);
        String[][] interGalacticUnitsSolved = interGalacticUnitsComputer.computeMany(typeTwoParsed);
        wordToDecimalValueMapper.mapMany(interGalacticUnitsSolved);

        resultsArray = parsedQuestionSolver.solveMany(questionsParsed);
        return resultsArray;

    }


}
