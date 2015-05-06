package com.oliver;

public class HashTable {

    private int tableSize;
    private int numEntries;
    private HashTableEntry[] table;

    HashTable(int tableSize) {

        numEntries = 0;
        this.tableSize = tableSize;
        table = new HashTableEntry[tableSize];

        // initialize the table
        clear();
    }

    // -> int
    // Return the number of entries in the table.
    // Strategy: Domain Knowledge
    public int getNumEntries() {

        return numEntries;
    }

    //   -> void
    // EFFECT: Clear the hash table.
    // Strategy: Function Composition
    public void clear() {

        for(int i = 0; i < tableSize; i++) {
            table[i] = null;
        }
    }

    // String -> int
    // Given a String key return its associated int value.
    // Strategy: Structural Decomposition
    public int get(String key) {

        int hash = getHash(key) % tableSize;

        if(table[hash] == null) {
            return -1;
        } else {
            HashTableEntry entry = table[hash];
            while (entry != null && !entry.getKey().equals(key)) {
                entry = entry.getNextEntry();
            }
            if(entry == null) {
                return -1;
            } else {
                return entry.getValue();
            }
        }
    }

    // String, int -> void
    // EFFECT: Given a string key and an int value insert them into the hash table.
    // Strategy: Structural Decomposition
    public void insert(String key, int value) {

        int hash = getHash(key) % tableSize;

        if(table[hash] == null) {
            table[hash] = new HashTableEntry(key, value);
        } else {
            HashTableEntry entry = table[hash];
            while(entry.getNextEntry() != null && !entry.getKey().equals(key)) {
                entry = entry.getNextEntry();
            }
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
            } else {
                entry.setNextEntry(new HashTableEntry(key, value));
            }
        }
        
        numEntries++;
    }

    // String -> void
    // EFFECT: Given a string key remove its entry from the hash table.
    // Strategy: Function Composition
    public void remove(String key) {

        int hash = getHash(key) % tableSize;

        if(table[hash] != null) {
            HashTableEntry prevEntry = null;
            HashTableEntry entry = table[hash];
            while(entry.getNextEntry() != null && !entry.getKey().equals(key)) {
                prevEntry = entry;
                entry = entry.getNextEntry();
            }
            if(entry.getKey().equals(key)) {
                if(prevEntry == null) {
                    table[hash] = entry.getNextEntry();
                } else {
                    prevEntry.setNextEntry(entry.getNextEntry());
                }
                numEntries--;
            }
        }
    }

    // String -> int
    // Given a String key return an int hash value.
    // Strategy: Function Composition
    private int getHash(String key) {

        int hash = key.hashCode();
        hash %= tableSize;

        if(hash < 0) {
            hash += tableSize;
        }

        return hash;
    }

    //  -> void
    // Print the hash table.
    // Strategy: Function Composition
    public void print() {

        for(int i = 0; i < tableSize; i++) {
            System.out.print("\nSlot " + (i + 1) + ": ");
            HashTableEntry entry = table[i];
            while(entry != null) {
                System.out.print(entry.getValue() + " ");
                entry = entry.getNextEntry();
            }
        }
        System.out.print("\n");
    }
}
