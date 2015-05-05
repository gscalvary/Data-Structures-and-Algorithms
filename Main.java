package com.oliver;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Play with the hash table!\n\n");
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
            System.out.println("Do you want to continue? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}
