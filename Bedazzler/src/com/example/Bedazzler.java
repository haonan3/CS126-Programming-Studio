package com.example;

public class Bedazzler {

    public static void main(String[] args) {
        System.out.println(Bedazzler.bedazzle("This is my string"));
        System.out.println("This line is used to test whether github can work well");

    }

    public static String bedazzle(String input) {
        String newstr = "";
        int i = 0;
        char a[] = input.toCharArray();
        int l = input.length();

        for(i=0; i<l; i++){   //notice the boundary
            newstr += "*";
            if (a[i] != ' '){
                newstr = newstr + a[i];
            }

            else {
                newstr = newstr + "  ";
            }
        }
        return newstr + "*";
    }
}

