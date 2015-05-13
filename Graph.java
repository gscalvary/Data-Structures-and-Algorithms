package com.oliver;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int n;
    boolean[][] a;

    public Graph(int n) {

        this.n = n;
        a = new boolean[n][n];
    }

    // int, int -> void
    // EFFECT: Given a source vertex and a destination vertex add an edge between them.
    // Strategy: Domain Knowledge
    public void addEdge(int i, int j) {

        if(i >= 0 && i < n && j >= 0 && j < n) a[i][j] = true;
    }

    // int, int -> void
    // EFFECT: Given a source vertex and a destination vertex remove an edge between them.
    // Strategy: Domain Knowledge
    public void removeEdge(int i, int j) {

        if(i >= 0 && i < n && j >= 0 && j < n) a[i][j] = false;
    }

    // int, int -> boolean
    // Given a source vertex and a destination vertex indicate whether there is an edge between them.
    // Strategy: Domain Knowledge
    public boolean hasEdge(int i, int j) {

        // This returns false if either i or j values are outside of the range 0 to n inclusive, if they are within
        // range it in effect returns the hasEdge boolean.
        return (i >= 0 && i < n && j >= 0 && j < n) && a[i][j];
    }

    // int -> List<Integer>
    // Given a vertex return all the vertices led to by edges out of it.
    // Strategy: Structural Decomposition
    public List<Integer> outEdges(int i) {

        if(i < 0 || i >= n) return null;

        List<Integer> edges = new ArrayList<Integer>();

        for (int j = 0; j < n; j++) {
            if(a[i][j]) edges.add(j);
        }

        return edges;
    }

    // int -> List<Integer>
    // Given a vertex return all the vertices from which edges lead into it.
    // Strategy: Structural Decomposition
    public List<Integer> inEdges(int i) {

        if(i < 0 || i >= n) return null;

        List<Integer> edges = new ArrayList<Integer>();

        for (int j = 0; j < n; j++) {
            if(a[j][i]) edges.add(j);
        }

        return edges;
    }
}