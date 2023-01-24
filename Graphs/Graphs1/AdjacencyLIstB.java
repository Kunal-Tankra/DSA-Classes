package Graphs.Graphs1;

import java.util.*;

public class AdjacencyLIstB {
    public static class Edge{
        int src;  //source
        int dest;  //destination
        int wt;  //weight

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        int v = 5;  //verteces of nodes
        @SuppressWarnings("unchecked")   //to remove warning

        ArrayList<Edge> graph[] = new ArrayList[v];

        // intialy graph[0], .... graph[v-1] are --> null so
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        
        // 3 - vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));
        
        // 4- vertex
        graph[4].add(new Edge(4, 2, 2));

        // to get neighbour of 2
        for (Edge elem : graph[2]) {
            System.out.println(elem.dest + " ");
        }
        
    }
}
