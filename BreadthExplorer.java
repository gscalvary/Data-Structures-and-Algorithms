package com.oliver;

public class BreadthExplorer {

    private Graph g;
    private Integer[] dist;

    public BreadthExplorer(Graph g) {

        this.g = g;
        int v = g.getNumVertices();
        dist = new Integer[v];
    }

    // int -> void
    // EFFECT: Given a vertex explore the graph using breadth first search setting the "distance" of each reachable
    // vertex from the input vertex.
    // Strategy: Function Composition
    public void bfs(int s) {

        for(int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        if(s >= g.getNumVertices()) return;

        dist[s] = 0;
        Queue Q = new Queue();
        Q.inject(s);

        while (Q.getSize() > 0) {
            int u = (Integer)Q.eject();
            for(int v : g.outEdges(u)) {
                if(dist[v] == Integer.MAX_VALUE) {
                    Q.inject(v);
                    dist[v] = dist[u] + g.getEdge(u, v).getLength();
                }
            }
        }
    }

    //  -> void
    // Return the distances.
    // Strategy: Domain Knowledge
    public Integer[] getDist() {

        return dist;
    }
}
