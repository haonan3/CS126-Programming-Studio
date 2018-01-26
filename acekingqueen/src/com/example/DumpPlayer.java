package com.example;

public class DumpPlayer implements PlayerStrategy {
    //This DumpPlayer will bet and call when get Q
    private String playerName = "DumpPlayer";

    @Override
    public boolean betAsPlayer1(Card card) {
        int cardValue = card.getValue();
        if(cardValue == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean callAsPlayer2(Card card) {
        int cardValue = card.getValue();
        if(cardValue == 0) {
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
