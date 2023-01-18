package Graphs.Graphs3;
import java.util.*;

public class AllPaths {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }

    }

    // create graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));


    }

    // all paths from src to target....
    public static void allPaths(ArrayList<Edge> graph[], String path, int src, int target){
        if(src == target){
            System.out.println(path + src);
            return;
        }

        for (Edge e : graph[src]) {
            allPaths(graph, path+ src, e.dest, target);
        }
    }

    public static void main(String[] args) {
        int v = 7;  //size of graph
        @SuppressWarnings("unchecked")
         ArrayList<Edge> graph[] = new ArrayList[v];
 
         createGraph(graph);
        allPaths(graph, "", 5, 1);
    }
}
