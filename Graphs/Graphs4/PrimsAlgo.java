package Graphs.Graphs4;

import java.util.*;

import javax.print.attribute.standard.PrintQuality;
import javax.swing.text.html.ParagraphView;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class PrimsAlgo {
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        
    }

    static class Pair implements Comparable<Pair>{
        int v;  //value of vertex
        int cost;

        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void MST(ArrayList<Edge> graph[] , int src){
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); //initialy cost or wt = 0

        int finalMinCost = 0;
        ArrayList<Integer> MST_Edges = new ArrayList<>();

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visit[curr.v]){
                visit[curr.v] = true;
                finalMinCost += curr.cost;
                MST_Edges.add(curr.cost);
                
                // all edges
                for (Edge edge : graph[curr.v]) {
                    pq.add(new Pair(edge.dest, edge.wt));
                }
            }
        }

        for (int i = 0; i < MST_Edges.size(); i++) {
            if(i == MST_Edges.size()-1){

                System.out.print( MST_Edges.get(i) + " = ");
            }
            else{
                System.out.print( MST_Edges.get(i) + " + ");

            }
            
        }
        System.out.println(finalMinCost);
    }

    public static void main(String[] args) {
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        create(graph);

        MST(graph, 0);
    }
}
