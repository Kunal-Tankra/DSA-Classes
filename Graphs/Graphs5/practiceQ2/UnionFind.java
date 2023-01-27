package Graphs.Graphs5.practiceQ2;

import java.util.*;

public class UnionFind {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static int n = 10;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }

        return par[x]= find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]< rank[parB]){
            par[parA] = parB;
        }
        else{
            par[parB] = parA;

        }
    }

    
    public static boolean cycle(ArrayList<Edge> edges){
        HashSet<String> hs = new HashSet<>();

        for (Edge e : edges) {
            int a = e.src;
            int b = e.dest;

            String n = "" + a + b;
            String rev = "" + b + a;
            
            

            // check if edge is already in hs -- we need to go only one time from that edge
            if(!(hs.contains(n) || hs.contains(rev))){
                hs.add(n);

                int parA = find(a);
                int parB = find(b);

                if(parA == parB){
                    return true;
                }
                else{
                    union(parA, parB);
                }

            }



        }

        return false;


    }

    public static void main(String[] args) {
        init();

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 5));
        edges.add(new Edge(1, 9));
        edges.add(new Edge(2, 7));
        edges.add(new Edge(2, 5));
        edges.add(new Edge(5, 1));
        edges.add(new Edge(5, 9));
        edges.add(new Edge(7, 2));
        edges.add(new Edge(9, 1));
        edges.add(new Edge(9, 5));

        System.out.println(cycle(edges));

       
    }
    
}
