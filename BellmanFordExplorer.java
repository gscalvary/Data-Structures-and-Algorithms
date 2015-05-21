package com.oliver;

public class BellmanFordExplorer {

    private int[] dist;
    private int[] prev;

    // Graph, int -> int[]
    // Return a list of the shortest distances from a source vertex s to all other vertices reachable in the given
    // graph g.
    // Strategy: Function Composition
    public int[] getDist(Graph g, int s) {

        shortestPath(g, s);
        return dist;
    }

    // Graph, int -> int[]
    // Return a list of the vertices representing the shortest path through the given graph g from source vertex s.
    // Strategy: Function Composition
    public int[] getPrev(Graph g, int s) {

        shortestPath(g, s);
        return prev;
    }

    // Graph, int -> void
    // EFFECT: Given an integer representing a source vertex calculate the shortest distance from the
    // source vertex to every other vertex in the graph and record a breadcrumb trail to follow.
    // INVARIANT: The input graph must not contain negative cycles.
    // Strategy: Function Composition
    private void shortestPath(Graph g, int s) {

        // Initializations.
        int size = g.getNumVertices();
        dist = new int[size];
        prev = new int[size];

        for(int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }

        if(s >= size) return;

        dist[s] = 0;

        // Calculate the shortest distances by updating all edges one time less than the number of vertices.
        for (int i = 0; i < size - 1; i++) {
            // Iterate through all edges.
            for (int u = 0; u < size; u++) {
                for(int v : g.outEdges(u)) {
                    dist[v] = Math.min(dist[v], edgeIncrement(g, u, v));
                }
            }
        }
    }

    // Graph, int, int -> int
    // Given a graph and two integers representing two vertices u and v return the length to v through u.
    // Strategy: Function Composition
    private int edgeIncrement(Graph g, int u, int v) {

        if(dist[u] == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return dist[u] + g.getEdge(u, v).getLength();
        }
    }
}
