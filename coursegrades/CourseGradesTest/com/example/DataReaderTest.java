package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataReaderTest {
    private DataReader dataReader;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
    }

    @Test
    public void getJsonFilesAsList() throws Exception {
        assertEquals("Fall2013.json",DataReader.getJsonFilesAsList().get(0));
    }

    @Test
    public void getJsonFilesAsArraylist() throws Exception {
        assertEquals("Fall2013.json",DataReader.getJsonFilesAsArraylist().get(0));
    }

    @Test
    public void getFileContentsAsString() throws Exception {
        String fileName = DataReader.JSON_FILES[0];
        assertEquals(-1,DataReader.getFileContentsAsString(fileName).indexOf(000));
    }

    @Test
    public void storeFileCotents() throws Exception {
        assertEquals(41758,DataReader.storeFileCotents().get(0).getCRN());
        assertEquals(51248,DataReader.storeFileCotents().get(3).getCRN());
        assertEquals(51932,DataReader.storeFileCotents().get(5).getCRN());
        assertEquals(57598,DataReader.storeFileCotents().get(9).getCRN());

    }

}