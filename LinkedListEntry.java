package com.oliver;

public class LinkedListEntry<T> {

    private T value;
    private LinkedListEntry next;

    public LinkedListEntry (T value) {

        this.value = value;
        next = null;
    }

    //  -> Object<T>
    // Return the value of the entry.
    // Strategy: Domain Knowledge
    public T getValue() {

        return value;
    }

    // Object<T> -> void
    // Set the value of the entry.
    // Strategy: Domain Knowledge
    public void setValue(T value) {

        this.value = value;
    }

    //  -> LinkedListEntry
    // Return the next entry.
    // Strategy: Domain Knowledge
    public LinkedListEntry getNext() {

        return next;
    }

    // LinkedListEntry -> void
    // Set the next entry.
    // Strategy: Domain Knowledge
    public void setNext(LinkedListEntry next) {

        this.next = next;
    }
}
