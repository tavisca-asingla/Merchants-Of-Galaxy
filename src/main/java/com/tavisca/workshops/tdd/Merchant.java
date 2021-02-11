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

    public static void main(String args[]){
        String[] typeOneentences = new String[] {
                "glob is I",
                "prok is V",
                "pish is X",
                "tegj is L"};
        String[] typeTwoSentences = new String[] {
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits"
        };
        String[] questions = new String[] {
                "how much is pish tegj glob glob ?",
                "how many Credits is glob prok Silver ?",
                "how many Credits is glob prok Gold ?",
                "how many Credits is glob prok Iron ?",
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
        };
//        String[] expectedAnswers = new String[] {
//                "pish tegj glob glob is 42",
//                "glob prok Silver is 68 Credits",
//                "glob prok Gold is 57800 Credits",
//                "glob prok Iron is 782 Credits",
//                "I have no idea what you are talking about"
//        };
        Merchant merchant = new Merchant();
        String answers[] = merchant.solveManyQuestions(typeOneentences,typeTwoSentences,questions);
        System.out.println("Answers are: ");
        for(String ans : answers)
            System.out.println(ans);


    }


}
