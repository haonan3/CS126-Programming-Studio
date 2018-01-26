package com.example;

import java.util.ArrayList;

public class RandomnessPlayer implements PlayerStrategy {
    //RandomnessPlayer uses threshold to change the probability of bet or call
    private String playerName = "RandomnessPlayer";
    private double betThreshold = 0.5;
    private double callThreshold = 0.5;
    private int playerOneLost = 0;
    private int playerOneWin = 0;
    private int playerTwoLost = 0;
    private int playerTwoWin = 0;
    private boolean actOrNot = false;

    @Override
    public boolean betAsPlayer1(Card card) {
        int cardValue = card.getValue();
        actOrNot = randomBehavior(cardValue, betThreshold);
        return actOrNot;
    }

    @Override
    public boolean callAsPlayer2(Card card) {
        int cardValue = card.getValue();
        actOrNot = randomBehavior(cardValue, callThreshold);
        return actOrNot;
    }

    /**
     * This method decide whether the player will bet/call with one card
     * @param cardValue this player's card value
     * @param threshold the threshold that the player will bet/call
     * @return a boolean value, true - the player will bet/call
     */
    public boolean randomBehavior(int cardValue, double threshold) {
        if (cardValue == 2) {
            return true;
        } else if (cardValue == 1) {
            double cationRate = Math.random();
            //threshold = 0.5;
            if (cationRate > threshold) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    @Override
    public void feedbackAsPlayer1(Card card1, Card card2, boolean bet, boolean call) {
        //As player1, if the net of bet at "K" is negative, then turn down bet threshold. Otherwise, turn up.
        int betLoss = -2;
        int notBetLoss = -1;
        int callWin = 2;
        int notCallWin = 1;
        double learnRate = 0.01;
        if(card1.toString().equals("King") && card2.toString().equals("Ace") && bet) {
            playerOneLost += -betLoss;
        }
        if(card1.toString().equals("King") && card2.toString().equals("Ace") && !bet) {
            playerOneLost += notBetLoss;
        }
        if(card1.toString().equals("King") && card2.toString().equals("Queen") && bet) {
            if(call) {
                playerOneWin += callWin;
            }else {
                playerOneWin += notCallWin;
            }
        }
        if(card1.toString().equals("King") && card2.toString().equals("Queen") && !bet) {
            playerOneWin += notCallWin;
        }
        //calculate the net value when recevice a King, then change the bet threshold
        if(playerOneLost + playerOneWin > 0) {
            betThreshold += learnRate;
        }else {
            betThreshold -= learnRate;
        }
    }

    @Override
    public void feedbackAsPlayer2(Card card1, Card card2, boolean bet, boolean call) {
        //As player2, if the net of call at "K" is negative, then turn down call threshold. Otherwise, turn up.
        int callLoss = -2;
        int notCallLoss = -1;
        int callWin = 2;
        int notCallWin = 1;
        double learnRate = 0.01;
        if(card2.toString().equals("King") && card1.toString().equals("Ace") && bet) {
            if(call) {
                playerTwoLost += callLoss;
            }else {
                playerTwoLost += notCallLoss;
            }
        }
        if(card2.toString().equals("King") && card1.toString().equals("Ace") && !bet) {
            playerTwoLost += notCallLoss;
        }
        if(card2.toString().equals("King") && card1.toString().equals("Queen") && bet) {
            if(call) {
                playerTwoWin += callWin;
            }else {
                playerTwoWin += notCallWin;
            }
        }
        if(card2.toString().equals("King") && card1.toString().equals("Queen") && !bet) {
            playerTwoWin += notCallWin;
        }

        if(playerTwoLost + playerTwoWin > 0) {
            callThreshold += learnRate;
        }else {
            callThreshold -= learnRate;
        }
    }

    @Override
    public void reset() {
        playerTwoWin = 0;
        playerTwoLost = 0;
        playerOneLost = 0;
        playerOneWin = 0;
        callThreshold = 0.5;
        betThreshold = 0.5;
    }

    @Override
    public String getName() {
        return playerName;
    }
}
