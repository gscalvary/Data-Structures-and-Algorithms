package com.oliver;

public class Queue extends ListBasedStructure {

    public Queue() {

        super();
    }

    // Object<T> -> void
    // EFFECT: Given an object add it to the end of the list.
    // Strategy: Function Composition
    public <T> void inject(T data) {

        LinkedListEntry entry = new LinkedListEntry<T>(data);
        list.addTail(entry);
    }

    //  -> void
    // Print the entries in the list.
    // Strategy: Function Composition
    public void print() {

        list.print("Queue");
    }
}
