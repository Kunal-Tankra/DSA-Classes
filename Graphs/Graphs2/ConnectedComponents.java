package Graphs.Graphs2;
import java.beans.Visibility;
import java.util.*;

import javax.sound.midi.VoiceStatus;

// ------------ this is real treversal for multiple components-- it use dfs and bfs---------

public class ConnectedComponents {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // create graph
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            
        }
        
       

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(5, 5, 1));
    }

    // bfs
    public static void BFS(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                bfsUtil(graph, visited, i);
            }    
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[], int i){
        Queue<Integer> q = new LinkedList<>();
        // q.add(0);
        q.add(i);  //should be --> i

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(curr + " ");

                for (Edge e : graph[curr]) {
                    q.add(e.dest);
                }
            }
        }
    }


    // dfs...
    public static void DFS(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                dfsUtil(graph, visited, i);

            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean visited[], int i){
        System.out.print(i+ " ");
        visited[i] = true;

        for (Edge e : graph[i]) {
            if(!visited[e.dest]){
                dfsUtil(graph, visited, e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;
       @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        
        

        // BFS(graph);
        DFS(graph);
    }
}
