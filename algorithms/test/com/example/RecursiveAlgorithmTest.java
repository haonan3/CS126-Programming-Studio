package com.example;

import static org.junit.Assert.*;

public class RecursiveAlgorithmTest {
    int[] denominations = {45, 26, 19, 9, 1};
    RecursiveAlgorithm recursiveAlgorithm = new RecursiveAlgorithm();
    int amount1 = 0;
    int amount2 = 10;
    int amount3 = 27;
    int amount4 = 38;
    int amount5 = 101;
    int amount6 = 110;

    /**
     * If the input is 0, there will be no change
     *
     * @throws Exception
     */
    @org.junit.Test
    public void makeChangeTest1() throws Exception {
        int[] coinNum = {0, 0, 0, 0, 0};
        assertArrayEquals(coinNum, recursiveAlgorithm.makeChange(denominations, amount1));
    }


    @org.junit.Test
    public void makeChangeTest2() throws Exception {
        int[] coinNum = {0, 0, 0, 1, 1};
        assertArrayEquals(coinNum, recursiveAlgorithm.makeChange(denominations, amount2));
    }


    @org.junit.Test
    public void makeChangeTest3() throws Exception {
        int[] coinNum = {0, 1, 0, 0, 1};
        assertArrayEquals(coinNum, recursiveAlgorithm.makeChange(denominations, amount3));
    }


    @org.junit.Test
    public void makeChangeTest4() throws Exception {
        int[] coinNum = {0, 0, 2, 0, 0};
        assertArrayEquals(coinNum, recursiveAlgorithm.makeChange(denominations, amount4));
    }


    /**
     * By increase the amount, the execute time will increase rapidly
     *
     * @throws Exception
     */
    @org.junit.Test
    public void makeChangeTest5() throws Exception {
        int[] coinNum = {2, 0, 0, 1, 2};
        assertArrayEquals(coinNum, recursiveAlgorithm.makeChange(denominations, amount5));
    }

    /**
     * when the amount is more than 110, it will spend a lot od time to execute
     *
     * @throws Exception
     */
    @org.junit.Test
    public void makeChangeTest6() throws Exception {
        int[] coinNum = {2, 0, 0, 2, 2};
        assertArrayEquals(coinNum, recursiveAlgorithm.makeChange(denominations, amount6));
    }


    //Test the get sum helper method
    @org.junit.Test
    public void numOfCoins() throws Exception {
        int[] testArray = {1, 34, 5, 67, 7, 34, 5, 1, 5};
        int sum = 0;
        for (int i : testArray) {
            sum += i;
        }
        int coinNum = recursiveAlgorithm.numOfCoins(testArray);
        assertEquals(sum, coinNum);
    }
}