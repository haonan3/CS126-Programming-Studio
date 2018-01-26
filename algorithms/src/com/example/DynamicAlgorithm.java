package com.example;

import java.util.Map;

public class DynamicAlgorithm {
    private int denomLength;

    int[] makeChange(int[] denominations, int amount, Map<Integer, int[]> coinTable) {

        if (amount == 0) {
            int[] emptyArray = new int[denomLength];
            return emptyArray;
        }

        denomLength = denominations.length;
        for (int i = 0; i < denomLength; i++) {
            if (denominations[i] == amount) {
                int[] new_array = new int[denomLength];
                new_array[i] = 1;
                return new_array;
            }
        }

        if (coinTable.containsKey(amount)) {
            return coinTable.get(amount).clone();   //copy?
        }


        int[] bestValue = null;
        int[] subProblemSolution = new int[denomLength];
//        Map<Integer, int[]> lookupTable = new HashMap<Integer, int[]>();
        for (int i = 0; i < denomLength; i++) {
            if (denominations[i] < amount) {
                subProblemSolution = makeChange(denominations, amount - denominations[i], coinTable);
                subProblemSolution[i] = subProblemSolution[i] + 1;

                if (bestValue == null || numOfCoins(bestValue) > numOfCoins(subProblemSolution)) {
                    bestValue = subProblemSolution;
                }
            }
        }
        coinTable.put(amount, bestValue.clone());
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


