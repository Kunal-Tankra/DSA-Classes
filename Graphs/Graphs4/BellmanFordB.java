package Graphs.Graphs4;

import java.util.ArrayList;

public class BellmanFordB {
    // shortest path from the src to all vertices(negative edges)....
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // create
    public static void create(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }


    // O(vE)
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        // initialy distences
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length; // total vertices

        // algo
        for (int i = 0; i < V - 1; i++) {  //O(V)
            // edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt <dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for (int i : dist) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        create(graph);

        bellmanFord(graph, 0);
    }
}