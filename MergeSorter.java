package com.oliver;

import java.util.List;

public class MergeSorter {

    // List<Integer> -> List<Integer>
    // Given a list of integers return a list of the same integers sorted.
    // Strategy: Function Composition
    public List<Integer> mergeSort(List<Integer> input) {


        if(input.size() > 1) {
            // Compute half the size of the input list rounded down.
            int mid = input.size()/2;
            return merge(input.subList(0, mid + 1), input.subList(mid + 1, input.size()));
        } else {
            return input;
        }
    }

    // List<Integer>, List<Integer> -> List<Integer>
    // Given two list of integers merge them and return a single list.
    // Strategy: Function Composition
    private List<Integer> merge(List<Integer> x, List<Integer> y) {

        if(x.size() == 0) return y;
        if(y.size() == 0) return x;

        List<Integer> merged;

        if(x.get(0) <= y.get(0)) {
            merged = merge(x.subList(1, x.size()), y);
            merged.add(0, x.get(0));
        } else {
            merged = merge(x, y.subList(1, y.size()));
            merged.add(0, y.get(0));
        }

        return merged;
    }
}
