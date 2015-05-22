package com.oliver;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int n;
    Edge[][] edges;
    int[] heuristic;

    public Graph(int n) {

        this.n = n;
        edges = new Edge[n][n];
        heuristic = new int[n];

        for(int i = 0; i < n; i++) {
            heuristic[i] = 0;
        }
    }

    public Graph(int n, int[] heuristic) {

        this.n = n;
        edges = new Edge[n][n];
        this.heuristic = heuristic;
    }

    // int, int -> void
    // EFFECT: Given a source vertex and a destination vertex add an edge between them.
    // Strategy: Domain Knowledge
    public void addEdge(int i, int j) {

        if(i >= 0 && i < n && j >= 0 && j < n) edges[i][j] = new Edge();
    }

    // int, int, int -> void
    // EFFECT: Given a source vertex, a destination vertex and a length add an edge between them.
    // Strategy: Domain Knowledge
    public void addEdge(int i, int j, int length) {

        if(i >= 0 && i < n && j >= 0 && j < n) edges[i][j] = new Edge(length);
    }

    // int, int -> void
    // EFFECT: Given a source vertex and a destination vertex remove an edge between them.
    // Strategy: Domain Knowledge
    public void removeEdge(int i, int j) {

        if(i >= 0 && i < n && j >= 0 && j < n) edges[i][j] = null;
    }

    // int, int -> Edge
    // Given a source vertex and a destination vertex return the edge between them.
    // Strategy: Domain Knowledge
    public Edge getEdge(int i, int j) {

        if(i >= 0 && i < n && j >= 0 && j < n) {
            return edges[i][j];
        } else {
            return null;
        }
    }

    // int, int -> boolean
    // Given a source vertex and a destination vertex indicate whether there is an edge between them.
    // Strategy: Domain Knowledge
    public boolean hasEdge(int i, int j) {

        // This returns false if either i or j values are outside of the range 0 to n inclusive, if they are within
        // range it in effect returns the hasEdge boolean.
        return (i >= 0 && i < n && j >= 0 && j < n) && (edges[i][j] != null);
    }

    // int -> List<Integer>
    // Given a vertex return all the vertices led to by edges out of it.
    // Strategy: Structural Decomposition
    public List<Integer> outEdges(int i) {

        if(i < 0 || i >= n) return null;

        List<Integer> vertices = new ArrayList<Integer>();

        for (int j = 0; j < n; j++) {
            if(edges[i][j] != null) vertices.add(j);
        }

        return vertices;
    }

    // int -> List<Integer>
    // Given a vertex return all the vertices from which edges lead into it.
    // Strategy: Structural Decomposition
    public List<Integer> inEdges(int i) {

        if(i < 0 || i >= n) return null;

        List<Integer> vertices = new ArrayList<Integer>();

        for (int j = 0; j < n; j++) {
            if(edges[j][i] != null) vertices.add(j);
        }

        return vertices;
    }

    //  -> int
    // Return the number of vertices in the graph.
    // Strategy: Domain Knowledge
    public int getNumVertices() {

        return n;
    }

    // int -> int
    // Given a vertex represented by an integer return the heuristic for that vertex.
    // Strategy: Structural Decomposition
    public int getHeuristic(int i) {

        if(i < 0 || i >= this.n) {
            return 0;
        } else {
            return heuristic[i];
        }
    }

    // int, int -> void
    // EFFECT: Given a vertex represented by an integer and an integer heuristic set the heuristic for that vertex.
    // Strategy: Structural Decomposition
    public void setHeuristic(int i, int h) {

        if(i >= 0 && i < this.n) {
            heuristic[i] = h;
        }
    }
}