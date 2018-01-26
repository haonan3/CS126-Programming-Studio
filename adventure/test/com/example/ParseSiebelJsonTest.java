package com.example;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParseSiebelJsonTest {
    private static Layout layout;
    @Before
    public void setUp() throws Exception {
        String URL = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        ParseSiebelJson parseSiebelJsonObject = new ParseSiebelJson(URL);
        layout = parseSiebelJsonObject.parseJson();
    }

    @Test
    public void parseSiebelJson() throws Exception {
        String startingRoom = "MatthewsStreet";
        assertEquals(startingRoom,layout.getStartingRoom());
    }
    @Test
    public void startingRoomDescription() throws Exception {
        String description = "You are on Matthews, outside the Siebel Center";
        assertEquals(description,layout.getRoomsArray()[0].getDescription());
    }
    @Test
    public void directionName () throws Exception {
        String dirctionName = "West";
        assertEquals(dirctionName,layout.getRoomsArray()[1].getDirection()[0].getDirectionName());
    }
    @Test
    public void itemsReturn () throws Exception {
        String items = "coin";
        assertEquals(items, layout.getRoomsArray()[0].getItems()[0]); //if there is no items, Json will return null
    }
}