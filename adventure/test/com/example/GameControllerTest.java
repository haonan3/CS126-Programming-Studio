package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {
    public GameController gameController;
    @Before
    public void setup() {
        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        gameController = new GameController(url);
    }
    @Test
    public void haveDirections() throws Exception {
        String direction = gameController.HaveDirections("MatthewsStreet");
        String expectedrection = "From here you can go: East";
        assertEquals(expectedrection,direction);
    }

    @Test
    public void goOtherRoomFromStartingRoom() throws Exception {
        String expectedRoomName = "MatthewsStreet";
        String roomName = gameController.GoOtherRoom("MatthewsStreet","X",gameController);
    }
}