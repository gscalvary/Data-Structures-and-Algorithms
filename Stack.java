package com.oliver;

public class Stack extends ListBasedStructure{

    public Stack() {

        super();
    }

    // Object<T> -> void
    // EFFECT: Given an object add it to the head of the list.
    // Strategy: Function Composition
    public <T> void inject(T data) {

        LinkedListEntry entry = new LinkedListEntry<T>(data);
        list.addHead(entry);
    }

    //  -> void
    // Print the entries in the list.
    // Strategy: Function Composition
    public void print() {

        list.print("Stack");
    }
}
