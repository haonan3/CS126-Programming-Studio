package com.example;

public class LearnStrategy implements PlayerStrategy{
    //RandomnessPlayer uses threshold to change the probability of bet or call
    private String playerName = "LearnPlayer";
    private double betThreshold = 0.5;
    private double callThreshold = 0.5;
    private int playerOneNet = 0;
    private int playerTwoNet = 0;

    @Override
    public boolean betAsPlayer1(Card card) {
        int cardValue = card.getValue();
        learnBehavior(cardValue, betThreshold);
        return false;
    }

    @Override
    public boolean callAsPlayer2(Card card) {
        int cardValue = card.getValue();
        learnBehavior(cardValue, callThreshold);
        return false;
    }

    public boolean learnBehavior(int cardValue, double threshold) {
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
        int benefit = 1;
        int damage = -1;
        double learnRate = 0.01;
        if(card1.toString().equals("King") && card2.toString().equals("Ace")) {
            if(bet){
                playerOneNet += damage;
            }else {
                playerOneNet +=benefit;
            }
        }

        if(playerOneNet > 0) {
            betThreshold += learnRate;
        }else {
            betThreshold -= learnRate;
        }
    }

    @Override
    public void feedbackAsPlayer2(Card card1, Card card2, boolean bet, boolean call) {
        //As player2, if the net of call at "K" is negative, then turn down call threshold. Otherwise, turn up.
        int benefit = 1;
        int damage = -1;
        double learnRate = 0.01;
        if(card2.toString().equals("King") && card1.toString().equals("Ace") && bet) {
            if(call) {
                playerTwoNet += damage;  //more loss if call
            }else {
                playerTwoNet +=  benefit;  //less loss if don't call
            }
        }

        if(playerTwoNet > 0) {
            callThreshold += learnRate;
        }else {
            callThreshold -= learnRate;
        }
    }

    @Override
    public void reset() {
        playerTwoNet = 0;
        playerOneNet = 0;
        callThreshold = 0.5;
        betThreshold = 0.5;
    }

    @Override
    public String getName() {
        return playerName;
    }
}
