package Graphs.Graphs5;

import java.util.*;

public class KruskalsAlgo {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest =d ;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }


    }

    // we want only arraylist of edges so not going to make graph[]
    // arraylist<Edge>
    public static void create(ArrayList<Edge> edges){
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // disjointset
    static int n = 4;  //verteces
    static int par[] = new int[n]; //parents
    static int rank[] = new int[n];

    // initialy
    public static void init(){
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x){  //it returns parent
        if(x == par[x]){
            return x;
        }

        //path compression
        return par[x] = find(par[x]);   // it also works wihout par[x] = 
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

    // kruskalsAlgo.. o(V+ElogE)
    public static void kruskalsMST(ArrayList<Edge> edges, int v){//v-> verteces
        init();
        Collections.sort(edges); //O(ElogE)

        int mstCost = 0;
        int count = 0;

        for (int i = 0; count< v-1; i++) {  //O(V)
            Edge e = edges.get(i);

            int parA = find(e.src); //src = a
            int parB = find(e.dest); // dest = b

            if(parA != parB){
                union(parA, parB);
                mstCost += e.wt;
                count++; // atteched 
            }
        }

        System.out.println(mstCost);

    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        create(edges);
        kruskalsMST(edges, v);
    }
}
