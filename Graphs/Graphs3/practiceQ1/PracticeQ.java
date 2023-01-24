package Graphs.Graphs3.practiceQ1;
import java.util.*;

public class PracticeQ {
    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
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
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        
        graph[4].add(new Edge(4, 3));
    }

    // 1. detect cycle in an undirected graph using BFS..
    static class Pair{
        int n;  //node
        int par;  //parent

        public Pair(int n, int par){
            this.n = n;
            this.par = par;
        }
    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){  //node that not visited
                if(isCycleUtil(graph, visited, i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean visited[], int i ){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));   //starting node parent is not availble

        while(!q.isEmpty()){
            Pair curr = q.remove();
            visited[curr.n] = true;

            for (Edge e : graph[curr.n]) {
                if(!visited[e.dest]){
                    q.add(new Pair(e.dest, curr.n));
                }
                else if(visited[e.dest]){
                    if(e.dest != curr.par){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(isCycle(graph));
        
    }
}
