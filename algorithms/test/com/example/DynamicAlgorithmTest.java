package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DynamicAlgorithmTest {
    int[] denominations = {45, 26, 19, 9, 1};
    DynamicAlgorithm dynamicAlgorithm = new DynamicAlgorithm();
    Map<Integer, int[]> lookupTable = new HashMap<Integer, int[]>();

    //a larger input show that DynamicAlgorithm is faster than RecursiveAlgorithm
    int amount1 = 101;
    int amount2 = 110;
    int amount3 = 290;
    int amount4 = 598;
    int amount5 = 1107;


    @org.junit.Test
    public void makeChangeTest1() throws Exception {
        int[] coinNum = {2, 0, 0, 1, 2};
        assertArrayEquals(coinNum, dynamicAlgorithm.makeChange(denominations, amount1, lookupTable));
    }


    @org.junit.Test
    public void makeChangeTest2() throws Exception {
        int[] coinNum = {2, 0, 1, 0, 1};
        assertArrayEquals(coinNum, dynamicAlgorithm.makeChange(denominations, amount2, lookupTable));
    }

    @org.junit.Test
    public void makeChangeTest3() throws Exception {
        int[] coinNum = {6, 0, 1, 0, 1};
        assertArrayEquals(coinNum, dynamicAlgorithm.makeChange(denominations, amount3, lookupTable));
    }

    @org.junit.Test
    public void makeChangeTest4() throws Exception {
        int[] coinNum = {12, 0, 3, 0, 1};
        assertArrayEquals(coinNum, dynamicAlgorithm.makeChange(denominations, amount4, lookupTable));
    }

    @org.junit.Test
    public void makeChangeTest5() throws Exception {
        int[] coinNum = {24, 1, 0, 0, 1};
        assertArrayEquals(coinNum, dynamicAlgorithm.makeChange(denominations, amount5, lookupTable));
    }


    /**
     * Test the sum function
     *
     * @throws Exception
     */
    @Test
    public void numOfCoins() throws Exception {
        int[] testArray = {1, 34, 5, 67, 7, 34, 5, 1, 5, 11, 3};
        int sum = 0;
        for (int i : testArray) {
            sum += i;
        }
        int coinNum = dynamicAlgorithm.numOfCoins(testArray);
        assertEquals(sum, coinNum);
    }
}
