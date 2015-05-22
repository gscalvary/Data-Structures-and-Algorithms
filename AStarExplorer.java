package com.oliver;

import java.util.ArrayList;

public class AStarExplorer {

    // Graph, int, int -> int[]
    // EFFECT: Given an integer representing a source vertex and an integer representing a destination vertex calculate
    // the shortest distance from the source vertex to the destination vertex in the graph optimally and record a
    // breadcrumb trail of nodes passed through along the way.
    // INVARIANT: The input graph must have edges marked with edges of length >= 0.  The input graph should also
    // have heuristics set for each vertex or else this algorithm will just behave like a less than optimal uniform
    // cost search.
    // Strategy: Function Composition
    public int[] getPath(Graph g, int s, int d) {

        // Check input.
        int size = g.getNumVertices();
        if(s < 0 || s >= size || d < 0 || d >= size) return null;

        // Allocate memory.
        int[] dist = new int[size];
        int[] prev = new int[size];
        PriorityQueue frontier = new PriorityQueue();

        // Initializations.
        for(int i = 0; i < size; i++) {
            if(i == s) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
            frontier.inject(i, dist[i]);
            prev[i] = -1;
        }

        // Calculate the shortest path.
        while(frontier.getSize() != 0) {
            // Check if our next node to search is our destination.
            Integer node = (Integer)frontier.eject();
            if(node.equals(d)) return buildSolution(prev, s, d);
            // Take a look at its children.
            for(int child : g.outEdges(node)) {
                // Adding a value to Integer.MAX_VALUE yields a negative number hence the below check.
                int newDistance;
                if(dist[node] == Integer.MAX_VALUE) {
                    newDistance = Integer.MAX_VALUE;
                } else {
                    newDistance = dist[node] + g.getEdge(node, child).getLength();
                }
                if(dist[child] > newDistance) {
                    dist[child] = newDistance;
                    prev[child] = node;
                    frontier.updateKey(child, dist[child] + g.getHeuristic(child));
                }
            }
        }

        return null;
    }

    // int[], int, int -> int[]
    // Given an array of integers representing vertices that have their previous vertices along a shortest path noted
    // build an array of integers that represents an ordered list of the shortest path between a given source vertex
    // and a given destination vertex.
    private int[] buildSolution(int[] prev, int s, int d) {

        int index = d;
        int p;
        ArrayList<Integer> build = new ArrayList<Integer>();
        build.add(d);

        while(true) {
            if(index == -1) return new int[]{};
            p = prev[index];
            build.add(0, p);
            if(p == s) {
                int[] solution = new int[build.size()];
                for(int i = 0; i < build.size(); i++) {
                    solution[i] = build.get(i);
                }
                return solution;
            } else {
                index = p;
            }
        }
    }
}
