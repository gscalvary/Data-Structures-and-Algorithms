package com.oliver;

public class HashTableEntry<K, V> {

    private K key;
    private V value;
    private HashTableEntry nextEntry;

    HashTableEntry (K key, V value) {

        this.key = key;
        this.value = value;
        nextEntry = null;
    }

    //  -> Object<K>
    // Return the key of the hash entry.
    // Strategy: Domain Knowledge
    public K getKey() {

        return key;
    }

    //  -> HashTableEntry
    // Return the next hash entry after this hash entry in the hash table chain.
    // Strategy: Domain Knowledge
    public HashTableEntry getNextEntry() {

        return nextEntry;
    }

    //  -> Object<V>
    // Return the value of the hash entry.
    // Strategy: Domain Knowledge
    public V getValue() {

        return value;
    }

    // Object<V> -> void
    // Set the value of the hash entry.
    // Strategy: Domain Knowledge
    public void setValue(V value) {

        this.value = value;
    }

    // HashTableEntry -> void
    // Given a hash entry set the next hash entry to it.
    // Strategy: Domain Knowledge
    public void setNextEntry(HashTableEntry entry) {

        nextEntry = entry;
    }
}
