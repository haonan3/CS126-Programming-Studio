package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Bedazzlertest {

    @Test   //@test必须要！！！！
    public void bedazzle() throws Exception{
        assertEquals("*t*h*i*s*", Bedazzler.bedazzle("this"));
    }



}
