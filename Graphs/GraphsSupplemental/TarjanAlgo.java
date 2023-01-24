package Graphs.GraphsSupplemental;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class TarjanAlgo {
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

    // find bridge..
    public static void tarjanBridge(ArrayList<Edge> graph[]){
        int v = graph.length;
        int dt[] = new int[v];   //discovery time
        int low[] = new int[v];   //lowest discovery time of all neighbours (including node)
        boolean visit[] = new boolean[v];
        int time = 0;

        for (int i = 0; i < v; i++) {
            if(!visit[i]){
                dfs(graph, visit, dt, low,i, -1, time);   //parent of starting node is -1
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean visit[], int dt[], int low[] ,int curr, int par, int time){
        visit[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (Edge e : graph[curr]) {
            // 1
            if(e.dest == par){
                continue;
            }

            // 2
            else if(!visit[e.dest]){
                dfs(graph, visit, dt, low, e.dest, curr, time);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // bridge check
                if(dt[curr] < low[e.dest]){
                    System.out.println("Bridge: " + curr + " ---- " + e.dest);
                }

            }

            // 3
            else if(visit[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        create(graph);
        tarjanBridge(graph);
    }
    
}
