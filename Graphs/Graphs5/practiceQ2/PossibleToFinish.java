package Graphs.Graphs5.practiceQ2;

import java.beans.Visibility;
import java.util.*;

// find whether it is possible to finish all tasks or not
public class PossibleToFinish {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int arr[][]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];

            graph[b].add(new Edge(b, a));
        }
    }

    // if  possible to finish all tasks - no cycle
    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean stack[] = new boolean[graph.length];
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                if(isCycleUtil(graph, stack, visited, i)){
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean stack[], boolean visited[], int curr){
        visited[curr] = true;
        stack[curr] = true;

        for (Edge e : graph[curr]) {
            if(stack[e.dest]){
                return true;
            }

            if(!visited[e.dest]){
                if(isCycleUtil(graph, stack, visited, e.dest)){
                    return true;
                }
            }
            
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0}};

        int v = 2;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph, arr);

        // !isCycle -> can finish the all tasks
        System.out.println(!isCycle(graph));
        
    }
}
