package com.example;

public class OneSideQuicksort {

    public double findNth(double[] A, int low, int high, int position) {
        //Check whether the array is valid
        if (A == null || A.length == 0) {
            System.out.println("Invalid input array");
            return 0;
        }

        if (low < high) {
            int p = partition(A, low, high);
            if (position == p) {
                return A[position];
            }
            if (position < p) {
                return findNth(A, low, p - 1, position);
            } else {
                return findNth(A, p + 1, high, position);
            }
        }
        return A[position];
    }

    public int partition(double[] A, int low, int high) {
        double pivot = A[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                i = i + 1;
                swap(A, i, j);
            }
        }
        if (A[high] < A[i + 1]) {
            swap(A, i + 1, high);
        }
        return i + 1;
    }

    /*
    * this helper method is to swap two elements in one array
    * */
    public void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
