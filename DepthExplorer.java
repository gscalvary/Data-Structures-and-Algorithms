package com.oliver;

public class DepthExplorer {

    private Graph g;
    private boolean[] visited;
    private int[] ccnum;
    private int[] pre;
    private int[] post;
    private int cc;
    private int clock;

    public DepthExplorer(Graph g) {

        this.g = g;
        int v = g.getNumVertices();
        visited = new boolean[v];
        ccnum = new int[v];
        pre = new int[v];
        post = new int[v];
        cc = clock = 0;
    }

    //  -> void
    // Explore the graph using depth first search.
    // Strategy: Function Composition
    public void dfs() {

        int n = visited.length;

        for(int i = 0; i < n; i++) {
            visited[i] = false;
            ccnum[i] = 0;
            pre[i] = 0;
            post[i] = 0;
        }

        cc = clock = 0;
        for(int i = 0; i < n; i++) {
            ++cc;
            if(!visited[i]) explore(i);
        }
    }

    // int -> void
    // EFFECT: Given an integer representing a vertex search its connected component recursively keeping track of each
    // vertex visited.
    // Strategy: General Recursion
    private void explore(int v) {

        visited[v] = true;
        previsit(v);

        for(Integer edge : g.outEdges(v)) {
            if(!visited[edge]) explore(edge);
        }

        postvisit(v);
    }

    // int -> void
    // EFFECT: Given an integer representing a vertex track to which connected component it belongs and when it was
    // first visited.
    // Strategy: Function Composition
    private void previsit(int v) {

        ccnum[v] = cc;
        pre[v] = clock++;
    }

    // int -> void
    // EFFECT: Given an integer representing a vertex track when it was last visited.
    // Strategy: Function Composition
    private void postvisit(int v) {

        post[v] = clock++;
    }

    //  -> int[]
    // Return an array of integers representing the connected components of the explorer's graph.
    // Strategy: Domain Knowledge
    public int[] getCcnum() {

        return ccnum;
    }

    //  -> int[]
    // Return an array of integers representing the pre-visit order of the explorer's graph.
    // Strategy: Domain Knowledge
    public int[] getPre() {

        return pre;
    }

    //  -> int[]
    // Return an array of integers representing the post-visit order of the explorer's graph.
    // Strategy: Domain Knowledge
    public int[] getPost() {

        return post;
    }
}
