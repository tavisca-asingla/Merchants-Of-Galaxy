package com.tavisca.workshops.tdd;

public class ResultsCalculator {




    int multiply(float[] operands) {
        float result = 0.0f;
        for (var operand:
                operands) {
            result *= operand;
        }
        return (int)result;
    }


}
