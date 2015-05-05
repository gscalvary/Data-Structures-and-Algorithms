package com.oliver;

public class HashEntry {

    private String key;
    private int value;
    private HashEntry nextEntry;

    HashEntry(String key, int value) {

        this.key = key;
        this.value = value;
        nextEntry = null;
    }

    //  -> String
    // Return the key of the hash entry.
    // Strategy: Domain Knowledge
    public String getKey() {

        return key;
    }

    //  -> HashEntry
    // Return the next hash entry after this hash entry in the hash table chain.
    // Strategy: Domain Knowledge
    public HashEntry getNextEntry() {

        return nextEntry;
    }

    //  -> int
    // Return the value of the hash entry.
    // Strategy: Domain Knowledge
    public int getValue() {

        return value;
    }

    // int -> void
    // Set the value of the hash entry.
    // Strategy: Domain Knowledge
    public void setValue(int value) {

        this.value = value;
    }

    // HashEntry -> void
    // Given a hash entry set the next hash entry to it.
    // Strategy: Domain Knowledge
    public void setNextEntry(HashEntry entry) {

        nextEntry = entry;
    }
}
