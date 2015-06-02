package com.oliver;

public class PriorityQueue {

    private LinkedList list;

    public PriorityQueue() {

        list = new LinkedList();
    }

    private class PQEntry<K, V> {

        private V data;
        private K key;

        public PQEntry(K key, V data) {

            this.data = data;
            this.key = key;
        }

        public V getData() {

            return data;
        }

        public K getKey() {

            return key;
        }
    }

    // Object<K>, Object<V> -> void
    // EFFECT: Given an object containing data and an object with a key add it to the end of the list.
    // Strategy: Function Composition
    public <K, V> void inject(K key, V data) {

        PQEntry pqEntry = new PQEntry<K, V>(key, data);
        LinkedListEntry entry = new LinkedListEntry<PQEntry>(pqEntry);
        list.addTail(entry);
    }

    //  -> Object
    // EFFECT: Remove and return the object in the list with the lowest key value.
    // Strategy: Function Composition
    public Object eject() {

        int size = list.getSize();

        if(size == 0) {
            return null;
        } else {
            int min = 1;
            PQEntry minEntry = (PQEntry)list.getEntry(1).getValue();
            PQEntry newEntry;
            for (int i = 2; i <= size; i++) {
                newEntry = (PQEntry)list.getEntry(i).getValue();
                if((Integer)newEntry.getKey() < (Integer)minEntry.getKey()) {
                    min = i;
                    minEntry = newEntry;
                }
            }
            list.remove(min);
            return minEntry.getData();
        }
    }

    // Object<K>, Object<V> -> void
    // EFFECT: Given a data object and a new key value "update" it in the queue by deleting it's former entry and
    // adding it as a new entry.
    // Strategy: Function Composition
    public <K, V> void updateKey(K key, V data) {

        int size = list.getSize();

        if(size != 0) {
            PQEntry newEntry;
            for (int i = 1; i <= size; i++) {
                newEntry = (PQEntry)list.getEntry(i).getValue();
                if(data.equals(newEntry.getData())) {
                    list.remove(i);
                    inject(key, data);
                    break;
                }
            }
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

    //  -> void
    // Print the entries in the list.
    // Strategy: Function Composition
    public void print() {

        int size = list.getSize();

        if(size == 0) {
            System.out.print("\nThe priority queue is empty.\n");
        } else {
            for (int i = 1; i <= size; i++) {
                System.out.println("data: " + ((PQEntry) list.getEntry(i).getValue()).getData() + " : " +
                        ((PQEntry) list.getEntry(i).getValue()).getKey());
            }
        }
        System.out.print("\n");
    }
}
