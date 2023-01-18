package Graphs.Graphs3;
import java.util.*;

public class DijkstraAlgo {
    // shortest path from the source to all vertices..
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // create
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4,3));

        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));

        

    }

    // pair of node and itra shortest path distence
    static class Pair implements Comparable<Pair>{
        int n;  //node
        int path; //distence

        public Pair(int n, int p){
            this.n = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;  //making comparable with shortest path for pq
        }
    }

    public static void Dijkstra(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];  // to store distences

        for (int i = 0; i < dist.length; i++) {
            if(i != src){                      //don't add in src bcz its distence is --> 0
                dist[i] = Integer.MAX_VALUE;   //initialy - infinite
            }
        }

        boolean visit[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!visit[curr.n]){  //not visited
                visit[curr.n] = true;

                for (Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;

                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int d : dist) {   //print all distences from src to that node
            System.out.print(d + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6; //size
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        Dijkstra(graph, 0);

    }
}
