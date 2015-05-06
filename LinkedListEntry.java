package com.oliver;

public class LinkedListEntry {

    private Object value;
    private LinkedListEntry next;

    public LinkedListEntry(Object value) {

        this.value = value;
        next = null;
    }

    //  -> Object
    // Return the value of the entry.
    // Strategy: Domain Knowledge
    public Object getValue() {

        return value;
    }

    // Object -> void
    // Set the value of the entry.
    // Strategy: Domain Knowledge
    public void setValue(Object value) {

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
