package com.oliver;

public class Stack {

    private LinkedList list;

    public Stack() {

        list = new LinkedList();
    }

    // Object -> void
    // EFFECT: Given an object add it to the head of the list.
    // Strategy: Function Composition
    public void inject(Object data) {

        LinkedListEntry entry = new LinkedListEntry(data);
        list.addHead(entry);
    }

    //  -> Object
    // EFFECT: Remove and return the first object in the list.
    // Strategy: Function Composition
    public Object eject() {

        if(list.getSize() == 0) {
            return null;
        } else {
            Object data = list.getEntry(1).getValue();
            list.remove(1);
            return data;
        }
    }

    //  -> int
    // Return the number of objects in the list.
    // Strategy: Function Composition
    public int getSize() {

        return list.getSize();
    }

    //  -> void
    // EFFECT: Clear the list of all objects.
    // Strategy: Function Composition
    public void clear() {

        list.clear();
    }

    //  -> void
    // Print the entries in the list.
    // Strategy: Function Composition
    public void print() {

        list.print("Stack");
    }
}
