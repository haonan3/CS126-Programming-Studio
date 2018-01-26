package com.example;

public class SmartPlayer implements PlayerStrategy {
    //This SmartPlayer is very conservative, he will only bet or call when get A
    private String playerName = "SmartPlayer";

    @Override
    public boolean betAsPlayer1(Card card) {
        int cardValue = card.getValue();
        if(cardValue == 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean callAsPlayer2(Card card) {
        int cardValue = card.getValue();
        if(cardValue == 2) {
            return true;
        }
        return false;
    }

    @Override
    public void feedbackAsPlayer1(Card card1, Card card2, boolean bet, boolean call) {

    }

    @Override
    public void feedbackAsPlayer2(Card card1, Card card2, boolean bet, boolean call) {

    }

    @Override
    public void reset() {

    }

    @Override
    public String getName() {
        return playerName;
    }
}
