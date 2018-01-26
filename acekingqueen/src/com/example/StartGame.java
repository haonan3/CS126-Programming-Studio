package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartGame {
    public static void main (String[] args) {
        int roundNum = Integer.valueOf(args[0]);
        //DumpPlayer player1 = new DumpPlayer();
        RandomnessPlayer player2 = new RandomnessPlayer(); //If Randomness first, it will win
        LearnStrategy player1 = new LearnStrategy();
        //SmartPlayer player1 = new SmartPlayer();
        GameEngine gameEngine = new GameEngine(player1, player2);
        while(roundNum > 0) {
            gameEngine.begainGame();
            gameEngine.processControl();
            gameEngine.giveFeedback();
            roundNum--;
        }
        gameEngine.showResult();
        player1.reset();
        player2.reset();
    }
}
