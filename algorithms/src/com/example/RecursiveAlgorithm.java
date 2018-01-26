package com.example;

public class RecursiveAlgorithm {
    int denomLength;

    int[] makeChange(int[] denominations, int amount) {
        denomLength = denominations.length;
        if (amount == 0) {
            int[] emptyArray = new int[denomLength];
            return emptyArray;
        }

        for (int i = 0; i < denomLength; i++) {
            if (denominations[i] == amount) {
                int[] newArray = new int[denomLength];
                newArray[i] = 1;
                return newArray;
            }
        }

        int[] bestValue = null;
        int[] subProblemSolution = new int[denomLength];
        for (int i = 0; i < denomLength; i++) {
            if (denominations[i] < amount) {

                subProblemSolution = makeChange(denominations, amount - denominations[i]);
                subProblemSolution[i] = subProblemSolution[i] + 1;

                if (bestValue == null || (numOfCoins(bestValue) > numOfCoins(subProblemSolution))) {
                    bestValue = subProblemSolution;
                }
            }
        }
        return bestValue;
    }

    int numOfCoins(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }
}


