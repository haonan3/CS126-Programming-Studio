package com.example;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;


public class OneSideQuicksortTest {


    OneSideQuicksort oneSideQuicksort = new OneSideQuicksort();
    double[] testArray = {1.2, 345.1, 222, 2.1, 34.1, 0.11, 0.0022};
    int arrayLength = 100;
    double[] randomArray = new double[arrayLength];
    double[] emptyArray = {};
    double[] nullArray = null;

    /*
    * This method is used to generate random array.
    * It is useful to check the oneSideQuicksort automatically,
    * instead of check oneSideQuicksort munally.
    * */
    public void randomArrayGenerator() {
        Random random = new Random();
        for (int i = 0; i < arrayLength - 1; i++) {
            randomArray[i] = random.nextDouble();
        }
    }


    /*
    * This test case will sort the testArray created by ourselves
    * The small and manually created array is useful to debug
    * */
    @Test
    public void findNthOfTestArray() throws Exception {
        double[] hnth = {1, 3, 5};
        double secondSmall = oneSideQuicksort.findNth(testArray, 0, 6, 5);
        Arrays.sort(testArray);
        assertEquals(testArray[5], secondSmall, 0.0);
    }


    @Test
    public void findNthOfRandomArray() throws Exception {
        randomArrayGenerator();
        double expectedNthNum = oneSideQuicksort.findNth(randomArray, 0, 99, 13);
        Arrays.sort(randomArray);
        assertEquals(randomArray[13], expectedNthNum, 0.0);
    }


    @Test
    public void findNthOfRandomArray2() throws Exception {
        randomArrayGenerator();
        Arrays.sort(randomArray);
        double expectedNthNum = oneSideQuicksort.findNth(randomArray, 0, 99, 96);
        assertEquals(randomArray[96], expectedNthNum, 0.0);
    }


    @Test
    public void findNthOfEmptyArray() throws Exception {
        oneSideQuicksort.findNth(emptyArray, 0, 0, 4);
    }


    @Test
    public void findNthOfNullArray() throws Exception {
        oneSideQuicksort.findNth(nullArray, 0, 3, 4);
    }


    /*
    * swapTest is used to check whether one array can be swap correctly
    * */
    @Test
    public void swapTest() throws Exception {
        oneSideQuicksort.swap(testArray, 2, 3);
        double[] swapedArray = {1.2, 345.1, 2.1, 222, 34.1, 0.11, 0.0022};
        assertArrayEquals(swapedArray, testArray, 0.0);
    }

}