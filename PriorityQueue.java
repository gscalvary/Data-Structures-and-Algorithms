package com.oliver;

public class PriorityQueue {

    private LinkedList list;

    public PriorityQueue() {

        list = new LinkedList();
    }

    private class PQEntry {

        private Object data;
        private Object key;

        public PQEntry(Object data, Object key) {

            this.data = data;
            this.key = key;
        }

        public Object getData() {

            return data;
        }

        public void setData(Object data) {

            this.data = data;
        }

        public Object getKey() {

            return key;
        }

        public void setKey(Object key) {

            this.key = key;
        }
    }

    // Object, Object -> void
    // EFFECT: Given an object containing data and an object with a key add it to the end of the list.
    // Strategy: Function Composition
    public void inject(Object data, Object key) {

        PQEntry pqEntry = new PQEntry(data, key);
        LinkedListEntry entry = new LinkedListEntry(pqEntry);
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

    // Object, Object -> void
    // EFFECT: Given a data object and a new key value "update" it in the queue by deleting it's former entry and
    // adding it as a new entry.
    // Strategy: Function Composition
    public void updateKey(Object data, Object key) {

        int size = list.getSize();

        if(size != 0) {
            PQEntry newEntry;
            for (int i = 1; i <= size; i++) {
                newEntry = (PQEntry)list.getEntry(i).getValue();
                if(data.equals(newEntry.getData())) {
                    list.remove(i);
                    inject(data, key);
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
