package Graphs.Graphs5;



public class DisjointSet {  //O(1)
    static int n = 7;
    static int par[] = new int[n]; //parents
    static int rank[] = new int[n];

    // initialy
    public static void init(){
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    // O(1)
    public static int find(int x){  //it returns parent
        if(x == par[x]){
            return x;
        }

        //path compression
        return par[x] = find(par[x]);   // it also works wihout par[x] = 
    }

    // O(1)
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

    

    public static void main(String[] args) {
        init();

        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        union(1, 5);

        


        
    }
    
}
