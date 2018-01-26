package com.example;

public class ToString {
    public static  String  toString(String[] array){
        String ret_string = "";
        int element_num = array.length;
        System.out.println(element_num);
        if (element_num>2) {
            for (int i = 0; i < element_num; i++) {
                if (element_num - i >= 3) {
                    ret_string = ret_string + array[i]+", ";
                }else{
                    ret_string = ret_string + array[i] +" and "+ array[i+1];
                }
            }
        }else if(element_num == 2){
            ret_string = array[0]+", "+array[1];
        }else
            ret_string = array[0];
        return ret_string;
    }

    public static void main(String[] args){
        String[] test =  new String[]{"thing1","thing2"};

        System.out.println(ToString.toString(test));
    }
}
