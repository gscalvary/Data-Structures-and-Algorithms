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

    // Object<K> -> Object<V>
    // Given a key return its associated value.
    // Strategy: Structural Decomposition
    public <K> Object get(K key) {

        int hash = getHash(key);

        if(table[hash] == null) {
            return null;
        } else {
            HashTableEntry entry = table[hash];
            while (entry != null && !entry.getKey().equals(key)) {
                entry = entry.getNextEntry();
            }
            if(entry == null) {
                return null;
            } else {
                return entry.getValue();
            }
        }
    }

    // Object<K>, Object<V> -> void
    // EFFECT: Given a key and a value insert them into the hash table.
    // Strategy: Structural Decomposition
    public <K, V> void insert(K key, V value) {

        int hash = getHash(key);

        if(table[hash] == null) {
            table[hash] = new HashTableEntry<K, V>(key, value);
        } else {
            HashTableEntry entry = table[hash];
            while(entry.getNextEntry() != null && !entry.getKey().equals(key)) {
                entry = entry.getNextEntry();
            }
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
            } else {
                entry.setNextEntry(new HashTableEntry<K, V>(key, value));
            }
        }
        
        numEntries++;
    }

    // String -> void
    // EFFECT: Given a string key remove its entry from the hash table.
    // Strategy: Function Composition
    public <K> void remove(K key) {

        int hash = getHash(key);

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

    // Object<K> -> int
    // Given a key return an int hash value.
    // Strategy: Function Composition
    private <K> int getHash(K key) {

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
