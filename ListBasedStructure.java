package com.oliver;

abstract class ListBasedStructure {

    protected LinkedList list;

    public ListBasedStructure() {

        list = new LinkedList();
    }

    abstract <T> void inject(T data);

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

    abstract void print();
}
