package Graphs.Graphs5.practiceQ2;
import java.beans.Visibility;
import java.util.*;

// find the mother vertex
public class MotherVertex {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 4));
        // graph[6].add(new Edge(6, 0));

        

    }

    // find mother
    public static int findMother(ArrayList<Edge> graph[] ){
        boolean vis[] = new boolean[graph.length];
        int x = -1;
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                DFSUtil(graph, vis,i);
                x =  i;
            }
        }

         vis= new boolean[graph.length];
         DFSUtil(graph, vis, x);

         for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                return -1;
            }
         }
        return x;
    }

    public static void DFSUtil(ArrayList<Edge> graph[],  boolean vis[],int curr){
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if(!vis[e.dest]){
              DFSUtil(graph, vis, e.dest);
            }
        }

       
    }

    public static void main(String[] args) {
        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int mother = findMother(graph);
        System.out.println(mother);
    }
}
