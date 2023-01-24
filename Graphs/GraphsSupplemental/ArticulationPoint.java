package Graphs.GraphsSupplemental;

import java.util.*;


// it also uses Tarjen algo
public class ArticulationPoint {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 0));

        graph[4].add(new Edge(4, 3));
    }

    public static void getAP(ArrayList<Edge> graph[]) {
        int v = graph.length;
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean visit[] = new boolean[v];
        int time = 0;
        boolean ap[] = new boolean[v];

        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                dfs(graph, visit, dt, low, time, i, -1, ap);
            }
        }

        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
               System.out.println("AP: " + i);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean visit[], int dt[], int low[], int time, int curr, int par,
            boolean ap[]) {
        visit[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (Edge e : graph[curr]) {

            int neigh = e.dest;

            // 1
            if (neigh == par) {
                continue;
            }
            // 2
            else if (visit[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            // 3 - not visited
            else {
                dfs(graph, visit, dt, low, time, neigh, curr, ap);

                low[curr] = Math.min(low[curr], low[neigh]);

                // case 2,3
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;

            }

        }

        // case 1
        if (par == -1 && children > 1) {
            ap[curr] = true;

        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> group[] = new ArrayList[v];
        create(group);

        getAP(group);
    }

}
