package com.tavisca.workshops.tdd;

public class Merchant {
    private TypeOneParser typeOneParser ;
    private TypeTwoParser typeTwoParser ;
    private QuestionParser questionParser ;
    private ParsedQuestionSolver parsedQuestionSolver;
    private InterGalacticUnitsComputer interGalacticUnitsComputer;
//    WordToRomanValueMapper wordToRomanValueMapper ;
    private WordToValueMapper wordToValueMapper;
    private RomanToNumeral romanToNumeral;


    public String[] solveManyQuestions(String[] typeOneSentences, String[] typeTwoSentences, String[] questions) {
        typeOneParser = new TypeOneParser();
        typeTwoParser = new TypeTwoParser();
        questionParser = new QuestionParser();
        interGalacticUnitsComputer = new InterGalacticUnitsComputer();
        wordToValueMapper = WordToValueMapper.getInstance();
        parsedQuestionSolver = new ParsedQuestionSolver();
        //code for parsers
        String[][] typeOneParsed = typeOneParser.parseMany(typeOneSentences);
        String[][][] typeTwoParsed = typeTwoParser.parseMany(typeTwoSentences);
        String[][][] questionsParsed = questionParser.parseMany(questions);

        //computation begins here

        String[] resultsArray = new String[questions.length];
        wordToValueMapper.mapMany(typeOneParsed);
        String[][] interGalacticUnitsSolved = interGalacticUnitsComputer.computeMany(typeTwoParsed);
        wordToValueMapper.mapMany(interGalacticUnitsSolved);

        resultsArray = parsedQuestionSolver.solveMany(questionsParsed);
        return resultsArray;

    }


}
