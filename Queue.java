package com.oliver;

public class Queue extends ListBasedStructure {

    public Queue() {

        super();
    }

    // Object -> void
    // EFFECT: Given an object add it to the end of the list.
    // Strategy: Function Composition
    public void inject(Object data) {

        LinkedListEntry entry = new LinkedListEntry(data);
        list.addTail(entry);
    }

    //  -> void
    // Print the entries in the list.
    // Strategy: Function Composition
    public void print() {

        list.print("Queue");
    }
}
