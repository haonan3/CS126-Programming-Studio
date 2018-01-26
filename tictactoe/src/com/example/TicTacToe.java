package com.example;

import com.sun.org.glassfish.gmbal.ParameterNames;
import jdk.nashorn.internal.objects.annotations.Function;
import sun.jvm.hotspot.oops.JumpData;

import java.util.*;

import static com.example.TicTacToe.Judge;

public class TicTacToe {

    public static Evaluation evaluateBoard(String boardState) {

        // implement your code here
        char input_array[] = boardState.toCharArray();
        int input_length = boardState.length();
        char priority = ' ';

        //get arraylist for X and O
        ArrayList<Integer> X_player = new ArrayList<Integer>();
        ArrayList<Integer> O_player = new ArrayList<Integer>();
        X_player = getArrayX(input_array);
        O_player = getArrayO(input_array);


        //judge who win; 1 represent win, 0 represent lose
        int X_win = Judge(X_player);
        int O_win = Judge(O_player);


        if (input_array.length != 9) {            // input not equal to 9 is invalid
            return Evaluation.InvalidInput;
        } else if (X_win + O_win == 2 || X_win == 1 && X_player.size() - O_player.size() != 1 ||
                O_win == 1 && O_player.size() != X_player.size() || X_win + O_win == 0 &&
                X_player.size() < O_player.size()) { //both win, X or O take wrong number are unreachableState
            return Evaluation.UnreachableState;
        } else if (X_win + O_win == 0) {    // Both X and O don't win
            return Evaluation.NoWinner;
        } else if (O_win == 1) {       //O win
            return Evaluation.Owins;
        } else if (X_win == 1) {   //X win
            return Evaluation.Xwins;
        } else {
            return Evaluation.InvalidInput;
        }
    }

    @ParameterNames({"a is the input array"})
    //This function can get X array from origional array
    public static ArrayList<Integer> getArrayX(char[] a) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'X' || a[i] == 'x') {
                A.add(i);   //i is int, not integer!!
            }
        }
        return A;
    }

    @ParameterNames({"a is the input array"})
    //This function can get O array from origional array
    public static ArrayList<Integer> getArrayO(char[] a) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'O' || a[i] == 'o') {
                A.add(i);   //i is int, not integer!!
            }
        }
        return A;
    }

    //This function is used to judge who win
    public static int Judge(ArrayList<Integer> input) {
        int length = input.size();
        int pos;
        if (input.contains(2) && input.contains(4) && input.contains(6)) {  //special cases
            return 1;
        }
        if (input.contains(0) && input.contains(1) && input.contains(2)) {
            return 1;
        }
        if (input.contains(3) && input.contains(4) && input.contains(5)) {
            return 1;
        }
        if (input.contains(6) && input.contains(7) && input.contains(8)) {
            return 1;
        }

        if (length < 3) {
            return 0;
        } else {
            for (int k = 0; k < 3; k++) {  //need to kill input<9 before the loop! dangerous! Be sure this arraylist has at
                //least 3 elements!!!!
                for (int l = 3; l < 5; l++) {
                    int num = 0;
                    for (int i = 1; i < length; i++) {
                        pos = input.indexOf(input.get(k) + l * i);
                        if (pos != -1) {
                            num += 1;
                        }
                        /*else {
                            num = 0;
                        }*/
                    }
                    if (num == 2) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        TicTacToe.evaluateBoard(args[0]);
    }

}