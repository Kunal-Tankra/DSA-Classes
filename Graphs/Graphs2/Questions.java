package Graphs.Graphs2;


import java.util.*;

public class Questions {
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

        
        // directed graph
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));
        
        //topological sorting..
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    // detedt cycle......
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                // initialy parent is -1
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                    // cycle exists in one of the parts
                }
            }
        }

        return false;
    }

    // O(V+E)
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int parent) {

        visited[curr] = true;

        for (Edge e : graph[curr]) {
            // case -3
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, visited, e.dest, curr)) {

                    return true;
                }
            } else if (visited[e.dest] && e.dest != parent) { // case -1
                return true;
            }
        }

        return false;
    }

    // is Bipartite...
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];

        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // initialy no color
        }

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!isBipartiteUtil(graph, color, i)) { // if a graph is false then return false otherwise check more
                                                         // garphs
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge> graph[], int color[], int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (Edge e : graph[curr]) {
                // case 1
                if (color[curr] == color[e.dest]) {
                    return false;
                } else if (color[e.dest] == -1) { // case 3
                    q.add(e.dest);

                    // if(color[curr]==0){
                    // color[e.dest] = 1;
                    // }
                    // else if(color[curr]== 1){
                    // color[e.dest] = 0;
                    // }

                    color[e.dest] = color[curr] == 0 ? 1 : 0;
                }
            }

        }

        return true;
    }

    // cycle detections in directed graph
    public static boolean isCycle_directed(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        boolean stack[] = new boolean[graph.length];  //use as stack

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(isCycle_directedUtil(graph, visited, stack, i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle_directedUtil(ArrayList<Edge> graph[], boolean visited[], boolean stack[], int i){
        visited[i] = true;
        stack[i] = true;

        for (Edge e : graph[i]) {
            if(stack[e.dest]){
                return true;
            }
            else if(!visited[e.dest] && isCycle_directedUtil(graph, visited, stack, e.dest)){
                return true;

            }
        }
        
        stack[i] = false; // because it is like recursion stack and after backtrack it should be false
        return false;
    }

    // topological sorting....  O(v+E)
    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean vist[] = new boolean[graph.length];

        Stack<Integer> s = new Stack<>();  //to store nodes

        for (int i = 0; i < graph.length; i++) {
            if(!vist[i]){
                topologicalSortUtil(graph, vist, s, i); //modified dfss
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge> graph[], boolean vist[], Stack<Integer> s, int curr){
        vist[curr] = true;

        for (Edge e : graph[curr]) {
            if(!vist[e.dest]){
                topologicalSortUtil(graph, vist, s, e.dest);
            }
        }

        s.push(curr);
    }

    public static void main(String[] args) {
        // int v = 7;  //size of graph
        int v = 6;  //size of graph
        @SuppressWarnings("unchecked")
         ArrayList<Edge> graph[] = new ArrayList[v];
 
         createGraph(graph);

        //  boolean isCycle =  isCycle_directed(graph);
        //  System.out.println(isCycle);

        topologicalSort(graph);
    }
}
