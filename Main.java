// This code was written while I was studying for technical interviews just after finishing my CS degree.  Note the
// testing interface isn't incredibly robust, the focus of this exercise was brushing up on data structures and algor-
// ithms!  -- C. Oliver 5/6/14
//
// Here are the topics covered:
//
// Data Structures
// -----------------------
// Hash Tables - Provides O(1) time complexity for key-value pair look-ups if the hashing algorithm is perfect else time
//               complexity is O(n) where n is the greatest number of collided entries in any hash table slot.  This
//               implementation uses linked chaining to handle collisions.
// Linked List - I implemented a linked list with specific functionality to support queues and stacks.
// Queue       - The queue is built upon the linked list.  Objects added to a queue are placed at the end of the line
//               while objects removed from the queue are taken from the front of the line, so a queue is FIFO.
// Stack       - The stack is built upon the linked list.  Objects added to a stack are placed on top of the pile and
//               objects removed from the stack are taken from the top of the pile, so a stack is LIFO.
//
// Algorithms
// -----------------------
// Merge Sort - In practice the time complexity of a merge sort is O((n)Log(n)) but there are worst case scenarios where
//              merge sort's complexity jumps to O(n^2).  The worst case occurs if each all of the elements in each
//              sub-array must be compared, e.g. using a bottom-up approach we can determine a worst case input:
//              [0, 1, 2, 3, 4, 5, 6, 7] -> [0, 2, 4, 6], [1, 3, 5, 7] -> [0, 4], [2, 6], [1, 5], [3, 7] ->
//              [4, 0, 6, 2, 5, 1, 7, 3]


package com.oliver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        System.out.println("Fun with data structures and algorithms!\n\n");
        System.out.println("Choose a function: ");

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. Work with a linked list.");
            System.out.println("2. Work with a queue.");
            System.out.println("3. Work with a stack.");
            System.out.println("4. Work with a hash table.");
            System.out.println("5. Work with mergesort.");

            switch(scanner.nextInt()) {
                case 1:
                    linkedLists();
                    break;
                case 2:
                    queues();
                    break;
                case 3:
                    stacks();
                    break;
                case 4:
                    hashTables();
                    break;
                case 5:
                    mergeSort();
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4 or 5.");
                    break;
            }

            System.out.println("Do you want to continue? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void linkedLists() {

        LinkedList list = new LinkedList();

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. insert as head");
            System.out.println("2. insert as tail");
            System.out.println("3. remove entry");
            System.out.println("4. get entry");
            System.out.println("5. number of entries");
            System.out.println("6. clear");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("Enter entry value:");
                    LinkedListEntry entry = new LinkedListEntry(scanner.next());
                    list.addHead(entry);
                    break;
                case 2:
                    System.out.println("Enter entry value:");
                    LinkedListEntry entry1 = new LinkedListEntry(scanner.next());
                    list.addTail(entry1);
                    break;
                case 3:
                    System.out.println("Enter the index of the entry to remove:");
                    if(list.remove(scanner.nextInt())) {
                        System.out.println("\nRemove successful!");
                    } else {
                        System.out.println("\nRemove unsuccessful!");
                    }
                    break;
                case 4:
                    System.out.println("Enter the index of the entry to get:");
                    if(list.getEntry(scanner.nextInt()) == null) {
                        System.out.println("\nThat's not a valid entry!");
                    } else {
                        System.out.println("\nThat entries value is: " + list.getEntry(scanner.nextInt()).getValue());
                    }
                    break;
                case 5:
                    System.out.println("Number of entries = " + list.getSize());
                    break;
                case 6:
                    list.clear();
                    System.out.println("List successfully cleared!");
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4, 5 or 6.");
                    break;
            }

            list.print();
            System.out.println("Do you want to continue using this linked list? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void queues() {

        Queue queue = new Queue();

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. inject");
            System.out.println("2. eject");
            System.out.println("3. number of entries");
            System.out.println("4. clear");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("Enter entry value:");
                    queue.inject(scanner.next());
                    break;
                case 2:
                    System.out.println("Object returned: " + queue.eject());
                    break;
                case 3:
                    System.out.println("Number of entries = " + queue.getSize());
                    break;
                case 4:
                    queue.clear();
                    System.out.println("Queue successfully cleared!");
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3 or 4.");
                    break;
            }

            queue.print();
            System.out.println("Do you want to continue using this queue? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void stacks() {

        Stack stack = new Stack();

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. inject");
            System.out.println("2. eject");
            System.out.println("3. number of entries");
            System.out.println("4. clear");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("Enter entry value:");
                    stack.inject(scanner.next());
                    break;
                case 2:
                    System.out.println("Object returned: " + stack.eject());
                    break;
                case 3:
                    System.out.println("Number of entries = " + stack.getSize());
                    break;
                case 4:
                    stack.clear();
                    System.out.println("Stack successfully cleared!");
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3 or 4.");
                    break;
            }

            stack.print();
            System.out.println("Do you want to continue using this stack? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void hashTables() {

        System.out.println("Enter size to build the table: ");

        HashTable table = new HashTable(scanner.nextInt());

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. clear");
            System.out.println("5. number of entries");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("Enter key and value:");
                    table.insert(scanner.next(), scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Enter key:");
                    table.remove(scanner.next());
                    break;
                case 3:
                    System.out.println("Enter key:");
                    System.out.println("Value: " + table.get(scanner.next()));
                    break;
                case 4:
                    table.clear();
                    System.out.println("Clear complete!");
                    break;
                case 5:
                    System.out.println("Number of entries = " + table.getNumEntries());
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4 or 5.");
                    break;
            }

            table.print();
            System.out.println("Do you want to continue using this hash table? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void mergeSort() {

        MergeSorter sorter = new MergeSorter();
        List<Integer> listToSort = new ArrayList<Integer>();

        char ch;

        do {
            System.out.println("\nEnter an integer to add it to a list to sort.\n");
            listToSort.add(scanner.nextInt());
            System.out.println("So far we have: " + listToSort);
            System.out.println("Do you want to continue entering integers? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

        List<Integer> sortedList = sorter.mergeSort(listToSort);
        System.out.println("Our sorted list: " + sortedList);
    }
}
