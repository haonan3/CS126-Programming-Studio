package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by ________
 */
public class TicTacToeTest {
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }
    @Test
    public void NoWinnerBoard() throws Exception{
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("xoxxoooxx"));
    }
    @Test
    public void InvalidInputBoard() throws Exception{
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("qwe3"));
    }
    @Test
    public void UnreachableStateBoard2() throws Exception{
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XxXoOo../"));
    }
    @Test
    public void UnreachableStateBoard() throws Exception{
        assertEquals(Evaluation.UnreachableState,TicTacToe.evaluateBoard("x.oxoxxoo"));
    }
    @Test
    public void XwinsBoard() throws Exception{
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("xooooxxxx"));
    }

    @Test
    public void UnreachableBoard2() throws Exception{
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("x.xxxoOox"));
    }
    @Test
    public void UnreachableBoard3() throws Exception{
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("?oxxxOoo."));
    }
    @Test
    public void OwinsBoard() throws Exception{
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("xooxox?ox"));
    }
    @Test
    public void UnreachableBoard4() throws Exception{
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("OOOOOOXXX"));
    }    @Test
    public void UnreachableBoard5() throws Exception{
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("xxxxxxxxx"));
    }
    @Test
    public void InvalidInput() throws Exception{
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("xoox"));
    }
    @Test
    public void InvalidInput2() throws Exception{
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("ooox"));
    }

}