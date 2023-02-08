package DP.DP6;

import java.util.Arrays;

public class MatrixChainMult {
    // matrix chain multiplication...

    //1. recursion
    public static int mcm(int arr[], int i, int j){
        // base
        if(i==j){
            return 0;  //single matrix case
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            // Ai = arr[i-1] X arr[i]
            // Ak = arr[k-1] X arr[k]

            // cost1 -> arr[i-1] X arr[k]
            int cost1 = mcm(arr, i, k);  

            // Ak+1 = arr[k] X arr[k+1]
            // Aj = arr[j-1] X arr[j]

            // cost2-> arr[k] X arr[j]
            int cost2 = mcm(arr, k+1, j);

            int a = arr[i-1];
            int b = arr[k];
            int d = arr[j];

            int cost3 = a*b*d;

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);

        }

        return ans;
    }

    // 2. memoization  .... O(n^2)
    public static int mcmMemo(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            ans = Math.min(ans, cost1 + cost2 + cost3);
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;

        // i = 1; because i is starting cut
        // System.out.println(mcm(arr, 1, n-1));

        // 2. memo
        int dp[][] = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcmMemo(arr, 1, n-1, dp));
    }
}
