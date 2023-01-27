package Graphs.Graphs5;
import java.util.*;


// connecting cities with min cost..........
// prims algo
public class ConnectCities {
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
    public static void create(ArrayList<Edge> graph[], int cities[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[0].length; j++) {
                if(cities[i][j] != 0){ //not self 

                    Edge e = new Edge(i, j, cities[i][j]);
                    graph[i].add(e);
                }
            }
        }

        
    }

    // pair of vertex and cost
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; //ascending
        }
    }

    public static void minCost(int cities[][], int src ){
        int v = cities.length;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        create(graph, cities);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        boolean visit[] = new boolean[graph.length];

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visit[curr.v]){

                visit[curr.v] = true;
                finalCost+= curr.cost;
                
                for (Edge e : graph[curr.v]) {
                    pq.add(new Pair(e.dest, e.wt));
                }
            }

        }

        System.out.println(finalCost);

    }

    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},
                            {1,0,5,0,7},
                            {2,5,0,6,0},
                            {3,0,6,0,0},
                            {4,7,0,0,0}};

        minCost(cities, 0);

    }
}
