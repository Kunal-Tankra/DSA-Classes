package Graphs.Graphs5.practiceQ2;

public class ClosedIslands {
    // find number of closed islands...
    public static void findIsland(int mat[][], int n, int m){
        boolean visit[][] = new boolean[n][m];
        int islandsCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] != 0 && !visit[i][j]){
                    if(isIsland(mat, visit, i, j, n, m)){
                        islandsCount++;
                    }
                }
                
            }
        }

        System.out.println("islands: " + islandsCount);
    }

    public static boolean isIsland(int mat[][], boolean visit[][], int i, int j, int n, int m){
        if((i<=0 || j<=0 || i>=n-1 || j>= m-1) && mat[i][j] ==1 ){
            return false;
        }
       

        if(mat[i][j] ==0 || visit[i][j]){
            return true;
        }

       

            visit[i][j] = true;
            
            // up
            boolean up = isIsland(mat, visit, i-1, j, n, m);
            // down
            boolean down = isIsland(mat, visit, i+1, j, n, m);
            // left
            boolean left = isIsland(mat, visit, i, j-1, n, m);
            // right
            boolean right = isIsland(mat, visit, i, j+1, n, m);

            return up || down || left || right;
        
       

    }

    public static void main(String[] args) {
        int n = 5;
        int m = 8;
        int mat[][] = {
        {0, 0, 0, 0, 0, 1, 0, 1},
        {0, 1, 1, 1, 1, 0, 0, 1},
        {0, 1, 0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1}};
        findIsland(mat, n, m);                
    }
}
