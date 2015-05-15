package com.oliver;

public class Edge {

    private int length;

    public Edge(int length) {

        this.length = length;
    }

    public Edge() {

        length = 1;
    }

    //  -> int
    // Return the length of the edge.
    // Strategy: Domain Knowledge
    public int getLength() {

        return length;
    }

    // int -> void
    // Set the length of the edge.
    // Strategy: Domain Knowledge
    public void setLength(int length) {

        this.length = length;
    }
}
