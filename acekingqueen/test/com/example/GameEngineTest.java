package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest {
    GameEngine gameEngine;

    @Before
    public void setup() throws Exception {
        SmartPlayer smartPlayer = new SmartPlayer();
        RandomnessPlayer randomnessPlayer = new RandomnessPlayer();
        gameEngine = new GameEngine(smartPlayer,randomnessPlayer);
    }

    @Test
    public void begainGame() throws Exception {
        gameEngine.begainGame();
        double cardOneValue = gameEngine.getCard1();
        double cardTwoValue = gameEngine.getCard2();
        assertNotEquals(cardOneValue,cardTwoValue);
    }
}