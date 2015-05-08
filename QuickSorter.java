package com.oliver;

public class QuickSorter {

    private int[] array;

    public QuickSorter() {

        array = null;
    }

    // int[], int, int -> int[]
    // EFFECT: Given an array of integers, a starting index and an ending index sort the integers inclusively
    // between the given indices and return the (partially) sorted array.
    // Strategy: Function Composition
    public int[] sort(int[] input, int lo, int hi) {

        array = input;
        quickSort(lo, hi);

        return array;
    }

    // int, int -> void
    // EFFECT: Given a low and a high index sort the integers in array between these indices inclusively.
    // Strategy: General Recursion
    private void quickSort(int lo, int hi) {

        if(lo < hi) {
            int p = partition(lo, hi);
            quickSort(lo, p - 1);
            quickSort(p + 1, hi);
        }
    }

    // int, int -> int
    // EFFECT: Given a low and a high index partition array by moving all integers less than a chosen pivot point to the
    // left of the pivot and all integers greater than the pivot point to the right of the pivot.  Return the index of
    // the pivot point.
    // Strategy: Function Composition
    private int partition(int lo, int hi) {

        int pivotValue = array[hi];
        int storeIndex = lo;

        for(int i = lo; i < hi; i++) {
            if(array[i] < pivotValue) {
                swap(i, storeIndex);
                ++storeIndex;
            }
        }

        swap(storeIndex, hi);

        return storeIndex;
    }

    // int, int -> void
    // EFFECT: Given two indices swap the values of each in array.
    // Strategy: Domain Knowledge
    private void swap(int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
