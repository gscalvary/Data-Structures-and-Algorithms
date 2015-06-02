package com.oliver;

public class LinkedList {

    private LinkedListEntry head;
    private int size;

    public LinkedList() {

        head = null;
        size = 0;
    }

    // LinkedListEntry -> void
    // EFFECT: Given a linked list entry add it as the linked list head and increment the size of the list.
    // Strategy: Function Composition
    public void addHead(LinkedListEntry entry) {

        LinkedListEntry temp = head;
        head = entry;
        head.setNext(temp);
        ++size;
    }

    // LinkedListEntry -> void
    // EFFECT: Given a linked list entry add it as the linked list tail and increment the size of the list.
    // Strategy: Function Composition
    public void addTail(LinkedListEntry entry) {

        if(head == null) {
            head = entry;
        } else {
            LinkedListEntry node = head;
            while(node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(entry);
        }

        ++size;
    }

    // int -> boolean
    // EFFECT: Given an integer index remove that particular element from the linked list and decrement the size of the
    // list.
    // Strategy: Function Composition
    public boolean remove(int index) {

        // Do we have a valid index?
        if(index < 1 || index > size) return false;

        if(index == 1) {
            head = head.getNext();
        } else {
            LinkedListEntry currEntry = head;
            for(int i = 2; i < index; i++) {
                if(currEntry.getNext() == null) {
                    return false;
                } else {
                    currEntry = currEntry.getNext();
                }
            }
            currEntry.setNext(currEntry.getNext().getNext());
        }

        --size;
        return true;
    }

    //  -> int
    // Return the number of entries in the linked list.
    // Strategy: Domain Knowledge
    public int getSize() {

        return size;
    }

    // int -> LinkedListEntry
    // Given an integer index return the associated entry.
    public LinkedListEntry getEntry(int index) {

        // Do we have a valid index?
        if(index < 1 || index > size)
            throw new IndexOutOfBoundsException("Must be between 1 and " + size + " inclusively.");

        LinkedListEntry entry = head;
        for(int i = 1; i < index; i++) {
            entry = entry.getNext();
        }

        return entry;
    }

    //  -> void
    // Clear the linked list.
    // Strategy: Domain Knowledge
    public void clear() {

        head = null;
        size = 0;
    }

    //  -> void
    // Print the linked list.
    // Strategy: Function Composition
    public void print() {

        LinkedListEntry entry = head;

        if(size == 0) {
            System.out.print("\nThe linked list is empty.\n");
        } else {
            System.out.print("\nThe linked list now contains:\n");
            while(true) {
                if(entry == null) break;
                System.out.println(entry.getValue());
                entry = entry.getNext();
            }
        }

        System.out.print("\n");
    }

    // String -> void
    // Given a string representing how this linked list is being used, print the linked list.
    // Strategy: Structural Decomposition
    public void print(String use) {

        LinkedListEntry entry = head;

        if(size == 0) {
            System.out.print("\nThe " + use + " is empty.\n");
        } else {
            System.out.print("\nThe " + use + " now contains:\n");
            while(true) {
                if(entry == null) break;
                System.out.println(entry.getValue());
                entry = entry.getNext();
            }
        }

        System.out.print("\n");
    }
 }
