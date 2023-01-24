package Graphs.GraphsSupplemental;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void create(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void kosaraju(ArrayList<Edge> graph[]) {
        int v = graph.length;

        // step 1- topsort
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[v];

        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                topSort(graph, i, visit, s);
            }
        }

        // step 2 - transpose
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            visit[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                // make opposite
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3- dfs with stack and tranpose
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visit[curr]) {
                dfs(transpose, curr, visit);
                System.out.println();
            }
        }

    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean visit[], Stack<Integer> s) {
        visit[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visit[e.dest]) {
                topSort(graph, e.dest, visit, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visit[]) {
        visit[curr] = true;
        System.out.print(curr + " ");

        for (Edge e : graph[curr]) {
            if (!visit[e.dest]) {
                dfs(graph, e.dest, visit);
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
       @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        create(graph);

        kosaraju(graph);
    }
}
