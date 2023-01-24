package Graphs.Graphs3;
import java.util.*;

public class TopologicalSortBFS {
    
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }

    }

    // create graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));


    }

    // topological sort with bfs..
    
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        
        // calculate in-degrees of all nodes
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        // initialy add in q
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        // bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {
                indeg[e.dest]--;

                if(indeg[e.dest]== 0){
                    q.add(e.dest);
                }
            }


        }

        System.out.println();


    }
    
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    
    public static void main(String[] args) {
        int v = 6;  //size of graph
        @SuppressWarnings("unchecked")
         ArrayList<Edge> graph[] = new ArrayList[v];
 
         createGraph(graph);

         topSort(graph);
    }
}
