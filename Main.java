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
            System.out.println("2. Work with a hash table.");
            System.out.println("3. Work with mergesort.");

            switch(scanner.nextInt()) {
                case 1:
                    linkedLists();
                    break;
                case 2:
                    hashTables();
                    break;
                case 3:
                    mergeSort();
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2 or 3.");
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
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4 or 5.");
                    break;
            }

            list.print();
            System.out.println("Do you want to continue using this linked list? (y or n)");
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
