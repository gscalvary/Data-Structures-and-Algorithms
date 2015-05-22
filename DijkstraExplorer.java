package com.oliver;

public class DijkstraExplorer {

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
    // INVARIANT: The input graph must have edges marked with edges of length >= 0.
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

        PriorityQueue H = new PriorityQueue();

        for(int i = 0; i < size; i++) {
            H.inject(i, dist[i]);
        }

        // Calculate the shortest distances.
        while(H.getSize() != 0) {
            // Get the vertex with the shortest distance from s.
            Integer u = (Integer)H.eject();
            // Look at all the edges leading from u.
            for(Integer v : g.outEdges(u)) {
                // Adding a value to Integer.MAX_VALUE yields a negative number hence the below check.
                int newDistance;
                if(dist[u] == Integer.MAX_VALUE) {
                    newDistance = Integer.MAX_VALUE;
                } else {
                    newDistance = dist[u] + g.getEdge(u, v).getLength();
                }
                if(dist[v] > newDistance) {
                    dist[v] = newDistance;
                    prev[v] = u;
                    H.updateKey(v, dist[v]);
                }
            }
        }
    }
}
