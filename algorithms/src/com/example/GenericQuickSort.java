package com.example;

import static javafx.application.Platform.exit;

public class GenericQuickSort<T extends Comparable<T>> {


    public T findNth(T[] A, int low, int high, int position) {
        if (A == null || A.length == 0) {
            System.out.println("invalid input");
            System.exit(0);
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

    public int partition(T[] A, int low, int high) {
        T pivot = A[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (A[j].compareTo(pivot) < 0) {
                i = i + 1;
                swap(A, i, j);
            }
        }
        if (A[high].compareTo(A[i + 1]) < 0) {
            swap(A, i + 1, high);
        }
        return i + 1;
    }

    public void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
