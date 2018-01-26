package com.example;

public class GameEngine {

    private PlayerStrategy player1;
    private PlayerStrategy player2;
    private boolean bet;
    private boolean call;
    private int card1;
    private int card2;
    private int playerOneCoinNun;
    private int playerTwoCoinNun;
    private Card playerOneCard;
    private Card playerTwoCard;

    /***
     * This constructor will initialize who is player1 and who is player2
     * @param playerOneInput the actual player1 with certain strategy
     * @param playerTwoInput the actual player2 with certain strategy
     */
    public GameEngine(PlayerStrategy playerOneInput, PlayerStrategy playerTwoInput) {
        player1 = playerOneInput;
        player2 = playerTwoInput;
        playerOneCoinNun = 0;
        playerTwoCoinNun = 0;
    }
    //This method is used to deal card and ask each player's action according to their card.
    public void begainGame() {
        card1 = (int)(Math.random()*3);
        card2 = 0;
        do{
            card2 = (int)(Math.random()*3);
        }while(card1 == card2);
        playerOneCard = new Card(card1);
        playerTwoCard = new Card(card2);
        bet = player1.betAsPlayer1(playerOneCard);
        call = player2.callAsPlayer2(playerTwoCard);
    }

    public int result(){
        int whoWin = 1;
        if(card1 < card2) {
            whoWin = 2;
        }
        return whoWin;
    }

    /***
     * this method used to calculate bet how many chips and the chip that players own
     */
    public void processControl(){
        int result = result();
        int playerOneChip = 1;
        int playerTwoChip = 1;
        if(bet && call){ //2 coin, showdown
            playerOneChip += 1;
            playerTwoChip += 1;
            updateChip(result, playerOneChip, playerTwoChip);
        }else if(bet && !call) { //1 coin, fold
            playerOneChip += 1;
            updateChip(result, playerOneChip, playerTwoChip);
        }else { //1 coin, check
            updateChip(result, playerOneChip, playerTwoChip);
        }
    }
    //this helper method is used to update each player's chip number
    private void updateChip(int result, int playerOneChip, int playerTwoChip) {
        if(result == 1){
            playerOneCoinNun += playerTwoChip;
            playerTwoCoinNun -= playerTwoChip;
        }else{
            playerTwoCoinNun += playerOneChip;
            playerOneCoinNun -= playerOneChip;
        }
    }

    public void giveFeedback() {
        player1.feedbackAsPlayer1(playerOneCard, playerTwoCard, bet, call);
        player2.feedbackAsPlayer2(playerOneCard, playerTwoCard, bet, call);
    }

    public void showResult() {
        if(playerOneCoinNun > playerTwoCoinNun) {
            System.out.println(player1.getName() + " win!");
        }
        else{
            System.out.println(player2.getName() + " win!");
        }
        System.out.println(player1.getName() + " have " + String.valueOf(playerOneCoinNun) + " chips");
        System.out.println(player2.getName() + " have " + String.valueOf(playerTwoCoinNun) + " chips");
    }

    public int getCard2() {
        return card2;
    }

    public int getCard1() {
        return card1;
    }
}
