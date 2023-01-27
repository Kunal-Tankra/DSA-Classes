package Graphs.Graphs5.practiceQ2;

import java.util.*;

// find the order of char in the alien language....
public class AlienDictionary {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(String dict[], ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String w1 = dict[i];
            String w2 = dict[i + 1];

            for (int j = 0; j < w1.length(); j++) {
                char first = w1.charAt(j);
                char sec = w2.charAt(j);

                if (first != sec) {
                    int ind = first - 'a';
                    graph[ind].add(new Edge(first, sec));
                    break;
                }
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean visi[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < visi.length; i++) {
            if(!visi[i]){
                topSortUtil(graph, visi, s, i);
            }
        }

        while(!s.isEmpty()){

            System.out.print((char)( s.pop() + (int)'a') + " ");
        }
        System.out.println();

    }

    public static void topSortUtil(ArrayList<Edge> graph[],boolean visi[],  Stack<Integer> s, int curr){
        visi[curr] = true;

        for (Edge e : graph[curr]) {
            
            int ind = e.dest -'a';
            if(!visi[ind]){
                topSortUtil(graph, visi, s, ind);
            }
        }

        s.add(curr);
    }

    public static void main(String[] args) {
        int n = 5; // size of dict
        int k = 3; // startind alphabets
        String dict[] = { "caa", "aaa", "aab" };

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[k];

        createGraph(dict, graph);

        topSort(graph);

    }
}
