package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class GenericQuickSortTest {
    Random random = new Random();
    int arrayLength = 20;
    Integer[] randomIntegerArray;
    Double[] randomDoubleArray;
    Long[] randomLongArray;
    Integer[] integerArray = {new Integer(126), new Integer(225), new Integer(357),
            new Integer(410), new Integer(498), new Integer(450),
            new Integer(421), new Integer(241), new Integer(115)};

    Double[] doubleArray = {new Double(1.019), new Double(2.445), new Double(10.10),
            new Double(10000), new Double(1.190), new Double(1.190),
            new Double(9.101), new Double(20.44), new Double(9.321),
            new Double(1.190), new Double(190.9), new Double(1.190)};

    Long[] longArray = {new Long(1232), new Long(4), new Long(333),
            new Long(32), new Long(12), new Long(12),
            new Long(22), new Long(7650), new Long(01)};

    String[] stringArray = {"ss", "122f", "a2f3g41", "3ff8", "2.0a", "#asf"};

    Integer[] emptyArray;

    Double[] nullArray = null;

    public void randomIntegerGenerator() {
        randomIntegerArray = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomIntegerArray[i] = new Integer(random.nextInt());
        }
    }


    public void randomDoubleGenrator() {
        randomDoubleArray = new Double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomDoubleArray[i] = random.nextDouble();
        }
    }

    public void randomLongGenrator() {
        randomLongArray = new Long[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomLongArray[i] = random.nextLong();
        }
    }


    /**
     * there is findNthSmallest of String array
     *
     * @throws Exception
     */
    @Test
    public void findNthString() throws Exception {
        GenericQuickSort<String> genericQuickSort = new GenericQuickSort<String>();
        String nthSmallString = genericQuickSort.findNth(stringArray, 0, 5, 4);
        Arrays.sort(stringArray);
        assertEquals(stringArray[4], nthSmallString);


    }

    /**
     * there is findNthSmallest of manually created Integer Array
     *
     * @throws Exception
     */
    @Test
    public void findNthInteger() throws Exception {
        GenericQuickSort<Integer> genericQuickSort = new GenericQuickSort<Integer>();
        //we expect to get 450
        Integer nthSmallInteger = genericQuickSort.findNth(integerArray, 0, 8, 7);
        Arrays.sort(integerArray);
        assertEquals(integerArray[7], nthSmallInteger);
    }


    /**
     * there is findNthSmallest of manually created Double Array
     *
     * @throws Exception
     */
    @Test
    public void findNthDouble() throws Exception {
        GenericQuickSort<Double> genericQuickSort = new GenericQuickSort<Double>();
        //we expect to get 1.19
        Double nthSmallDouble = genericQuickSort.findNth(doubleArray, 0, 11, 2);
        Arrays.sort(doubleArray);
        assertEquals(doubleArray[2], nthSmallDouble);
    }

    /**
     * there is findNthSmallest of manually created Long Array
     *
     * @throws Exception
     */
    @Test
    public void findNthLong() throws Exception {
        GenericQuickSort<Long> genericQuickSort = new GenericQuickSort<Long>();
        //we expect to get 1232
        Long nthSmallLong = genericQuickSort.findNth(longArray, 0, 8, 7);
        Arrays.sort(longArray);
        assertEquals(longArray[7], nthSmallLong);
    }


    /**
     * there is findNthSmallest of random Integer Array
     *
     * @throws Exception
     */
    @Test
    public void findNthOfRandomInteger() throws Exception {
        randomIntegerGenerator();
        GenericQuickSort<Integer> genericQuickSort = new GenericQuickSort<Integer>();
        Integer nthSmallInteger = genericQuickSort.findNth(randomIntegerArray, 0, 19, 18);
        Arrays.sort(randomIntegerArray);
        assertEquals(randomIntegerArray[18], nthSmallInteger);
    }

    /**
     * there is findNthSmallest of random Double Array
     *
     * @throws Exception
     */
    @Test
    public void findNthOfRandomDouble() throws Exception {
        randomDoubleGenrator();
        GenericQuickSort<Double> genericQuickSort = new GenericQuickSort<Double>();
        Double nthSmallDouble = genericQuickSort.findNth(randomDoubleArray, 0, 19, 2);
        Arrays.sort(randomDoubleArray);
        assertEquals(randomDoubleArray[2], nthSmallDouble);
    }


    /**
     * there is findNthSmallest of random Long Array
     *
     * @throws Exception
     */
    @Test
    public void findNthOfRandomLong() throws Exception {
        randomLongGenrator();
        GenericQuickSort<Long> genericQuickSort = new GenericQuickSort<Long>();
        Long nthSmallLong = genericQuickSort.findNth(randomLongArray, 0, 19, 2);
        Arrays.sort(randomLongArray);
        assertEquals(randomLongArray[2], nthSmallLong);
    }

    @Test
    public void swap() throws Exception {
        GenericQuickSort<Long> genericQuickSort = new GenericQuickSort<Long>();
        genericQuickSort.swap(longArray, 2, 3);
        Long[] expectedLongArray = {new Long(1232), new Long(4), new Long(32),
                new Long(333), new Long(12), new Long(12),
                new Long(22), new Long(7650), new Long(01)};
        assertArrayEquals(expectedLongArray, longArray);
    }


    /**
     * Test invalid input. If input is an empty array, java vm will exit
     */
    @Test
    public void emptyArrayTest() {
        GenericQuickSort<Integer> genericQuickSort = new GenericQuickSort<Integer>();
        genericQuickSort.findNth(emptyArray, 0, 10, 4);
    }

    /**
     * Test invalid input. If input is an null array, java vm will exit
     */
    @Test
    public void nullArrayTest() {
        GenericQuickSort<Double> genericQuickSort = new GenericQuickSort<Double>();
        genericQuickSort.findNth(nullArray, 0, 10, 3);

    }
}