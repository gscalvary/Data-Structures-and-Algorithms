package com.oliver;

import java.util.List;

public class MergeSorter {

    // int[] -> Object
    // Given an array of integers return an array of the same integers sorted.
    // Strategy: Function Composition
    public Object mergeSort(int[] input) {

        Queue queue = new Queue();

        for(int number : input) {
            int[] entry = new int[] {number};
            queue.inject(entry);
        }

        while (queue.getSize() > 1) {
            queue.inject(merge((int[])queue.eject(), (int[])queue.eject()));
        }

        return queue.eject();
    }

    // int[], int[] -> int[]
    // Given two arrays of integers merge them and return a single array.
    // Strategy: Function Composition
    private int[] merge(int[] x, int[] y) {

        if(x.length == 0) return y;
        if(y.length == 0) return x;

        if(x[0] <= y[0]) {
            int[] smallX = new int[x.length - 1];
            System.arraycopy(x, 1, smallX, 0, x.length - 1);
            int[] merged = merge(smallX, y);
            int[] combo = new int[merged.length + 1];
            combo[0] = x[0];
            System.arraycopy(merged, 0, combo, 1, merged.length);
            return combo;
        } else {
            int[] smallY = new int[y.length - 1];
            System.arraycopy(y, 1, smallY, 0, y.length - 1);
            int[] merged = merge(x, smallY);
            int[] combo = new int[merged.length + 1];
            combo[0] = y[0];
            System.arraycopy(merged, 0, combo, 1, merged.length);
            return combo;
        }
    }
}
