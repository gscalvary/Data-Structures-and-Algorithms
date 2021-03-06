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
// Priority Queue - The priority queue is built upon the linked list.  In this implementation an insert is of O(1)
//               time complexity as the linked list is unordered so new entries are simply added as a tail.  Decreasing
//               a key and deleting a minimum are of linear time complexity O(n) where n is the size of the queue.
// Stack       - The stack is built upon the linked list.  Objects added to a stack are placed on top of the pile and
//               objects removed from the stack are taken from the top of the pile, so a stack is LIFO.
// Set         - The set is built upon arrays and is type agnostic.  It does not allow any object in the set to be a
//               duplicate of any other object in the set.
// Tree        - A basic tree using a linked object implementation where each tree points to its parent and its
//               children.
// Graph       - Implemented using an adjacency matrix of n x n size where n is the number of vertices in the graph.
//               The intersection of two vertices is stored as a boolean.  The boolean is true if there is an edge
//               between the vertices.  This supports both undirected and directed graphs.  Adding, removing and
//               returning if an edge exists all take O(1) time.  Determining all of the out and in edges takes O(n)
//               time as all of the entries in the vertexes row or column must be scanned.  The space complexity of the
//               adjacency matrix approach is O(n^2).
//
// Algorithms
// -----------------------
// Merge Sort - In practice the time complexity of a merge sort is O((n)Log(n)) but there are worst case scenarios where
//              merge sort's complexity jumps to O(n^2).  The worst case occurs if each all of the elements in each
//              sub-array must be compared, e.g. using a bottom-up approach we can determine a worst case input:
//              [0, 1, 2, 3, 4, 5, 6, 7] -> [0, 2, 4, 6], [1, 3, 5, 7] -> [0, 4], [2, 6], [1, 5], [3, 7] ->
//              [4, 0, 6, 2, 5, 1, 7, 3]
//              This implementation of merge sort uses an iteration over the entries of a queue.  We start by adding
//              singleton integer arrays to the queue, one for each input entry, then a merge function combines the
//              arrays in a recursive manner in sorted order.  Merge sort is a stable sort and has a space complexity
//              in common implementations of O(2n).
// Quick Sort - The time complexity of quick sort is the same as that of merge sort but quick sort has a space
//              complexity of O(n).  Quick sort is also a divide and conquer algorithm but does it's work by partition-
//              ing the array to be sorted in two, choosing a pivot point in  each of the two arrays and moving elements
//              with a value less than the pivot point to the left of the pivot point and elements with values greater
//              than the pivot point to the right of it.  The swaps are done in place without the need for additional
//              memory allocation.  Quick sort is not a stable sort.
// Depth First Search - Linear in the size of its input the time complexity of DFS is O(|V| + |E|).  This implementation
//              identifies connected components and tracks pre- and post- visit ordering.
// Breadth First Search - Linear in the size of its input the time complexity of BFS is O(|V| + |E|).  This
//              implementation takes a vertex as input and sets the distance between it and all other reachable vertices
//              in the graph.
// Dijkstra   - Calculates the shortest path through a graph whose edges are annotated with a length greater than or
//              equal to 0.  The running time is dependant upon the priority queue implementation.  If a binary heap is
//              used the running time is O((|V| + |E|)log |V|).
// Bellman-Ford - Calculates the shortest path through a graph whose edges are annotated with a length but that does not
//              have a negative cycle.  The algorithm iterates |V| - 1 times over all the edges in the graph calculating
//              the distance from some given source node to each vertex during each iteration.  The run time for the
//              algorithm is O(|V|*|E|).
// A*         - Calculates the shortest path between a source and a destination node through a graph whose edges are
//              annotated with a length and whose vertices are annotated with a heuristic.  This implementation is
//              based on Dijkstra's algorithm so the lengths of the edges must be non-zero.  Like with Dijkstra the run
//              time is dependant upon the priority queue implementation so if a binary heap is used the run time is
//              less than O((|V| + |E|)log |V|) with an admissable heuristic.

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
            System.out.println("3. Work with a priority queue.");
            System.out.println("4. Work with a stack.");
            System.out.println("5. Work with a hash table.");
            System.out.println("6. Work with a set.");
            System.out.println("7. Work with a tree.");
            System.out.println("8. Work with a graph.");
            System.out.println("9. Work with a merge sort.");
            System.out.println("10. Work with a quick sort.");
            System.out.println("11. Work with depth first search.");
            System.out.println("12. Work with breadth first search.");
            System.out.println("13. Work with Dijkstra shortest path.");
            System.out.println("14. Work with Bellman-Ford shortest path.");
            System.out.println("15. Work with A* shortest path.");
            System.out.println();

            switch(scanner.nextInt()) {
                case 1:
                    linkedLists();
                    break;
                case 2:
                    queues();
                    break;
                case 3:
                    priorityQueues();
                    break;
                case 4:
                    stacks();
                    break;
                case 5:
                    hashTables();
                    break;
                case 6:
                    sets();
                    break;
                case 7:
                    trees();
                    break;
                case 8:
                    graphs();
                    break;
                case 9:
                    mergeSort();
                    break;
                case 10:
                    quickSort();
                    break;
                case 11:
                    dfs();
                    break;
                case 12:
                    bfs();
                    break;
                case 13:
                    dijkstra();
                    break;
                case 14:
                    bellmanFord();
                    break;
                case 15:
                    aStar();
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 or 15.");
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
                    LinkedListEntry entry = new LinkedListEntry<String>(scanner.next());
                    list.addHead(entry);
                    break;
                case 2:
                    System.out.println("Enter entry value:");
                    LinkedListEntry entry1 = new LinkedListEntry<String>(scanner.next());
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
                    int index = scanner.nextInt();
                    try{
                        System.out.println("\nThat entries value is: " + list.getEntry(index).getValue());
                    } catch(IndexOutOfBoundsException e) {
                        System.out.println("\n" + e.getMessage());
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

    private static void priorityQueues() {

        PriorityQueue queue = new PriorityQueue();

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. inject");
            System.out.println("2. eject");
            System.out.println("3. number of entries");
            System.out.println("4. clear");
            System.out.println("5. update entry");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("Enter entry value:");
                    Object data = scanner.next();
                    System.out.println("Enter entry key:");
                    Object key = scanner.nextInt();
                    queue.inject(key, data);
                    break;
                case 2:
                    System.out.println("Object returned: " + queue.eject() + "\n");
                    break;
                case 3:
                    System.out.println("Number of entries = " + queue.getSize());
                    break;
                case 4:
                    queue.clear();
                    System.out.println("Queue successfully cleared!");
                    break;
                case 5:
                    System.out.println("Enter entry value:");
                    data = scanner.next();
                    System.out.println("Enter entry integer key:");
                    key = scanner.nextInt();
                    queue.updateKey(key, data);
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4 or 5.");
                    break;
            }

            queue.print();
            System.out.println("Do you want to continue using this priority queue? (y or n)");
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
                    table.insert(scanner.next(), scanner.next());
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

    private static void sets() {

        Set set = new Set();

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. add");
            System.out.println("2. remove");
            System.out.println("3. contains");
            System.out.println("4. clear");
            System.out.println("5. number of entries");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("Enter value to store:");
                    set.add(scanner.next());
                    break;
                case 2:
                    System.out.println("Enter value to remove:");
                    set.remove(scanner.next());
                    break;
                case 3:
                    System.out.println("Enter value to check:");
                    System.out.println("Is the value present: " + set.contains(scanner.next()));
                    break;
                case 4:
                    set.clear();
                    System.out.println("Clear complete!");
                    break;
                case 5:
                    System.out.println("Number of entries = " + set.getNumEntries());
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4 or 5.");
                    break;
            }

            set.print();
            System.out.println("Do you want to continue using this set? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void trees() {

        Tree father = new Tree("Father");
        Tree son = new Tree("Son");
        Tree daughter = new Tree("Daughter");
        Tree sonofson = new Tree("Son-of-Son");
        Tree daughterofson = new Tree("Daughter-of-Son");
        Tree sonofdaughter = new Tree("Son-of-Daughter");
        Tree daughterofdaughter = new Tree("Daughter-of-Daughter");

        Tree[] secondGen = new Tree[]{son, daughter};
        Tree[] sonThirdGen = new Tree[]{sonofson, daughterofson};
        Tree[] daughterThirdGen = new Tree[]{sonofdaughter, daughterofdaughter};

        father.setChildren(secondGen);
        son.setChildren(sonThirdGen);
        son.setParent(father);
        daughter.setChildren(daughterThirdGen);
        daughter.setParent(father);
        sonofson.setParent(son);
        daughterofson.setParent(son);
        sonofdaughter.setParent(daughter);
        daughterofdaughter.setParent(daughter);

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. print pre-order");
            System.out.println("2. print post-order");

            switch(scanner.nextInt()) {
                case 1:
                    printTreePreOrder(father);
                    break;
                case 2:
                    printTreePostOrder(father);
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1 or 2.");
                    break;
            }

            System.out.println("\nDo you want to continue using this tree? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    // Tree -> void
    // Given a tree print it in pre-order.
    // Strategy: Function Composition
    private static void printTreePreOrder(Tree tree) {

        if(tree == null) return;

        System.out.print(tree.getData() + " ");

        Tree[] children = tree.getChildren();
        if(children != null) {
            for (Tree child : children) {
                printTreePreOrder(child);
            }
        }
    }

    // Tree -> void
    // Given a tree print it in post-order.
    // Strategy: Function Composition
    private static void printTreePostOrder(Tree tree) {

        if(tree == null) return;

        Tree[] children = tree.getChildren();
        if(children != null) {
            for (Tree child : children) {
                printTreePostOrder(child);
            }
        }

        System.out.print(tree.getData() + " ");
    }

    private static void graphs() {

        int size = 13;

        Graph southAmerica = new Graph(size);
        String[] countries = new String[]{"Brazil", "French Guinea", "Suriname", "Guyana", "Venezuela", "Colombia",
        "Peru", "Ecuador", "Bolivia", "Paraguay", "Argentina", "Uruguay", "Chile"};

        System.out.println("\nYou'll be working with a graph representation of South America where:\n");
        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + countries[i]);
        }

        southAmerica.addEdge(0, 1);
        southAmerica.addEdge(1, 0);
        southAmerica.addEdge(0, 2);
        southAmerica.addEdge(2, 0);
        southAmerica.addEdge(0, 3);
        southAmerica.addEdge(3, 0);
        southAmerica.addEdge(0, 4);
        southAmerica.addEdge(4, 0);
        southAmerica.addEdge(0, 5);
        southAmerica.addEdge(5, 0);
        southAmerica.addEdge(0, 6);
        southAmerica.addEdge(6, 0);
        southAmerica.addEdge(0, 8);
        southAmerica.addEdge(8, 0);
        southAmerica.addEdge(0, 9);
        southAmerica.addEdge(9, 0);
        southAmerica.addEdge(0, 10);
        southAmerica.addEdge(10, 0);
        southAmerica.addEdge(0, 11);
        southAmerica.addEdge(11, 0);
        southAmerica.addEdge(1, 2);
        southAmerica.addEdge(2, 1);
        southAmerica.addEdge(2, 3);
        southAmerica.addEdge(3, 2);
        southAmerica.addEdge(3, 4);
        southAmerica.addEdge(4, 3);
        southAmerica.addEdge(4, 5);
        southAmerica.addEdge(5, 4);
        southAmerica.addEdge(5, 6);
        southAmerica.addEdge(6, 5);
        southAmerica.addEdge(5, 7);
        southAmerica.addEdge(7, 5);
        southAmerica.addEdge(6, 7);
        southAmerica.addEdge(7, 6);
        southAmerica.addEdge(6, 8);
        southAmerica.addEdge(8, 6);
        southAmerica.addEdge(8, 9);
        southAmerica.addEdge(9, 8);
        southAmerica.addEdge(6, 12);
        southAmerica.addEdge(12, 6);
        southAmerica.addEdge(12, 8);
        southAmerica.addEdge(8, 12);
        southAmerica.addEdge(8, 10);
        southAmerica.addEdge(10, 8);
        southAmerica.addEdge(9, 10);
        southAmerica.addEdge(10, 9);
        southAmerica.addEdge(10, 12);
        southAmerica.addEdge(12, 10);
        southAmerica.addEdge(10, 11);
        southAmerica.addEdge(11, 10);

        char ch;

        do {
            System.out.println("\nOperations\n");
            System.out.println("1. Add an edge");
            System.out.println("2. Remove an edge");
            System.out.println("3. Check if an edge exists");
            System.out.println("4. List out edges");
            System.out.println("5. List in edges");

            switch(scanner.nextInt()) {
                case 1:
                    System.out.println("\nEnter an integer for the from vertex.\n");
                    int i = scanner.nextInt();
                    System.out.println("\nEnter an integer for the to vertex.\n");
                    int j = scanner.nextInt();
                    southAmerica.addEdge(i, j);
                    System.out.println("Edge between " + countries[i] + " and " + countries[j] + " added.");
                    break;
                case 2:
                    System.out.println("\nEnter an integer for the from vertex.\n");
                    int k = scanner.nextInt();
                    System.out.println("\nEnter an integer for the to vertex.\n");
                    int l = scanner.nextInt();
                    southAmerica.removeEdge(k, l);
                    System.out.println("Edge between " + countries[k] + " and " + countries[l] + " removed.");
                    break;
                case 3:
                    System.out.println("\nEnter an integer for the from vertex.\n");
                    int m = scanner.nextInt();
                    System.out.println("\nEnter an integer for the to vertex.\n");
                    int n = scanner.nextInt();
                    System.out.println("Is there an edge between " + countries[m] + " and " + countries[n] + ": " +
                            southAmerica.hasEdge(m, n));
                    break;
                case 4:
                    System.out.println("\nEnter an integer for the vertex being examined.\n");
                    int o = scanner.nextInt();
                    List<Integer> edgesOut = southAmerica.outEdges(o);
                    if(edgesOut != null) {
                        System.out.println("Edges:");
                        for (Integer index : edgesOut) {
                            System.out.println(countries[o] + " to " + countries[index]);
                        }
                    } else {
                        System.out.println("There are no edges.");
                    }
                    break;
                case 5:
                    System.out.println("\nEnter an integer for the vertex being examined.\n");
                    int p = scanner.nextInt();
                    List<Integer> edgesIn = southAmerica.inEdges(p);
                    if(edgesIn != null) {
                        System.out.println("Edges:");
                        for (Integer index : edgesIn) {
                            System.out.println(countries[p] + " from " + countries[index]);
                        }
                    } else {
                        System.out.println("There are no edges.");
                    }
                    break;
                default:
                    System.out.println("Whoops, try again by typing 1, 2, 3, 4 or 5.");
                    break;
            }

            System.out.println("\nDo you want to continue using this graph? (y or n)");
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

        int[] sort = new int[listToSort.size()];

        for (int i = 0; i < sort.length; i++) {
            sort[i] = listToSort.get(i);
        }

        sort = (int[])sorter.mergeSort(sort);

        System.out.print("Our sorted list: ");
        for (int number : sort) {
            System.out.print(" " + number + " ");
        }
        System.out.print("\n\n");
    }

    private static void quickSort() {

        QuickSorter sorter = new QuickSorter();
        List<Integer> listToSort = new ArrayList<Integer>();

        char ch;

        do {
            System.out.println("\nEnter an integer to add it to a list to sort.\n");
            listToSort.add(scanner.nextInt());
            System.out.println("So far we have: " + listToSort);
            System.out.println("Do you want to continue entering integers? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

        int[] sort = new int[listToSort.size()];

        for (int i = 0; i < sort.length; i++) {
            sort[i] = listToSort.get(i);
        }

        sort = sorter.sort(sort, 0, sort.length - 1);

        System.out.print("Our sorted list: ");
        for (int number : sort) {
            System.out.print(" " + number + " ");
        }
        System.out.print("\n\n");
    }

    private static void dfs() {

        int size = 7;

        Graph world = new Graph(size);
        String[] continents = new String[]{"North America", "South America", "Europe", "Asia", "Africa", "Australia",
                "Antartica"};

        System.out.println("\nYou'll be working with an undirected graph representation of the world's continents " +
                "where:\n");
        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + continents[i]);
        }

        world.addEdge(0, 1);
        world.addEdge(1, 0);
        world.addEdge(2, 3);
        world.addEdge(3, 2);
        world.addEdge(3, 4);
        world.addEdge(4, 3);

        DepthExplorer dfs = new DepthExplorer(world);

        char ch;

        do {
            System.out.println("\nEnter an integer representing the continent in which you are interested:\n");

            int n = scanner.nextInt();
            dfs.dfs();
            int ccnum[] = dfs.getCcnum();
            int pre[] = dfs.getPre();
            int post[] = dfs.getPost();
            int ourComponent = ccnum[n];

            System.out.println("\nContinents reached: \n");

            for (int i = 0; i < ccnum.length; i++) {
                if(ccnum[i] == ourComponent) System.out.print(continents[i] + ", pre order " + pre[i] + ", post order "
                        + post[i] + "\n");
            }

            System.out.println("\nDo you want to continue exploring dfs? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void bfs() {

        int size = 7;

        Graph theWest = new Graph(size);
        String[] cities = new String[]{"San Francisco", "Sacramento", "Reno", "Bakersfield", "Los Angeles",
                "Los Vegas", "Catalina Island"};

        System.out.println("\nYou'll be working with an undirected graph representation of some locations in the " +
                "western US where:\n");
        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + cities[i]);
        }

        theWest.addEdge(0, 1, 95);
        theWest.addEdge(1, 0, 95);
        theWest.addEdge(0, 3, 290);
        theWest.addEdge(3, 0, 290);
        theWest.addEdge(0, 4, 409);
        theWest.addEdge(4, 0, 409);
        theWest.addEdge(1, 3, 271);
        theWest.addEdge(3, 1, 271);
        theWest.addEdge(1, 2, 133);
        theWest.addEdge(2, 1, 133);
        theWest.addEdge(2, 5, 445);
        theWest.addEdge(5, 2, 445);
        theWest.addEdge(3, 4, 112);
        theWest.addEdge(4, 3, 112);
        theWest.addEdge(3, 5, 291);
        theWest.addEdge(5, 3, 291);
        theWest.addEdge(4, 5, 275);
        theWest.addEdge(5, 4, 275);

        System.out.println("\nA breadth first search will tell you the distance between these locations by car.\n");

        BreadthExplorer bfs = new BreadthExplorer(theWest);

        char ch;

        do {
            System.out.println("\nEnter an integer representing the location from which you are traveling:\n");

            int n = scanner.nextInt();
            bfs.bfs(n);
            Integer dist[] = bfs.getDist();

            System.out.println("\nDistances from " + cities[n] + " to all other cities: \n");

            for (int i = 0; i < dist.length; i++) {
                if(dist[i] == Integer.MAX_VALUE) {
                    System.out.print(cities[i] + " is unreachable.\n");
                } else {
                    System.out.print(cities[i] + " : " + dist[i] + "\n");
                }
            }

            System.out.println("\nDo you want to continue exploring bfs? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void dijkstra() {

        int size = 5;

        Graph graph = new Graph(size);
        String[] nodes = new String[]{"A", "B", "C", "D", "E"};

        System.out.println("\nYou'll be working with a directed graph with five nodes where:\n");
        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + nodes[i]);
        }

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 5);
        graph.addEdge(4, 3, 1);

        char ch;
        DijkstraExplorer de = new DijkstraExplorer();

        do {
            System.out.println("\nEnter an integer representing the source node:\n");

            int n = scanner.nextInt();
            if(n < 0 || n >= size) {
                System.out.println("That's not a valid node!");
            } else {
                int dist[] = de.getDist(graph, n);
                int prev[] = de.getPrev(graph, n);

                System.out.println("\nDistances from " + nodes[n] + " to all other nodes: \n");
                for (int i = 0; i < dist.length; i++) {
                    if(dist[i] == Integer.MAX_VALUE) {
                        System.out.print(nodes[i] + " is unreachable from " + nodes[n] + "\n");
                    } else {
                        System.out.print(nodes[i] + " : " + dist[i] + "\n");
                    }
                }

                for (int i = 0; i < prev.length; i++) {
                    if(prev[i] != -1) {
                        System.out.print(nodes[i] + " is reachable through " + nodes[prev[i]] + "\n");
                    }
                }
            }

            System.out.println("\nDo you want to continue exploring Dijkstra searches? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void bellmanFord() {

        int size = 8;

        Graph graph = new Graph(size);
        String[] nodes = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};

        System.out.println("\nYou'll be working with a directed graph with eight nodes where:\n");
        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + nodes[i]);
        }

        graph.addEdge(0, 4, 2);
        graph.addEdge(1, 0, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 1, -2);
        graph.addEdge(5, 0, -4);
        graph.addEdge(5, 4, -1);
        graph.addEdge(6, 5, 1);
        graph.addEdge(7, 6, 8);
        graph.addEdge(7, 0, 10);

        char ch;
        BellmanFordExplorer bfe = new BellmanFordExplorer();

        do {
            System.out.println("\nEnter an integer representing the source node:\n");

            int n = scanner.nextInt();
            if(n < 0 || n >= size) {
                System.out.println("That's not a valid node!");
            } else {
                int dist[] = bfe.getDist(graph, n);
                int prev[] = bfe.getPrev(graph, n);

                System.out.println("\nDistances from " + nodes[n] + " to all other nodes: \n");
                for (int i = 0; i < dist.length; i++) {
                    if(dist[i] == Integer.MAX_VALUE) {
                        System.out.print(nodes[i] + " is unreachable from " + nodes[n] + "\n");
                    } else {
                        System.out.print(nodes[i] + " : " + dist[i] + "\n");
                    }
                }

                for (int i = 0; i < prev.length; i++) {
                    if(prev[i] != -1) {
                        System.out.print(nodes[i] + " is reachable through " + nodes[prev[i]] + "\n");
                    }
                }
            }

            System.out.println("\nDo you want to continue exploring Bellman-Ford searches? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }

    private static void aStar() {

        int size = 20;

        Graph romania = new Graph(size);
        String[] cities = new String[]{"Oradea", "Zerind", "Arad", "Timisoura", "Lugoj", "Mehadia", "Droheta", "Sibiu",
        "Rimnicu Vikea", "Cralova", "Fagaras", "Pitesti", "Bucharest", "Giurgiu", "Neamt", "Iasi", "Vaslui", "Urziceni",
        "Hirsova", "Eforie"};

        System.out.println("\nYou'll be working with a simplified map of Romania to find the best route to the " +
                "capital Bucharest where:\n");

        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + cities[i]);
        }

        romania.addEdge(0, 1, 71);
        romania.addEdge(1, 0, 71);
        romania.addEdge(0, 7, 151);
        romania.addEdge(7, 0, 151);
        romania.addEdge(1, 2, 75);
        romania.addEdge(2, 1, 75);
        romania.addEdge(2, 7, 140);
        romania.addEdge(7, 2, 140);
        romania.addEdge(2, 3, 118);
        romania.addEdge(3, 2, 118);
        romania.addEdge(3, 4, 111);
        romania.addEdge(4, 3, 111);
        romania.addEdge(4, 5, 70);
        romania.addEdge(5, 4, 70);
        romania.addEdge(5, 6, 75);
        romania.addEdge(6, 5, 75);
        romania.addEdge(6, 9, 120);
        romania.addEdge(9, 6, 120);
        romania.addEdge(7, 8, 80);
        romania.addEdge(8, 7, 80);
        romania.addEdge(7, 10, 99);
        romania.addEdge(10, 7, 99);
        romania.addEdge(8, 9, 146);
        romania.addEdge(9, 8, 146);
        romania.addEdge(8, 11, 97);
        romania.addEdge(11, 8, 97);
        romania.addEdge(9, 11, 138);
        romania.addEdge(11, 9, 138);
        romania.addEdge(10, 12, 211);
        romania.addEdge(12, 10, 211);
        romania.addEdge(11, 12, 101);
        romania.addEdge(12, 11, 101);
        romania.addEdge(12, 13, 90);
        romania.addEdge(13, 12, 90);
        romania.addEdge(12, 17, 85);
        romania.addEdge(17, 12, 85);
        romania.addEdge(14, 15, 87);
        romania.addEdge(15, 14, 87);
        romania.addEdge(15, 16, 92);
        romania.addEdge(16, 15, 92);
        romania.addEdge(16, 17, 142);
        romania.addEdge(17, 16, 142);
        romania.addEdge(17, 18, 98);
        romania.addEdge(18, 17, 98);
        romania.addEdge(18, 19, 86);
        romania.addEdge(19, 18, 86);

        romania.setHeuristic(0, 380);
        romania.setHeuristic(1, 374);
        romania.setHeuristic(2, 366);
        romania.setHeuristic(3, 329);
        romania.setHeuristic(4, 244);
        romania.setHeuristic(5, 241);
        romania.setHeuristic(6, 242);
        romania.setHeuristic(7, 253);
        romania.setHeuristic(8, 193);
        romania.setHeuristic(9, 160);
        romania.setHeuristic(10, 176);
        romania.setHeuristic(11, 100);
        romania.setHeuristic(12, 0);
        romania.setHeuristic(13, 77);
        romania.setHeuristic(14, 234);
        romania.setHeuristic(15, 226);
        romania.setHeuristic(16, 199);
        romania.setHeuristic(17, 80);
        romania.setHeuristic(18, 151);
        romania.setHeuristic(19, 161);

        char ch;
        AStarExplorer ase = new AStarExplorer();

        do {
            System.out.println("\nEnter an integer representing the source node:\n");

            int s = scanner.nextInt();
            if(s < 0 || s >= size) {
                System.out.println("That's not a valid node!");
            } else {
                int path[] = ase.getPath(romania, s, 12);
                if (path.length == 0) {
                    System.out.print("You're already in Bucharest!\n");
                } else {
                    System.out.println("\nShortest path from " + cities[s] + " to " + cities[12] + ": \n");
                    for (int city : path) {
                        if(city == 12) {
                            System.out.print(cities[city]);
                        } else {
                            System.out.print(cities[city] + " -> ");
                        }
                    }
                }
            }

            System.out.println("\nDo you want to continue exploring A* searches? (y or n)");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}
