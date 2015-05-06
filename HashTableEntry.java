package com.oliver;

public class HashTableEntry {

    private String key;
    private int value;
    private HashTableEntry nextEntry;

    HashTableEntry(String key, int value) {

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

    //  -> HashTableEntry
    // Return the next hash entry after this hash entry in the hash table chain.
    // Strategy: Domain Knowledge
    public HashTableEntry getNextEntry() {

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

    // HashTableEntry -> void
    // Given a hash entry set the next hash entry to it.
    // Strategy: Domain Knowledge
    public void setNextEntry(HashTableEntry entry) {

        nextEntry = entry;
    }
}
