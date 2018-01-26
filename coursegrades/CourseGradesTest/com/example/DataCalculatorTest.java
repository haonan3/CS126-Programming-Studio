package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataCalculatorTest {

    private DataCalculator calculator = new DataCalculator();
    @Test
    public void totalStuNum() throws Exception {
        assertEquals(2027,DataCalculator.totalStuNum(DataFilter.oneCourse(225,"CS")));
    }

    @Test
    public void gradedStuNum() throws Exception {
        assertEquals(575,calculator.gradedStuNum(DataFilter.oneCourse(225,"CS"),"A"));
    }

    @Test
    public void getWeightedGPA() throws Exception {
       assertEquals(2.93,calculator.getWeightedGPA(DataFilter.oneCourse(225,"CS")),0.1);
    }
    @Test
    public void getAsRate() throws Exception {
        assertEquals(27.33,calculator.getAsRate(DataFilter.oneCourse(225,"CS")),0.01);
    }


}