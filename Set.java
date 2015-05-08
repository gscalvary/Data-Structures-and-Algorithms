package com.oliver;

public class Set<T> {

    private T[] set;
    private int numEntries;

    public Set() {

        set = null;
        numEntries = 0;
    }

    // T -> void
    // EFFECT: Given an object of type T add it to the set.
    // Strategy: Function Composition
    public void add(T data) {

        if(set == null) {
            set = (T[]) new Object[] {data};
            numEntries++;
            return;
        }

        if(!contains(data)) {
            T[] temp = set;
            set = (T[]) new Object[numEntries + 1];
            System.arraycopy(temp, 0, set, 0, numEntries);
            set[numEntries] = data;
            numEntries++;
        }
    }

    // T -> void
    // EFFECT: Given an object of type T remove it from the set.
    // Strategy: Function Composition
    public void remove(T data) {

        if(set == null) return;

        int index = getIndex(data);

        if(index >= 0) {
            T[] temp = set;
            set = (T[]) new Object[numEntries - 1];
            if(index == 0) {
                System.arraycopy(temp, 1, set, 0, numEntries - 1);
            } else if (index == numEntries - 1) {
                System.arraycopy(temp, 0, set, 0, numEntries - 1);
            } else {
                System.arraycopy(temp, 0, set, 0, index);
                System.arraycopy(temp, index + 1, set, index, numEntries - 1 - index);
            }
            numEntries--;
        }
    }

    // T -> boolean
    // Given an object of type T return true if the element is in the set or false if it is not.
    // Strategy: Structural Decomposition
    public boolean contains(T data) {

        if(set == null) return false;

        for(T element: set) {
            if(element.equals(data)) {
                return true;
            }
        }

        return false;
    }

    // -> int
    // Return the number of entries in the set.
    public int getNumEntries() {

        return numEntries;
    }

    //  -> void
    // EFFECT: Clear the set.
    // Strategy: Domain Knowledge
    public void clear() {

        set = null;
        numEntries = 0;
    }

    //  -> void
    // Print the set.
    // Strategy: Structural Decomposition
    public void print() {

        if(set == null) {
            System.out.println("The set is empty.");
        } else {
            System.out.print("The set contains:");
            for (T element: set) {
                System.out.print(" " + element + " ");
            }
        }

        System.out.print("\n\n");
    }

    // Object -> int
    // Given an object return the index positon of the element in the set.
    // INVARIANT: If the element is not present in the set -1 is returned.
    private int getIndex(Object data) {

        for (int i = 0; i < numEntries; i++) {
            if(set[i].equals(data)) return i;
        }

        return -1;
    }
}
