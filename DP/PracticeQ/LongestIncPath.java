package DP.PracticeQ;

import java.util.Arrays;

public class LongestIncPath {
    // longest increasing path in matrix

    // memoization .. O(n*n)
    public static int longestPath(int arr[][], int n, int m,int i,int j, int dp[][]){
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = 0;
        int down = 0;

        // go right
        if(j+1 < m && arr[i][j+1]> arr[i][j]){
            right = longestPath(arr, n, m, i, j+1, dp);
        }

        // go down
        if(i+1<n && arr[i+1][j]> arr[i][j]){
            down = longestPath(arr, n, m, i+1, j, dp);
        }

        dp[i][j] =  Math.max(right, down) +1;
        return dp[i][j];
    }

    // tabulation.. O(n*n)
    public static int longestPathTabu(int arr[][], int n, int m){
        int dp[][] = new int[n][m];

        for(int i = n-1; i>=0; i--){
            for (int j = m-1; j >= 0; j--) {
                // initialize
                if(i == n-1 && j == m-1){
                    dp[i][j] = 1;
                }

                int right = 0;
                int bottom = 0;

                // right
                if(j+1 < m && arr[i][j+1]> arr[i][j]){
                    right = dp[i][j+1];
                }

                // bottom
                if(i+1 < n && arr[i+1][j] > arr[i][j]){
                    bottom = dp[i+1][j];
                }

                dp[i][j] = Math.max(right, bottom) +1;
            }
        }
        

        return dp[0][0];
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int arr[][] = {   { 1, 2, 3, 4 }, 
                        { 2, 2, 3, 4 }, 
                        { 3, 2, 3, 4 }, 
                        { 4, 5, 6, 7 } };
        
        // int n = 2;
        // int m = 2;
        // int arr[][] = {{1,2}, {3,4}};
        
    
        // memoizatioin................
        int dp[][] = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill( row, -1);
            
        }
        // System.out.println(longestPath(arr, n, m, 0, 0, dp));          
        

        // tabulation.............
        System.out.println(longestPathTabu(arr, n, m));

    }

}
