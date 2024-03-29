package Graphs.Graphs1;
// BFS - breadth first search

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Traversal {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge( int s, int d, int w){
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

    public static void BSF(ArrayList<Edge> graph[]){  //O(v+E)
        // to track visited or not
        boolean visited[] = new boolean[graph.length];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);  //initialy source = 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){  //already not visited 
                visited[curr] = true;
                System.out.print(curr+ " ");
                
                for (Edge e : graph[curr]) {
                    q.add(e.dest);
                }
            }
            
        }
    }

    // dfs - depth first search...  O(V + E)
    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]){
        System.out.print(curr + " ");
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if(!visited[e.dest]){

                DFS(graph, e.dest, visited);
            }
        }

    }

    public static void main(String[] args) {
        int v = 7;
       @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        
        // BSF(graph);
        DFS(graph, 0, new boolean[v]);
    }
}
